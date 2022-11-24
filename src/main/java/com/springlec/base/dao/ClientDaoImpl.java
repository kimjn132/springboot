package com.springlec.base.dao;

import org.apache.ibatis.session.SqlSession;

import com.springlec.base.model.ClientDto;


public class ClientDaoImpl implements ClientDao {

	SqlSession sqlSession;
	
	public static String nameSpace = "com.springlec.base.dao.ClientDao";
	
	@Override
	public void cJoinDao(String cId, String cPw, String cName, String cPhone, String cEmail, String cDate, int zonecode,
			String address, String buildingName, String detailAddress) throws Exception {
		// TODO Auto-generated method stub
		sqlSession.insert(nameSpace + ".cJoinDao");
	}

	@Override
	public ClientDto cLoginDao(String cId, String cPw) throws Exception {
		// TODO Auto-generated method stub
		return (ClientDto) sqlSession.selectList(nameSpace + ".cLoginDao");
	}

	@Override
	public ClientDto cInfoDao(String cId) throws Exception {
		// TODO Auto-generated method stub
		return (ClientDto) sqlSession.selectList(nameSpace + ".cInfoDao");
	}

	@Override
	public void cInfoModifyDao(String cPhone, String cEmail, String cPw, String cName, String zonecode, String address,
			String buildingName, String detailAddress, String cId) throws Exception {
		// TODO Auto-generated method stub
		sqlSession.update(nameSpace + ".cInfoModifyDao");
	}

	@Override
	public void cDeleteDao(String cId) throws Exception {
		// TODO Auto-generated method stub
		sqlSession.update(nameSpace + ".cDeleteDao");
		
	}

	@Override
	public ClientDto cIdFindDao(String cName, String cEmail) throws Exception {
		// TODO Auto-generated method stub
		
		System.out.println("아이디찾기");
		return (ClientDto) sqlSession.selectList(nameSpace + ".cIdFindDao");
	}

	@Override
	public ClientDto cPwFindDao(String cId, String cName, String cEmail) throws Exception {
		// TODO Auto-generated method stub
		return (ClientDto) sqlSession.selectList(nameSpace + ".cPwFindDao");
	}




}
