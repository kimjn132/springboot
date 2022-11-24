package com.springlec.base.dao;

import org.apache.ibatis.session.SqlSession;

import com.springlec.base.model.ClientDto;
import com.springlec.base.model.reviewDto;

public class ReviewDaoImpl implements ReviewDao {
	
	SqlSession sqlSession;
	
	public static String nameSpace = "com.springlec.base.dao.ReviewDao";

	@Override
	public reviewDto reviewDetailDao(int rvSeq) throws Exception {
		// TODO Auto-generated method stub
		return (reviewDto) sqlSession.selectList(nameSpace + ".reviewDetailDao");
	}

	@Override
	public void reviewWriteDao(String rvCId, String rvCName, String rvTitle, String rvContent, int rvStar,
			int regcamp_regSeq, int regcamp_host_hSeq) throws Exception {
		// TODO Auto-generated method stub
		sqlSession.insert(nameSpace + ".reviewWriteDao");
	}

	@Override
	public ClientDto reviewerDao(String cId) throws Exception {
		// TODO Auto-generated method stub
		return (ClientDto) sqlSession.selectList(nameSpace + ".reviewerDao");
	}

}
