package com.example.S20230403.controller;

import java.util.ArrayList;
import java.util.List;

import org.apache.catalina.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.S20230403.model.JooJoin;
import com.example.S20230403.service.AdminServcie05;
import com.example.S20230403.service.Paging;
import com.example.S20230403.service.UserService;

import lombok.AllArgsConstructor;
import lombok.Data;

@Controller
@RequestMapping("/admin")
public class AdminController {
	private final AdminServcie05 as;

	
	@Autowired
	public AdminController(AdminServcie05 as) {
		this.as = as;
	}
	@ResponseBody
	@GetMapping("/main")
	public String adminMainPage() {
		return "views/adminPage";
	}

	@ResponseBody
	@GetMapping("/users")
	public List<JooJoin> findUsers(Model model, String currentPage, JooJoin jooJoin) {
		int userTotal = as.userTotal();
		Paging page = new Paging(userTotal, currentPage);
		jooJoin.setStart(page.getStart()); // 시작시 1
		jooJoin.setEnd(page.getEnd());     // 시작시 10
		
		List<JooJoin> userlist= as.userlist(jooJoin);
		
		model.addAttribute("userTotal", userTotal);
		model.addAttribute("userlist",userlist);
		model.addAttribute("page", page);

		
		return userlist;
	}
	
	@ResponseBody
	@GetMapping("/usersPage")
	public Paging userPage(Model model, String currentPage, JooJoin jooJoin) {
		int userTotal = as.userTotal();
		Paging page1 = new Paging(userTotal, currentPage);
		
		jooJoin.setStart(page1.getStart()); // 시작시 1
		jooJoin.setEnd(page1.getEnd());     // 시작시 10
		

		List<JooJoin> userlist= as.userlist(jooJoin);
		
		model.addAttribute("userTotal", userTotal);
		model.addAttribute("userlist",userlist);
		model.addAttribute("page", page1);
		
		
		return page1;
	}
	
	
	@ResponseBody
	@GetMapping("/usersPage2")
	public List<JooJoin> userPage2(Model model, String currentPage, JooJoin jooJoin) {
		int userTotal = as.userTotal();
		Paging page1 = new Paging(userTotal, currentPage);
		
		jooJoin.setStart(page1.getStart()); // 시작시 1
		jooJoin.setEnd(page1.getEnd());     // 시작시 10
		

		List<JooJoin> userlist= as.userlist(jooJoin);
		
		System.out.println("currentPage ==> "+currentPage);
		System.out.println("userlist ==> "+userlist);
		
		model.addAttribute("userTotal", userTotal);
		model.addAttribute("userlist",userlist);
		model.addAttribute("page", page1);
		
		
		return userlist;
	}

}
