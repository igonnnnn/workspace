package co.kr.demo.core.service;

import co.kr.demo.core.dao.CoreDAO;

public interface CoreService {
	public void select(CoreDAO dao);

	public void selectOne(CoreDAO dao);

	public void insert(CoreDAO dao);

	public void update(CoreDAO dao);

	public void delete(CoreDAO dao);
}
