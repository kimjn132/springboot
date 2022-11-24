package com.springlec.base.service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import com.springlec.base.model.ClientDto;


public interface ClientDaoService {

	public void cJoinDao(HttpServletRequest request) throws Exception;
	public ClientDto cLoginDao(HttpServletRequest request) throws Exception;
	public ClientDto cInfoDao(HttpServletRequest request) throws Exception;
	public void cInfoModifyDao(String cPhone, String cEmail, String cPw, String cName, String zonecode, String address,
			String buildingName, String detailAddress, String cId) throws Exception;
	public void cDeleteDao(String cId) throws Exception;
	public ClientDto cIdFindDao(HttpServletRequest request) throws Exception;
	public ClientDto cPwFindDao(HttpServletRequest request) throws Exception;
	
}
