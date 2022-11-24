package com.springlec.base.dao;

import com.springlec.base.model.ClientDto;


public interface ClientDao {
	
	public void cJoinDao(String cId, String cPw, String cName, String cPhone, String cEmail, String cDate, int zonecode, String address, String buildingName, String detailAddress) throws Exception;
	public ClientDto cLoginDao(String cId, String cPw) throws Exception;
	public ClientDto cInfoDao(String cId) throws Exception;
	public void cInfoModifyDao(String cPhone, String cEmail, String cPw, String cName, String zonecode, String address, String buildingName, String detailAddress, String cId) throws Exception;
	public void cDeleteDao(String cId) throws Exception;
	public ClientDto cIdFindDao(String cName, String cEmail) throws Exception;
	public ClientDto cPwFindDao(String cId, String cName, String cEmail) throws Exception;
	
}
