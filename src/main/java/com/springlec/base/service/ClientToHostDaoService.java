package com.springlec.base.service;

import javax.servlet.http.HttpServletRequest;

import com.springlec.base.model.ClientDto;
import com.springlec.base.model.HostDto;

public interface ClientToHostDaoService {

	public int hostCheckDao(String cId) throws Exception;

	public ClientDto cShowDao(String cId) throws Exception;

	public void hInsertDao(HttpServletRequest request) throws Exception;

	public void hImageDao(String hImage) throws Exception;

	public HostDto showHostDao(String hId) throws Exception;

}
