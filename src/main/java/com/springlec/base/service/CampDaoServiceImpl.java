package com.springlec.base.service;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springlec.base.dao.CampDao;
import com.springlec.base.model.BookJoinDto;
import com.springlec.base.model.campDto;
import com.springlec.base.model.roomDto;
@Service
public class CampDaoServiceImpl implements CampDaoService {

	@Autowired
	CampDao dao;
		
	@Override
	public List<campDto> listCamp(HttpServletRequest request) throws Exception {
		String regSeq = request.getParameter("regSeq");
		return dao.listCamp(regSeq);
	}

	@Override
	public List<campDto> dateCheck(HttpServletRequest request) throws Exception {
		HttpSession session = request.getSession();
		String regSeq = (String)session.getAttribute("REGSEQ");
		String startdate = request.getParameter("startdate");
		String stopdate = request.getParameter("stopdate");
			
		return dao.dateCheck(Integer.parseInt(regSeq), startdate, stopdate);
	}

	@Override
	public int readMaxSeq() throws Exception {
		return dao.readMaxSeq();
	}

	@Override
	public int diffDate(String startdate, String stopdate) throws Exception {
		return dao.diffDate(startdate,stopdate);
	}

	@Override
	public String Nextday(String Startdate) throws Exception {
//		String startdate = request.getParameter("startdate");		
		return dao.Nextday(Startdate);
	}

	@Override
	public int insertPay(String strRd, int room_roSeq, int room_regcamp_regSeq, int room_regcamp_host_hseq, String client_cId) throws Exception {
		System.out.println("strRd"+strRd);
		System.out.println("room_roSeq"+room_roSeq);
		System.out.println("room_regcamp_regSeq"+room_regcamp_regSeq);
		System.out.println("room_regcamp_host_hseq"+room_regcamp_host_hseq);
		System.out.println("client_cId"+client_cId);
		return dao.insertPay(strRd, room_roSeq, room_regcamp_regSeq, room_regcamp_host_hseq, client_cId);
	}

	@Override
	public int insertBook(int boPrice, String boCheckindate, int boGroup, int boCount, String cId, int roseq, String client_cId, int regSeq, int host_hSeq) throws Exception{
//		int boPrice = Integer.parseInt(request.getParameter("boPrice"));	
//		String boCheckindate = request.getParameter("boCheckindate");	
//		int boGroup = Integer.parseInt(request.getParameter("boGroup"));	
//		int boCount = Integer.parseInt(request.getParameter("boCount"));	
//		String cId = request.getParameter("cId");	
//		int roseq = Integer.parseInt(request.getParameter("roseq"));
//		String client_cId = request.getParameter("client_cId");	
//		int regSeq = Integer.parseInt(request.getParameter("regSeq"));	
//		int host_hSeq = Integer.parseInt(request.getParameter("host_hSeq"));
		System.out.println("boPrice"+boPrice);
		System.out.println("boCheckindate"+boCheckindate);
		System.out.println("boGroup"+boGroup);
		System.out.println("boCount"+boCount);
		System.out.println("cId"+cId);
		System.out.println("roseq"+roseq);
		System.out.println("client_cId"+client_cId);
		System.out.println("regSeq"+regSeq);
		System.out.println("host_hSeq"+host_hSeq);
		
		return dao.insertBook(boPrice,boCheckindate,boGroup,boCount, cId, roseq, client_cId, regSeq, host_hSeq);
	}

	@Override
	public void updateBook(int boGroup) throws Exception {
//		int boGroup = Integer.parseInt(request.getParameter("boGroup"));	
		dao.updateBook(boGroup);

	}

	@Override
	public int readRoomPrice(String regSeq, String roNum)throws Exception{
//		String regcamp_regSeq = request.getParameter("regcamp_regSeq");
//		String roNum = request.getParameter("roNum");
		return dao.readRoomPrice(Integer.parseInt(regSeq), Integer.parseInt(roNum));
	}

	@Override
	public roomDto readRoom(HttpServletRequest request) throws Exception {
		HttpSession session = request.getSession();
		String regSeq = (String)session.getAttribute("REGSEQ");
		String roNum = (String)session.getAttribute("RONUM");
		System.out.println("REGSEQ"+regSeq);
		System.out.println("RONUM"+roNum);
		return dao.readRoom(regSeq, roNum);
	}

	@Override
	public List<BookJoinDto> ViewBooking(String cId) throws Exception {
//		HttpSession session = request.getSession();
//		String cId = (String)session.getAttribute("CID");
		return dao.ViewBooking(cId);
	}

}
