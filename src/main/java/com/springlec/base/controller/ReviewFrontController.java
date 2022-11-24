package com.springlec.base.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.springlec.base.model.ClientDto;
import com.springlec.base.model.regcampDto;
import com.springlec.base.model.reviewDto;
import com.springlec.base.service.RegcampDaoService;
import com.springlec.base.service.ReviewDaoService;

@Controller
public class ReviewFrontController {

	@Autowired
	ReviewDaoService service;

	// 리뷰 디테일
	@RequestMapping("/reviewDetail")
	public String reviewDetail(HttpServletRequest request, Model model) throws Exception {
		reviewDto reviewDto = service.reviewDetailDao(Integer.parseInt(request.getParameter("rvSeq")));
		model.addAttribute("reviewDetail", reviewDto);
		return "ClientReviewDetail";
	}

	// 리뷰 작성 화면
	@RequestMapping("/reviewWriteView")
	public String reviewWriteView(HttpServletRequest request, Model model) throws Exception {

		// 캠핑장 번호 및 캠핑장 소유자 호스트 번호
		regcampDto regcampDetailDao = service.regcampDetailDao(Integer.parseInt(request.getParameter("regSeq")));
		model.addAttribute("reviewRegcamp", regcampDetailDao);
		System.out.println("캠핑장 detail11" + regcampDetailDao);
		

		// 리뷰 작성자 이름
		ClientDto reviewDto = service.reviewerDao(request.getParameter("cId"));
		model.addAttribute("reviewer", reviewDto);
		System.out.println("리뷰 작성자" + reviewDto);
		return "reviewWrite";
	}

	// 리뷰 write
	@RequestMapping("/rWrite")
	public String reviewWrite(HttpServletRequest request, Model model) throws Exception {

		// 리뷰 작성 실행
		service.reviewWriteDao(request);

		return "redirect:cHomeList";

	}
}
