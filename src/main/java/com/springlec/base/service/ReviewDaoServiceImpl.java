package com.springlec.base.service;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springlec.base.dao.RegcampDao;
import com.springlec.base.dao.ReviewDao;
import com.springlec.base.model.ClientDto;
import com.springlec.base.model.regcampDto;
import com.springlec.base.model.reviewDto;

@Service
public class ReviewDaoServiceImpl implements ReviewDaoService {

	
	@Autowired
	ReviewDao dao;
	
	@Autowired
	RegcampDao dao1;
	

	@Override
	public reviewDto reviewDetailDao(int rvSeq) throws Exception {
		// TODO Auto-generated method stub
		return dao.reviewDetailDao(rvSeq);
	}

	@Override
	public regcampDto regcampDetailDao(int regSeq) throws Exception {
		// TODO Auto-generated method stub
		System.out.println("regcamp dao1");
		return dao1.regcampDetailDao(regSeq);
	}

	@Override
	public void reviewWriteDao(HttpServletRequest request) throws Exception {
		// TODO Auto-generated method stub
		String rvCId = request.getParameter("rvCId");
		String rvCName = request.getParameter("rvCName");
		String rvTitle = request.getParameter("rvTitle");
		String rvContent = request.getParameter("rvContent");
		int rvStar = Integer.parseInt(request.getParameter("rvStar"));
		int regcamp_regSeq = Integer.parseInt(request.getParameter("regcamp_regSeq"));
		int regcamp_host_hSeq = Integer.parseInt(request.getParameter("regcamp_host_hSeq"));
		
		dao.reviewWriteDao(rvCId, rvCName, rvTitle, rvContent, rvStar, regcamp_regSeq, regcamp_host_hSeq);
		
	}

	@Override
	public ClientDto reviewerDao(String cId) throws Exception {
		// TODO Auto-generated method stub
		return dao.reviewerDao(cId);
	}
	
}
