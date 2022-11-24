package com.springlec.base.service;

import java.io.File;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import com.springlec.base.dao.ClientToHostDao;
import com.springlec.base.model.ClientDto;
import com.springlec.base.model.HostDto;

@Service
public class ClientToHostDaoServiceImpl implements ClientToHostDaoService {

	@Autowired
	ClientToHostDao dao;
	@Autowired
	HttpSession session;

	@Override
	public int hostCheckDao(String cId) throws Exception {

		return dao.hostCheckDao(cId);
	}

	@Override
	public ClientDto cShowDao(String cId) throws Exception {

		return dao.cShowDao(cId);
	}

	@Override
	public void hInsertDao(HttpServletRequest request) throws Exception {
		// TODO Auto-generated method stub

		String hId = (String) session.getAttribute("HID");

		String hSummary = request.getParameter("hSummary");

		System.out.println("서비스 세션 :" + hId);

		dao.hInsertDao(hId, hSummary);

	}

	@Override
	public void hImageDao(String hImage) throws Exception {

//		String originalName = "";
//
//		if (!(file == null)) {
//			String path = System.getProperty("user.dir") + "//src//main//webapp//images";
//			System.out.println(path);
//			// 파일을 uid로 만들기 위한 기초단계
//			// 확장자 가져오기
//			originalName = file.getOriginalFilename();
////			String extension = originalName.substring(originalName.indexOf("."), originalName.length());
//
//			// 패스에 "name" 으로 saveFile을 만들 빈 껍데기를 생성해 준다.
//			File saveFile = new File(path, originalName);
//			// file을 saveFile이름과 path로 지어서 넣기
//			file.transferTo(saveFile);
//			System.out.println(saveFile);
//			
//		}
//		
//		model.addAttribute("hImage", originalName);
//		
//		System.out.println(originalName);
//		
//		String hImage = request.getParameter("hImage");
//		String hId = request.getParameter("hId");
//		
//		System.out.println(hImage);
//		System.out.println(hId);

		String hId = (String) session.getAttribute("HID");

		dao.hImageDao(hImage, hId);

	}

	@Override
	public HostDto showHostDao(String hId) throws Exception {

		String hId1 = (String) session.getAttribute("HID");

		return dao.showHostDao(hId1);
	}

}
