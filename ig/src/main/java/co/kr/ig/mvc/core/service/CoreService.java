package co.kr.ig.mvc.core.service;

import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import co.kr.ig.mvc.config.AppConfig;
import co.kr.ig.mvc.config.DataSourceConfig;
import co.kr.ig.mvc.config.MybatisConfig;
import co.kr.ig.mvc.core.dao.CoreMapperDAO;
import co.kr.ig.mvc.core.dto.InputDTO;
import co.kr.ig.mvc.core.dto.OutputDTO;

public interface CoreService {
	default CoreMapperDAO getMapper(String mapper) {
		ApplicationContext appContext = new AnnotationConfigApplicationContext(DataSourceConfig.class);
		return appContext.getBean(mapper, CoreMapperDAO.class);
	}

	default HashMap<String, Object> selectOne(String mapKey, String statement, HashMap<String, Object> map) throws SQLException {
		return getMapper(mapKey).selectOne(statement, map);
	};
	default List<HashMap<String, Object>> select(String mapKey, String statement, HashMap<String, Object> map) throws SQLException {
		return getMapper(mapKey).select(statement, map);
	};
	default int insert(String mapKey, String statement, HashMap<String, Object> map) throws SQLException {
		return getMapper(mapKey).insert(statement, map);
	};
	default int update(String mapKey, String statement, HashMap<String, Object> map) throws SQLException {
		return getMapper(mapKey).update(statement, map);
	};
	default int delete(String mapKey, String statement, HashMap<String, Object> map) throws SQLException {
		return getMapper(mapKey).delete(statement, map);
	};
	

	public OutputDTO transaction(InputDTO iDto) throws SQLException;
}
