package com.springlec.base.service;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import com.springlec.base.model.BookJoinDto;
import com.springlec.base.model.campDto;
import com.springlec.base.model.roomDto;

public interface CampDaoService {
	public List<campDto> listCamp(HttpServletRequest request) throws Exception;
	public List<campDto> dateCheck(HttpServletRequest request) throws Exception;
	public int readMaxSeq() throws Exception;
	public int diffDate(String startdate, String stopdate) throws Exception;
	public String Nextday(String Startdate) throws Exception;
	public int insertPay(String strRd, int room_roSeq, int room_regcamp_regSeq, int room_regcamp_host_hseq, String client_cId) throws Exception;
	public int insertBook(int boPrice, String boCheckindate, int boGroup, int boCount, String cId, int roseq, String client_cId, int regSeq, int host_hSeq) throws Exception;
	public void updateBook(int boGroup)throws Exception;
	public int readRoomPrice(String regcamp_regSeq, String roNum)throws Exception;
	public roomDto readRoom(HttpServletRequest request)throws Exception;
	public List<BookJoinDto> ViewBooking(String cId) throws Exception;
}
