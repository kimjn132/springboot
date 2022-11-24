package com.springlec.base.service;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springlec.base.dao.RegcampDao;
import com.springlec.base.model.FacilityDto;
import com.springlec.base.model.KeyDto;
import com.springlec.base.model.MyregcampDto;
import com.springlec.base.model.regcampDto;
import com.springlec.base.model.reviewDto;
@Service
public class RegcampDaoServiceImpl implements RegcampDaoService {

	@Autowired
	RegcampDao dao;

	@Override
	public List<regcampDto> regcampDao() throws Exception {
		// TODO Auto-generated method stub
		return dao.regcampDao();
	}

	@Override
	public regcampDto regcampDetailDao(int regSeq) throws Exception {
		// TODO Auto-generated method stub
		return dao.regcampDetailDao(regSeq);
	}

	@Override
	public List<reviewDto> reviewDao(int regSeq) throws Exception {
		// TODO Auto-generated method stub
		return dao.reviewDao(regSeq);
	}

	@Override
	public reviewDto reviewAvgDao(int regSeq) throws Exception {
		// TODO Auto-generated method stub
		return dao.reviewAvgDao(regSeq);
	}

	@Override
	public MyregcampDto regcampImageDao(int regSeq) throws Exception {
		// TODO Auto-generated method stub
		return dao.regcampImageDao(regSeq);
	}

	@Override
	public List<FacilityDto> regcampFacilityDao(int regSeq) throws Exception {
		// TODO Auto-generated method stub
		return dao.regcampFacilityDao(regSeq);
	}

	@Override
	public List<KeyDto> regcampKeyDao(int regSeq) throws Exception {
		// TODO Auto-generated method stub
		return dao.regcampKeyDao(regSeq);
	}

	@Override
	public List<regcampDto> regcampSearchDao(String query, String content) throws Exception {
		content = '%'+content+'%';
		return dao.regcampSearchDao(query, content);
	}


	

}
