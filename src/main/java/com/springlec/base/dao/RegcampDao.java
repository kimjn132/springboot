package com.springlec.base.dao;

import java.util.List;

import com.springlec.base.model.FacilityDto;
import com.springlec.base.model.KeyDto;
import com.springlec.base.model.MyregcampDto;
import com.springlec.base.model.regcampDto;
import com.springlec.base.model.reviewDto;

public interface RegcampDao {
	public  List<regcampDto> regcampDao() throws Exception;
	public regcampDto regcampDetailDao(int regSeq) throws Exception;
	public List<reviewDto> reviewDao(int regSeq) throws Exception;
	public reviewDto reviewAvgDao(int regSeq) throws Exception;
	public MyregcampDto regcampImageDao(int regSeq) throws Exception;
	public List<FacilityDto> regcampFacilityDao(int regSeq) throws Exception;
	public List<KeyDto> regcampKeyDao(int regSeq) throws Exception;
	public List<regcampDto> regcampSearchDao(String query, String content) throws Exception;
	
}
