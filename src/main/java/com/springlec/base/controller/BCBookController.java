package com.springlec.base.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.springlec.base.model.checkdate2Dto;
import com.springlec.base.service.BCBookDaoService;

@Controller
public class BCBookController {

	@Autowired
	BCBookDaoService service;
	//
	@RequestMapping("/confirmation")
	public String confirmation(Model model,HttpServletRequest request) throws Exception {
		HttpSession session = request.getSession();
		checkdate2Dto dateCheck = service.confirmation(request);
		String roPrice = request.getParameter("roPrice");
		session.setAttribute("ROPRICE",roPrice);
		request.setAttribute("bookingInfo", dateCheck);
		request.setAttribute("startdate",session.getAttribute("STARTDATE"));
		request.setAttribute("stopdate",session.getAttribute("STOPDATE"));		
		int result = service.diffDate(request);
		model.addAttribute("bookingInfo",dateCheck);
		model.addAttribute("Days",result);
		return "Booking";
	}
	
}
