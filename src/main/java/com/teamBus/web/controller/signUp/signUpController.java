package com.teamBus.web.controller.signUp;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

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
	
}
