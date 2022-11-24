package com.springlec.base.service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springlec.base.dao.BCBookDao;
import com.springlec.base.model.checkdate2Dto;
import com.springlec.base.model.roomDto;
@Service
public class BCBookDaoServiceImpl implements BCBookDaoService {

	@Autowired
	BCBookDao dao;
	
	@Override
	public checkdate2Dto confirmation(HttpServletRequest request) throws Exception {
		HttpSession session = request.getSession();
		String regName = request.getParameter("regName");
		String roNum = request.getParameter("roNum");
		session.setAttribute("RONUM",roNum);
		System.out.println("regName:"+regName+":");
		System.out.println("roNum:"+roNum+":");
		
		return dao.confirmation(Integer.parseInt(roNum), regName);
	}

	@Override
	public roomDto readRoom(HttpServletRequest request) throws Exception {
		HttpSession session = request.getSession();
		String regSeq = (String)session.getAttribute("REGSEQ");
		String roNum = (String)session.getAttribute("RONUM");
		System.out.println("readRoom - REGSEQ:"+regSeq+":");
		System.out.println("readRoom - RONUM:"+roNum+":");
		return dao.readRoom(regSeq,roNum);
	}

	@Override
	public int diffDate(HttpServletRequest request) throws Exception {
		HttpSession session = request.getSession();
		String startdate = (String)session.getAttribute("STARTDATE");
		String stopdate = (String)session.getAttribute("STOPDATE");
		System.out.println("startdate:"+startdate+":");
		System.out.println("stopdate:"+stopdate+":");
		return dao.diffDate(startdate,stopdate);
	}

}
