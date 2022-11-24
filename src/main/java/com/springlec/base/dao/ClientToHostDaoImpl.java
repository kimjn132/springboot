package com.springlec.base.dao;

import org.apache.ibatis.session.SqlSession;

import com.springlec.base.model.ClientDto;
import com.springlec.base.model.HostDto;

public class ClientToHostDaoImpl implements ClientToHostDao {

	SqlSession sqlSession;

	public static String nameSpace = "com.springlec.base.dao.ClientToHostDao";

	@Override
	public int hostCheckDao(String cId) throws Exception {

		return sqlSession.selectOne(nameSpace + ".hostCheckDao");
	}

	@Override
	public ClientDto cShowDao(String cId) throws Exception {
		// TODO Auto-generated method stub
		return (ClientDto) sqlSession.selectList(nameSpace + ".cShowDao");
	}

	@Override
	public void hInsertDao(String hId, String hSummary) throws Exception {
		// TODO Auto-generated method stub
		sqlSession.insert(nameSpace + ".hInsertDao");
	}

	@Override
	public void hImageDao(String hImage, String hId) throws Exception {
		// TODO Auto-generated method stub
		sqlSession.update(nameSpace + ".hImageDao");
	}

	@Override
	public HostDto showHostDao(String hId) throws Exception {
		// TODO Auto-generated method stub
		return (HostDto) sqlSession.selectList(nameSpace + ".showHostDao");
	}

}
