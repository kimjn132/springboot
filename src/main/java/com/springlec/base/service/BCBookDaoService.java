package com.springlec.base.service;

import javax.servlet.http.HttpServletRequest;

import com.springlec.base.model.checkdate2Dto;
import com.springlec.base.model.roomDto;

public interface BCBookDaoService {
	//public ArrayList<roomDto> SelectDate(String reSeq)throws Exception;
	public checkdate2Dto confirmation(HttpServletRequest request)throws Exception;  
	public roomDto readRoom(HttpServletRequest request) throws Exception ;
	public int diffDate(HttpServletRequest request) throws Exception;
}
