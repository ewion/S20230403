package com.example.S20230403.controller;

import java.util.List;

import org.apache.catalina.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.S20230403.model.JooJoin;
import com.example.S20230403.service.AdminServcie05;
import com.example.S20230403.service.Paging;

import lombok.AllArgsConstructor;

@Controller
@AllArgsConstructor
public class Controller05 {
	
	private final AdminServcie05 as;

//	관리자 페이지에 일반 회원, 사업자 회원, QnA, 리뷰, 이벤트, 공지사항 테이블 불러오기 & 페이징
	
	@GetMapping("adminPage")
	public String adminPage(Model model, String currentPage, JooJoin jooJoin) {
		int userTotal = as.userTotal();
		int accomTotal = as.accomTotal();
		int qnaTotal = as.qnaTotal();
		int reviewTotal = as.reviewTotal();
		
		Paging page = new Paging(userTotal, currentPage);
		Paging page1 = new Paging(accomTotal, currentPage);
		Paging page2 = new Paging(qnaTotal, currentPage);
		Paging page3 = new Paging(reviewTotal, currentPage);
		
		System.out.println("컨트롤러 userTotal-> "+userTotal);
		//	paging 작업
		System.out.println("컨트롤러 시작 page-> "+ page.getStart());
		System.out.println("컨트롤러 시작 끝 page-> "+ page.getEnd());
		
		// parameter emp -> page만 추가 setting
		jooJoin.setStart(page.getStart()); // 시작시 1
		jooJoin.setEnd(page.getEnd());     // 시작시 10
		
		List<JooJoin> userlist= as.userlist(jooJoin);
		List<JooJoin> accomlist= as.accomlist(jooJoin);
		List<JooJoin> qnalist= as.qnalist(jooJoin);
		List<JooJoin> reviewlist= as.reviewlist(jooJoin);

		model.addAttribute("userTotal", userTotal);
		model.addAttribute("accomTotal", accomTotal);
		model.addAttribute("qnaTotal", qnaTotal);
		model.addAttribute("reviewTotal", reviewTotal);
		
		model.addAttribute("userlist",userlist);
		model.addAttribute("accomlist",accomlist);
		model.addAttribute("qnalist",qnalist);
		model.addAttribute("reviewlist",reviewlist);
		
		model.addAttribute("page", page);
		model.addAttribute("page1", page1);
		model.addAttribute("page2", page2);
		model.addAttribute("page3", page3);

		return "views/adminPage";
	}
	
//	활성화 되어있는 일반 회원 -> 비활성화 시키는 로직
	@RequestMapping(value = "/delUser", method = RequestMethod.GET)
	public String delUsers(JooJoin jooJoin, Model model) {
		System.out.println("AdminController05 delUsers start");
		System.out.println("AdminController05 delUsers getusersid-> "+jooJoin.getUser_id());
		int result = as.delUsers(jooJoin);
		return "redirect:adminPage";
	}
	
//	사용가능(중분류 코드 : 210) 상태인 사업자(숙박업소) -> 사용 불가능 (230)으로 바꾸는 로직
	@RequestMapping(value = "/delAccom", method = RequestMethod.GET)
	public String delAccom(JooJoin jooJoin, Model model) {
		System.out.println("AdminController05 delAccom start");
		System.out.println("AdminController05 delAccom getBiz_id-> "+jooJoin.getBiz_id());
		int result = as.delAccom(jooJoin);
		return "redirect:adminPage";
	}
	
//	QnA 삭제
	@ResponseBody
	@RequestMapping(value = "/delQnA", method = RequestMethod.DELETE)
	public String delQnA(@RequestParam("qna_id") int qna_id, Model model) {
		System.out.println("AdminController05 delQnA start");
		int result = as.delQnA(qna_id);
		return "redirect:adminPage";
	}
	
//	Review 삭제
	@ResponseBody
	@RequestMapping(value = "/delReview", method = RequestMethod.DELETE)
	public String delReview(@RequestParam("pay_id") int pay_id, Model model) {
		System.out.println("AdminController05 delReview start");
		int result = as.delReview(pay_id);
		return "redirect:adminPage";
	}
	
	
}
