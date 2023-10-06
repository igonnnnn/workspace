package co.kr.demo.core.dao;

import java.util.HashMap;

import org.apache.ibatis.session.SqlSession;

public class CoreDAO {
	private final SqlSession sqlSession;

	public CoreDAO(SqlSession sqlSession) {
		this.sqlSession = sqlSession;
	}

	public SqlSession getSession() {
		return this.sqlSession;
	}

	public void service() {
		String item = "RS";

		switch(item) {
			case "R":
				this.sqlSession.selectList("", new HashMap<String, Object>());
				break;
			case "C":
				this.sqlSession.selectList("", new HashMap<String, Object>());
				break;
			case "U":
				this.sqlSession.selectList("", new HashMap<String, Object>());
				break;
			case "D":
				this.sqlSession.selectList("", new HashMap<String, Object>());
				break;
		}
	}
}
