package com.springlec.base.service;

import javax.servlet.http.HttpServletRequest;

import com.springlec.base.model.ClientDto;
import com.springlec.base.model.regcampDto;
import com.springlec.base.model.reviewDto;

public interface ReviewDaoService {
	public reviewDto reviewDetailDao(int rvSeq) throws Exception;
	public void reviewWriteDao(HttpServletRequest request) throws Exception;
	public regcampDto regcampDetailDao(int regSeq) throws Exception;
	public ClientDto reviewerDao(String cId) throws Exception;
}
