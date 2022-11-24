package com.springlec.base.dao;

import java.util.List;

import com.springlec.base.model.BookJoinDto;
import com.springlec.base.model.campDto;
import com.springlec.base.model.roomDto;

public interface CampDao {
	public List<campDto> listCamp(String regSeq) throws Exception;
	public List<campDto> dateCheck(int regSeq, String startdate, String stopdate) throws Exception;
	public int readMaxSeq() throws Exception;
	public int diffDate(String startdate, String stopdate) throws Exception;
	public String Nextday(String Startdate) throws Exception;
	public int insertPay(String strRd,int room_roSeq, int room_regcamp_regSeq, int room_regcamp_host_hseq, String client_cId) throws Exception;
	public int insertBook(int boPrice, String boCheckindate, int boGroup, int boCount, String cId, int roseq, String client_cId, int regSeq, int host_hSeq) throws Exception;
	public void updateBook(int boGroup)throws Exception;
	public int readRoomPrice(int regSeq, int roNum)throws Exception;
	public roomDto readRoom(String regSeq, String roNum)throws Exception;
	public List<BookJoinDto> ViewBooking(String cId) throws Exception;

}


