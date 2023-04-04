package com.teamBus.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/")
public class HomeController {
	
	@GetMapping("login")
	public String login() {
		return "login";
	}
	
	@GetMapping("admin-select")
	public String adminSelect() {
		return "admin-select";
	}

}