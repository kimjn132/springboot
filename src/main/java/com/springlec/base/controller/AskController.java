package com.springlec.base.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.springlec.base.model.regcampDto;
import com.springlec.base.service.AskDaoService;
import com.springlec.base.service.RegcampDaoService;

@Controller
public class AskController {

	@Autowired
	AskDaoService service;

	// 문의 글쓰기 페이지 이동
	@RequestMapping("/askWriteView")
	public String writeView(HttpServletRequest request, Model model) throws Exception {

		// 캠핑장 각종 디테일
		regcampDto regcampDetailDao = service.regcampDetailDao(Integer.parseInt(request.getParameter("regSeq")));
		model.addAttribute("AskRegcamp", regcampDetailDao);
		System.out.println("캠핑장 AskRegcamp");

		return "ClientAsk";

	}

	// 문의 글쓰기
	@RequestMapping("/askWrite")
	public String write(HttpServletRequest request) throws Exception {

		service.askDao(request);
		System.out.println("문의 입력 실행");

		return "redirect:cHomeList";

	}
}
