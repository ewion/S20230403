package com.example.S20230403.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
@RequiredArgsConstructor
public class SbController {
	@GetMapping("/")
	public String root() {
		return "/views/main";
	}
}
