package com.springlec.base.service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springlec.base.dao.ClientDao;
import com.springlec.base.model.ClientDto;


@Service
public class ClientDaoServiceImpl implements ClientDaoService {

	@Autowired
	ClientDao dao;
	

	@Override
	public void cJoinDao(HttpServletRequest request) throws Exception {
		String cId = request.getParameter("cId");
		String cPw = request.getParameter("cPw");
		String cName = request.getParameter("cName");
		String cPhone = request.getParameter("cPhone");
		String cEmail = request.getParameter("cEmail");
		String cDate = request.getParameter("cDate");
		int zonecode = Integer.parseInt(request.getParameter("zonecode"));
		String address = request.getParameter("address");
		String buildingName = request.getParameter("buildingName");
		String detailAddress = request.getParameter("detailAddress");

		dao.cJoinDao(cId, cPw, cName, cPhone, cEmail, cDate, zonecode, address, buildingName, detailAddress);
	}

	@Override
	public ClientDto cLoginDao(HttpServletRequest request) throws Exception {

		String cId = request.getParameter("cId");
		String cPw = request.getParameter("cPw");
		


		return dao.cLoginDao(cId, cPw);
	}

	@Override
	public ClientDto cInfoDao(HttpServletRequest request) throws Exception {
		HttpSession session = request.getSession();
		String cId = (String) session.getAttribute("CID");
		return dao.cInfoDao(cId);
	}

	@Override
	public void cInfoModifyDao(String cPhone, String cEmail, String cPw, String cName, String zonecode, String address,
			String buildingName, String detailAddress, String cId) throws Exception {
		// TODO Auto-generated method stub
		dao.cInfoModifyDao(cPhone, cEmail, cPw, cName, zonecode, address, buildingName, detailAddress, cId);
		
	}
	@Override
	public void cDeleteDao(String cId) throws Exception {
		// TODO Auto-generated method stub
		dao.cDeleteDao(cId);
	}

	@Override
	public ClientDto cIdFindDao(HttpServletRequest request) throws Exception {
		String cName = request.getParameter("cName");
		String cEmail = request.getParameter("cEmail");

		
		System.out.println("serviceimple : " + cName);
		System.out.println("serviceimple : " + cEmail);
		
		return dao.cIdFindDao(cName, cEmail);
	}

	@Override
	public ClientDto cPwFindDao(HttpServletRequest request) throws Exception {
		String cId = request.getParameter("cId");
		String cName = request.getParameter("cName");
		String cEmail = request.getParameter("cEmail");

		return dao.cPwFindDao(cId, cName, cEmail);
	}



	

}
