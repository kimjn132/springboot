package com.springlec.base.controller;

import java.util.List;
import java.util.Random;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.springlec.base.model.BookJoinDto;
import com.springlec.base.model.campDto;
import com.springlec.base.model.roomDto;
import com.springlec.base.service.CampDaoService;

@Controller
public class CampController {

	@Autowired
	CampDaoService service;
	
	//Camp 예약 관련
	@RequestMapping("/booking")
	public String listCamp(Model model,HttpServletRequest request) throws Exception {
		List<campDto> listCamp = service.listCamp(request);
		model.addAttribute("Camp",listCamp);
		return "Calendar2";
	}
	
	//Camp 예약관련 날짜 확인
	@RequestMapping("/bookingdatecheck")
	public String bookingdatecheck(Model model,HttpServletRequest request) throws Exception {
		HttpSession session = request.getSession();
		List<campDto> dateCheck = service.dateCheck(request);
		model.addAttribute("Camp",dateCheck);
		String startdate = request.getParameter("startdate");
		String stopdate = request.getParameter("stopdate");
				
		session.setAttribute("STARTDATE",startdate);
		session.setAttribute("STOPDATE",stopdate);
		
		request.setAttribute("startdate", startdate);
		request.setAttribute("stopdate", stopdate);
		
		return "Calendar3";
	}

	//Camp 예약관련 날짜 확인
	@RequestMapping("/pay")
	public String pay(Model model,HttpServletRequest request) throws Exception {
		HttpSession session = request.getSession();
		String cId = (String)session.getAttribute("CID");
		String roNum = (String)session.getAttribute("RONUM");
		String regSeq = (String)session.getAttribute("REGSEQ");
		roomDto dto = service.readRoom(request);
		String strRandom = randomCharacter(3);
		service.insertPay(strRandom+dto.getRoSeq()+cId+dto.getRegcamp_regSeq()+dto.getRegcamp_host_hSeq(),dto.getRoSeq(), dto.getRegcamp_regSeq(), dto.getRegcamp_host_hSeq(), cId);
		session.setAttribute("ROSEQ", dto.getRoSeq());
		session.setAttribute("REGCAMP_HOST_HSEQ", dto.getRegcamp_host_hSeq());
		session.setAttribute("STRCID", strRandom+dto.getRoSeq()+cId+dto.getRegcamp_regSeq()+dto.getRegcamp_host_hSeq());
		System.out.println("----------------------insertBook---------------------------------");
		String startdate = (String)session.getAttribute("STARTDATE");
		String startdate2 = request.getParameter("startdate");
		String stopdate = (String)session.getAttribute("STOPDATE");
		String roPrice = (String)session.getAttribute("ROPRICE");
		String roPrice2 =request.getParameter("roPrice");
		// InputBook 의 Dao 를 생성함.  		
		// 체크인 날짜와 체크 아웃 날짜의 날 수를 계산.
		int intdiff = service.diffDate(startdate, stopdate);
		// 체크인 날짜의 예약을 추가한다.
		int roomPrice = service.readRoomPrice(regSeq, roNum);
		int regcamp_host_hSeq = (int)session.getAttribute("REGCAMP_HOST_HSEQ");
		int roSeq = (int)session.getAttribute("ROSEQ");
		String strcId = (String)session.getAttribute("STRCID");
		int result = service.insertBook(roomPrice, startdate, 0, 3, strcId, roSeq, cId,Integer.parseInt(regSeq), regcamp_host_hSeq);
		if (result == 1) {
			// 체크인 날짜의 예약의 Seq를 읽어온다.
			int maxBookSeq = service.readMaxSeq();
			// boGroup 의 
			service.updateBook(maxBookSeq);				
			// 예약 날짜가 하루 이상이면
			if (intdiff > 1) {
				// 체크인 날짜 다음 날짜를 구한다.
				String nextdate = service.Nextday(startdate);
				// boPrice(가격정보), boCheckindate(체크인 날짜), boGroup(예약그룹의 Seq Number), boCount(예약인원), Client Id,intdiff(예약한기간), regcamp의 regSeq, HostSeq
				for(int i=1; i<intdiff;i++) {
					// 다음 체크인 날짜의 예약을 추가한다.
					service.insertBook(roomPrice, nextdate, maxBookSeq, 3, strcId, roSeq,cId,Integer.parseInt(regSeq), regcamp_host_hSeq);
					// 체크인 날짜 다음 날짜를 구한다.
					nextdate = service.Nextday(nextdate);
				}//for end
			}//if intdiff >1 end 
		}//if(result ==1 end 
		
		System.out.println("----------------------insertBook-End--------------------------------");
	
		return "redirect:bookingView";
	}
	
	//Camp 예약관련 날짜 확인
	@RequestMapping("/bookingView")
	public String diffDate(Model model,HttpServletRequest request) throws Exception {
		HttpSession session = request.getSession();
		String cId = (String)session.getAttribute("CID");		
		List<BookJoinDto> ViewBooking = service.ViewBooking(cId);
		model.addAttribute("Booking",ViewBooking);
		return "ViewBooking";
	}		

	public static String randomCharacter(int range) {
	    StringBuilder sb = new StringBuilder();
	    Random rd = new Random();

	    for(int i=0;i<range;i++){
	        sb.append((char)(rd.nextInt(26)+65));
	    }

	    return sb.toString();
	}

}


