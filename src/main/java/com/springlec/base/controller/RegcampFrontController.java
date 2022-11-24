package com.springlec.base.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.ui.Model;

import com.springlec.base.model.FacilityDto;
import com.springlec.base.model.KeyDto;
import com.springlec.base.model.MyregcampDto;
import com.springlec.base.model.regcampDto;
import com.springlec.base.model.reviewDto;
import com.springlec.base.service.RegcampDaoService;

@Controller
public class RegcampFrontController {

	@Autowired
	RegcampDaoService service;

	// home으로 이동
	@RequestMapping("/homeView")
	public String homeView() {
		return "redirect:cHomeList";
	}

	// home 캠핑장 리스트 출력
	@RequestMapping("/cHomeList")
	public String cHomeList(HttpServletRequest request, Model model) throws Exception {

		List<regcampDto> regcampDto = service.regcampDao();
		model.addAttribute("HomeList", regcampDto);

		return "Home";
	}

	// 캠핑장 검색
	@RequestMapping("/regcampSearch")
	public String regcampSearch(HttpServletRequest request, Model model) throws Exception {
		List<regcampDto> regcampSearch = service.regcampSearchDao(request.getParameter("query"),
				request.getParameter("content"));
		model.addAttribute("HomeList", regcampSearch);
		return "Home";
	}

	// regcamp detail 상세페이지
	@RequestMapping("/regcampDetail")
	public String regcampDetail(HttpServletRequest request, Model model) throws Exception {

		// 예약을 위해서 캠핑장 RegSeq 값을 세션으로 저장함.
		HttpSession session = request.getSession();
		session.setAttribute("REGSEQ", request.getParameter("regSeq"));

		// 캠핑장 각종 디테일

		regcampDto regcampDetailDao = service.regcampDetailDao(Integer.parseInt(request.getParameter("regSeq")));

		model.addAttribute("DetailView", regcampDetailDao);
		System.out.println("캠핑장 detail");

		// 캠핑장 이미지
		MyregcampDto regcampImageDao = service.regcampImageDao(Integer.parseInt(request.getParameter("regSeq")));
		model.addAttribute("images", regcampImageDao);
		System.out.println("캠핑장 사진");

		// 캠핑장 편의시설
		List<FacilityDto> regcampFacilityDao = service
				.regcampFacilityDao(Integer.parseInt(request.getParameter("regSeq")));
		model.addAttribute("facility", regcampFacilityDao);
		System.out.println("캠핑장 편의시설");

		// 캠핑장 키워드

		List<KeyDto> regcampKeyDao = service.regcampKeyDao(Integer.parseInt(request.getParameter("regSeq")));
		model.addAttribute("keywords", regcampKeyDao);
		System.out.println("캠핑장 키워드");

		// 리뷰리스트
		List<reviewDto> reviewDao = service.reviewDao(Integer.parseInt(request.getParameter("regSeq")));
		model.addAttribute("reviewList", reviewDao);
		System.out.println("리뷰리스트");

		// 리뷰 평점 평균
		reviewDto reviewAvgDao = service.reviewAvgDao(Integer.parseInt(request.getParameter("regSeq")));
		model.addAttribute("reviewAvg", reviewAvgDao);
		System.out.println("리뷰 평균");

		return "DetailView";
	}

}
