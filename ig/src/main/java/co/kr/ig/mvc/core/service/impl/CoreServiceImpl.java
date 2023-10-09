package co.kr.ig.mvc.core.service.impl;

import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;

import co.kr.ig.mvc.core.constants.CoreConstants;
import co.kr.ig.mvc.core.dao.CoreMapperDAO;
import co.kr.ig.mvc.core.dto.InputDTO;
import co.kr.ig.mvc.core.dto.OutputDTO;
import co.kr.ig.mvc.core.service.CoreService;

public class CoreServiceImpl implements CoreService {
	private Map<String, String> mapper;

	@Autowired
	private CoreMapperDAO coreMapper;

	public void setMapper(Map<String, String> mapper) {
		this.mapper = mapper;
	}

	@Override
	public OutputDTO transaction(InputDTO iDto) throws SQLException {
		OutputDTO output = new OutputDTO();

		switch(iDto.getTransDv()) {
			case CoreConstants.TRANS_DV_CREATE:
				this.insert(iDto.getDaoDv(), iDto.getStatement(), iDto.getSendDataset());
				break;
			case CoreConstants.TRANS_DV_UPDATE:
				this.update(iDto.getDaoDv(), iDto.getStatement(), iDto.getSendDataset());
				break;
			case CoreConstants.TRANS_DV_DELETE:
				this.delete(iDto.getDaoDv(), iDto.getStatement(), iDto.getSendDataset());
				break;
			default:
				List<HashMap<String, Object>> list = this.select(iDto.getDaoDv(), iDto.getStatement(), iDto.getSendDataset());
				break;
		}
		return output;
	}

	public HashMap<String, Object> selectOne(String statement, HashMap<String, Object> map) throws SQLException {
		return coreMapper.selectOne(statement, map);
	};
	public List<HashMap<String, Object>> select(String statement, HashMap<String, Object> map) throws SQLException {
		return coreMapper.select(statement, map);
	};
	public int insert(String statement, HashMap<String, Object> map) throws SQLException {
		return coreMapper.insert(statement, map);
	};
	public int update(String statement, HashMap<String, Object> map) throws SQLException {
		return coreMapper.update(statement, map);
	};
	public int delete(String statement, HashMap<String, Object> map) throws SQLException {
		return coreMapper.delete(statement, map);
	}; 
}
