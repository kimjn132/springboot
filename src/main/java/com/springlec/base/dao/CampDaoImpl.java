package com.springlec.base.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.springlec.base.model.BookJoinDto;
import com.springlec.base.model.campDto;
import com.springlec.base.model.roomDto;

public class CampDaoImpl implements CampDao {
	
	SqlSession sqlSession;
	
	public static String nameSpace = "com.springlec.base.dao.CampDao";
	@Override
	public List<campDto> listCamp(String regSeq) throws Exception {
		return sqlSession.selectList(nameSpace + ".listCamp");
	}

	@Override
	public List<campDto> dateCheck(int strregSeq, String startdate, String stopdate) throws Exception {
		return sqlSession.selectList(nameSpace + ".dateCheck");
	}

	@Override
	public int readMaxSeq() throws Exception {
		return sqlSession.selectOne(nameSpace + ".readMaxSeq");
	}

	@Override
	public int diffDate(String startdate, String stopdate) throws Exception {
		return sqlSession.selectOne(nameSpace + ".diffDate");
	}

	@Override
	public String Nextday(String Startdate) throws Exception {
		return sqlSession.selectOne(nameSpace + ".Nextday");
	}

	@Override
	public int insertPay(String strRd, int room_roSeq, int room_regcamp_regSeq, int room_regcamp_host_hseq,
			String client_cId) throws Exception {
		return sqlSession.selectOne(nameSpace + ".insertPay");
	}

	@Override
	public int insertBook(int boPrice, String boCheckindate, int boGroup, int boCount, String cId, int roseq,
			String client_cId, int regSeq, int host_hSeq) throws Exception {
		return sqlSession.selectOne(nameSpace + ".insertBook");
	}

	@Override
	public void updateBook(int boGroup) throws Exception {
		sqlSession.selectOne(nameSpace + ".updateBook");
	}

	@Override
	public int readRoomPrice(int regSeq, int roNum) throws Exception {
		return sqlSession.selectOne(nameSpace + ".readRoomPrice");
	}

	@Override
	public roomDto readRoom(String regSeq, String roNum) throws Exception {
		return sqlSession.selectOne(nameSpace + ".readRoom");
	}

	@Override
	public List<BookJoinDto> ViewBooking(String cId) throws Exception {
		return sqlSession.selectList(nameSpace + ".ViewBooking");
	}

}
