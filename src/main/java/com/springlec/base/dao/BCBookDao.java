package com.springlec.base.dao;

import com.springlec.base.model.checkdate2Dto;
import com.springlec.base.model.roomDto;

public interface BCBookDao {

	//public ArrayList<roomDto> SelectDate(String reSeq)throws Exception;
	public checkdate2Dto confirmation(int roNum, String regName)throws Exception;  
	public roomDto readRoom(String regSeq, String roNum);
	public int diffDate(String startdate, String stopdate) throws Exception;
}
