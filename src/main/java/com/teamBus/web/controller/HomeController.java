package com.teamBus.web.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.teamBus.web.entity.Employee;
import com.teamBus.web.service.EmployeeService;

@Controller
@RequestMapping("/")
public class HomeController {
	
	@Autowired
	private EmployeeService service;
	
	@GetMapping("login")
	public String login() {
		return "login";
	}
	
	@PostMapping("login")
	public String postLogin(
			@RequestParam(name = "email-name") String email, 
												String pwd,
							RedirectAttributes redirectAttr
		){
		String loginInfo = service.getLoginInfo(email);
		String [] info = loginInfo.split("\n");
		System.out.println(info[0]);
		System.out.println(info[1]);
		
		if (pwd.equals(info[0])) {
			System.out.println("로그인성공");
			
			if(info[1].equals("1")) {
				System.out.println("관리자계정");
				return "admin-select";
				}
			else { 
				System.out.println("근로자계정");
				return "redirect:/member/office-hours/register";
			}
		}
		else {
			System.out.println("로그인실패");
			redirectAttr.addFlashAttribute("errorMessage","암호가 틀렸습니다.");
//			return "redirect:/loginform";
			return "login";
		}
	}
	
	@GetMapping("admin-select")
	public String adminSelect() {
		return "admin-select";
	}

}
