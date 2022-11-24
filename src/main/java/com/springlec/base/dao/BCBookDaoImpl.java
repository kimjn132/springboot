package com.springlec.base.dao;

import org.apache.ibatis.session.SqlSession;

import com.springlec.base.model.checkdate2Dto;
import com.springlec.base.model.roomDto;

public class BCBookDaoImpl implements BCBookDao {
	
	SqlSession sqlSession;
	public static String nameSpace = "com.springlec.base.dao.BCBookDao";
	
	@Override
	public checkdate2Dto confirmation(int roNum, String regName) throws Exception {
		return sqlSession.selectOne(nameSpace + ".confirmation");
	}

	@Override
	public roomDto readRoom(String regSeq, String roNum) {
		return sqlSession.selectOne(nameSpace + ".readRoom");
	}

	@Override
	public int diffDate(String startdate, String stopdate) throws Exception {
		return sqlSession.selectOne(nameSpace + ".diffDate");
	}

}
