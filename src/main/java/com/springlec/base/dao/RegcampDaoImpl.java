package com.springlec.base.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.springlec.base.model.FacilityDto;
import com.springlec.base.model.KeyDto;
import com.springlec.base.model.MyregcampDto;
import com.springlec.base.model.regcampDto;
import com.springlec.base.model.reviewDto;

public class RegcampDaoImpl implements RegcampDao {

	SqlSession sqlSession;

	public static String nameSpace = "com.springlec.base.dao.RegcampDao";

	@Override
	public List<regcampDto> regcampDao() throws Exception {
		// TODO Auto-generated method stub
		return sqlSession.selectList(nameSpace + ".regcampDao");
	}

	@Override
	public regcampDto regcampDetailDao(int regSeq) throws Exception {
		// TODO Auto-generated method stub
		return (regcampDto) sqlSession.selectList(nameSpace + ".regcampDetailDao");
	}

	@Override
	public List<reviewDto> reviewDao(int regSeq) throws Exception {
		// TODO Auto-generated method stub
		return sqlSession.selectList(nameSpace + ".reviewDao");
	}

	@Override
	public reviewDto reviewAvgDao(int regSeq) throws Exception {
		// TODO Auto-generated method stub
		return (reviewDto) sqlSession.selectList(nameSpace + ".reviewAvgDao");
	}

	
	@Override
	public MyregcampDto regcampImageDao(int regSeq) throws Exception {
		// TODO Auto-generated method stub
		return (MyregcampDto) sqlSession.selectList(nameSpace + ".regcampImageDao");
	}

	@Override
	public List<FacilityDto> regcampFacilityDao(int regSeq) throws Exception {
		// TODO Auto-generated method stub
		return sqlSession.selectList(nameSpace + ".regcampFacilityDao");
	}

	@Override
	public List<KeyDto> regcampKeyDao(int regSeq) throws Exception {
		// TODO Auto-generated method stub
		return sqlSession.selectList(nameSpace + ".regcampKeyDao");
	}

	@Override
	public List<regcampDto> regcampSearchDao(String query, String content) throws Exception {
		// TODO Auto-generated method stub
		return sqlSession.selectList(nameSpace + ".regcampSearchDao");

	}

	


}
