package com.springlec.base.dao;

import com.springlec.base.model.ClientDto;
import com.springlec.base.model.reviewDto;

public interface ReviewDao {
	
	public reviewDto reviewDetailDao(int rvSeq) throws Exception;
	public void reviewWriteDao(String rvCId, String rvCName, String rvTitle, String rvContent, 
			int rvStar, int regcamp_regSeq, int regcamp_host_hSeq) throws Exception;
	public ClientDto reviewerDao(String cId) throws Exception;

}
