package com.springlec.base.service;

import javax.servlet.http.HttpServletRequest;

import com.springlec.base.model.regcampDto;

public interface AskDaoService {

	
	public void askDao(HttpServletRequest request) throws Exception;
	public regcampDto regcampDetailDao(int regSeq) throws Exception;
}
