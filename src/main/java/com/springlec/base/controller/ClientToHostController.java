package com.springlec.base.controller;

import java.io.File;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import com.springlec.base.model.ClientDto;
import com.springlec.base.model.HostDto;
import com.springlec.base.service.ClientToHostDaoService;

@Controller
public class ClientToHostController {

	@Autowired
	ClientToHostDaoService service;
	@Autowired
	HttpSession session;

	// 호스트 가입여부 체크
	@RequestMapping("/hostCheck")
	public String hostCheck(HttpServletRequest request) throws Exception {

		int hCheck = service.hostCheckDao(request.getParameter("cId"));

		if (hCheck == 0) {
			return "HostTerms";
		} else {
			return "HostMain";
		}
	}

	// 호스트 가입에 따른 페이지 이동
	@RequestMapping("/termsAD")
	public String termsAd(HttpServletRequest request) throws Exception {

		String agree = request.getParameter("agree");

		if (agree.equals("agree")) {
			return "TermsAgree";
		} else {
			return "redirect:cHomeList";
		}

	}

	// 호스트 가입 위해 클라이언트 정보 가져오기
	@RequestMapping("/showC")
	public String cShowDao(HttpServletRequest request, Model model) throws Exception {

		String hId = request.getParameter("cId");
		ClientDto clientShow = service.cShowDao(hId);
		model.addAttribute("mypage", clientShow);
		System.out.println("호스트로가입위한 클라이언트 정보 불러오기 : " + clientShow);
		session.setAttribute("HID", hId);

		System.out.println("세션 :" + hId);

		return "hostJoin";

	}

	// 호스트 가입 insert
	@RequestMapping("/hJoin")
	public String hJoin(HttpServletRequest request) throws Exception {
		service.hInsertDao(request);
		System.out.println("호스트가입 확인");

		return "uploadImage";
	}

	// 호스트 이미지 서버 저장
	@RequestMapping("/save")
	public String hImage(Model model, MultipartHttpServletRequest request, MultipartFile file) throws Exception {
		System.out.println("파일");

		String originalName = "";

		if (!(file == null)) {
			String path = System.getProperty("user.dir") + "//src//main//webapp//images";
			System.out.println(path);
			// 파일을 uid로 만들기 위한 기초단계
			// 확장자 가져오기
			originalName = file.getOriginalFilename();
//			String extension = originalName.substring(originalName.indexOf("."), originalName.length());

			// 패스에 "name" 으로 saveFile을 만들 빈 껍데기를 생성해 준다.
			File saveFile = new File(path, originalName);
			// file을 saveFile이름과 path로 지어서 넣기
			file.transferTo(saveFile);

		}

//		request.setAttribute("hImage", originalName);

		service.hImageDao(originalName);

		return "redirect:file";
	}

	@RequestMapping("/file")
	public String hImageUp(Model model, HttpServletRequest request) throws Exception {

		HostDto hostShow = service.showHostDao(request.getParameter("hId1"));
		model.addAttribute("fileView", hostShow);

		System.out.println("가입 후 보여주기" + hostShow);

		return "fileShow";
	}
	
	@RequestMapping("/hostMain")
	public String gotoMain() throws Exception {
		
		return "HostMain";
	}

}
