package com.teamBus.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("/")
public class HomeController {
	
	@GetMapping("login")
	public String login() {
		return "login";
	}
	
	@PostMapping("login")
	public String postLogin(@RequestParam(name = "email-name") String email, String pwd,
			RedirectAttributes redirectAttr) {
		System.out.printf("%s %s\n", email, pwd);
		
		if (email.equals("admin@abc.com") && pwd.equals("admin"))
			return "admin-select";
		else {
			redirectAttr.addFlashAttribute("errorMessage","암호가 틀렸습니다.");
			return "redirect:";
		}
	}
	
	@GetMapping("admin-select")
	public String adminSelect() {
		return "admin-select";
	}

}
