package com.springlec.base.service;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springlec.base.dao.AskDao;
import com.springlec.base.dao.RegcampDao;
import com.springlec.base.model.regcampDto;

@Service
public class AskDaoServiceImpl implements AskDaoService {

	
	@Autowired
	AskDao dao;
	
	@Autowired
	RegcampDao dao2;
	
	@Override
	public void askDao(HttpServletRequest request) throws Exception {

		String aCId = request.getParameter("aCId");
		String aTitle = request.getParameter("aTitle");
		String aContent = request.getParameter("aContent");
		int aRegSeq = Integer.parseInt(request.getParameter("aRegSeq"));
		
		
		dao.askDao(aCId, aTitle, aContent, aRegSeq);
		System.out.println("aCId");
	}

	
	@Override
	public regcampDto regcampDetailDao(int regSeq) throws Exception {
		// TODO Auto-generated method stub
		return dao2.regcampDetailDao(regSeq);
	}
	

}
