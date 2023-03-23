package com.teamBus.web.controller.signUp;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/sign-up")
public class signUpController {
	
	@GetMapping("user-info")
	public String userInfo() {
		return "/sign-up/user-info";
	}
	
	@GetMapping("select")
	public String select() {
		return "/sign-up/select";
	}
	
	@GetMapping("create-company")
	public String createCompany() {
		return "/sign-up/create-company";
	}
	
	@GetMapping("find-company")
	public String findCompany() {
		return "/sign-up/find-company";
	}
	
	@GetMapping("waiting")
	public String wating() {
		return "/sign-up/waiting";
	}
}
