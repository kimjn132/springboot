package com.springlec.base.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.springlec.base.model.ClientDto;

import com.springlec.base.service.ClientDaoService;

@Controller
public class ClientFrontController {

	@Autowired

	ClientDaoService service;

	// 회원가입 화면으로
	@RequestMapping("/cJoinView")
	public String joinView() {
		return "ClientSignupView";
	}

	// 회원가입 실행
	@RequestMapping("/Clientwrite")
	public String cJoin(HttpServletRequest request) throws Exception {
		service.cJoinDao(request);
		return "ClientLoginView";
	}

	// 로그인 화면으로
	@RequestMapping("/cLoginView")
	public String loginView() {
		System.out.println("로그인화면");
		return "ClientLoginView";
	}

	// 로그인 실행
	@RequestMapping("/cLogin")
	public String cLogin(HttpServletRequest request) throws Exception {

		HttpSession session = request.getSession();

		ClientDto login = service.cLoginDao(request);
		String cId = request.getParameter("cId");

		System.out.println("로그인실행");

		if (login != null) {

			System.out.println("세션 실행");
			session.setAttribute("CID", cId);

			return "redirect:homeView";
		} else {

			return "redirect:cJoinView";
		}
	}

	// 아이디찾기 화면으로
	@RequestMapping("/cIdFindView")
	public String cIdFindView() throws Exception {
		return "ClientFindidView";
	}

	// 아이디 찾기 실행
	@RequestMapping("/cIdFind")
	public String cIdFind(HttpServletRequest request, Model model) throws Exception {

		ClientDto findDao = service.cIdFindDao(request);
		model.addAttribute("cIdFind", findDao);
		System.out.println("아이디 찾기");
		System.out.println("cIdFind" + findDao);

		return "cIdFindResult";

	}

	// 비밀번호 찾기 화면으로
	@RequestMapping("/cPwFindView")
	public String cPwFindView() throws Exception {
		return "ClientFindpwView";
	}

	// 비번 찾기 실행
	@RequestMapping("/cPwFind")
	public String cPwFind(HttpServletRequest request, Model model) throws Exception {

		ClientDto clientDto = service.cPwFindDao(request);
		model.addAttribute("cPwFind", clientDto);
		System.out.println("비번 찾기");

		return "cIdFindResult";
	}

	// 로그아웃
	@RequestMapping("/cLogout")
	public String cLogout(HttpServletRequest request) throws Exception {

		HttpSession session = request.getSession();

		session.invalidate();

		return "redirect:homeView";

	}

	// 회원정보 페이지
	@RequestMapping("/cMypage")
	public String cMypage(HttpServletRequest request, Model model) throws Exception {

		ClientDto clientDto = service.cInfoDao(request);
		model.addAttribute("mypageview", clientDto);
		System.out.println("회원정보 페이지");
		return "ClientMypageView";
	}

	// 회원정보 수정하기
	@RequestMapping("/cMypageModify")
	public String cMypageModify(HttpServletRequest request, Model model) throws Exception {
		service.cInfoModifyDao(request.getParameter("cPhone"), request.getParameter("cEmail"),
				request.getParameter("cPw"), request.getParameter("cName"), request.getParameter("zonecode"),
				request.getParameter("address"), request.getParameter("buildingName"),
				request.getParameter("detailAddress"), request.getParameter("cId"));
		return "redirect:cHomeList";
	}

	// 회원 탈퇴
	@RequestMapping("/cDeleteClient")
	public String cDeleteClient(HttpServletRequest request, Model model) throws Exception {
		HttpSession session = request.getSession();

		service.cDeleteDao(request.getParameter("cId"));
		session.invalidate();

		return "homeView";
	}

}
