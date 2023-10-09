package co.kr.ig.mvc.core.dao;

import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.transaction.annotation.Transactional;

public class CoreMapperDAO {
	private SqlSessionTemplate sqlSession;

	public CoreMapperDAO(SqlSessionTemplate session) {
		this.sqlSession = session;
	}

	public List<HashMap<String, Object>> select(String statement, HashMap<String, Object> param) throws SQLException {
		return this.sqlSession.selectList(statement, param);
	}

	public HashMap<String, Object> selectOne(String statement, HashMap<String, Object> param) throws SQLException {
		return this.sqlSession.selectOne(statement, param);
	}

	public int insert(String statement, HashMap<String, Object> param) throws SQLException {
		return this.sqlSession.insert(statement, param);
	}

	public int update(String statement, HashMap<String, Object> param) throws SQLException {
		return this.sqlSession.update(statement, param);
	}

	public int delete(String statement, HashMap<String, Object> param) throws SQLException {
		return this.sqlSession.delete(statement, param);
	}
}
