package com.springlec.base.dao;

import org.apache.ibatis.session.SqlSession;

import com.springlec.base.model.regcampDto;

public class AskDaoImpl implements AskDao {

	SqlSession sqlSession;
	
	public static String nameSpace = "com.springlec.base.dao.AskDao";
	

	
	@Override
	public void askDao(String aCId, String aTitle, String aContent, int aRegSeq) throws Exception {
		// TODO Auto-generated method stub
		sqlSession.insert(nameSpace + ".askDao");
	}




	

}
