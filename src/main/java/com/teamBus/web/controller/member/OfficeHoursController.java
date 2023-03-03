package com.teamBus.web.controller.member;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller("memberOfficeHoursController")
@RequestMapping("/member/office-hours")
public class OfficeHoursController {
	
	@GetMapping("list")
	public String list() {
		return "/member/office-hours/list.html";
	}

	@GetMapping("register")
	public String register() {
		return "/member/office-hours/register.html";
	}
	
	@GetMapping("exception-req")
	public String exceptionReq() {
		return "/member/office-hours/exception-req.html";
	}
	
	@GetMapping("reasons-for-late")
	public String reasonsForLate() {
		return "/member/office-hours/reasons-for-late.html";
	}
}
