package com.teamBus.web.controller.member;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.teamBus.web.entity.Company;
import com.teamBus.web.entity.Employee;
import com.teamBus.web.entity.Worktime;
import com.teamBus.web.service.CommonService;
import com.teamBus.web.service.OfficeHoursService;

@Controller("memberOfficeHoursController")
@RequestMapping("/member/office-hours")
public class OfficeHoursController {
	
	@Autowired
	private OfficeHoursService service;

    @Autowired
    private CommonService commonService;
    
	@GetMapping("list")
	public String list() {
		return "/member/office-hours/list";
	}

	@GetMapping("register")
	public String register(Model model) {
		int employeeId = 1;
    	
		Employee e = commonService.getLoginInfo(employeeId);
    	model.addAttribute("loginInfo", e);
    	Company c = commonService.getCompanyInfo(e.getCompanyId());
    	model.addAttribute("companyInfo", c);
		
		Worktime w = service.getTodayWorktimeById(employeeId);
//		System.out.printf("worktime : %s\n", w);
		if(w == null) {
			model.addAttribute("status", 0);
			System.out.println("출근 전");
		} else {
			model.addAttribute("status", 1);
			System.out.println("출근 후");
			model.addAttribute("worktime", w);
		}
		
		return "/member/office-hours/register";
	}
	
	@PostMapping("register")
	public String postRegister(String status, Model model) {
		
    	int employeeId = 1;
    	
		if (status.equals("0")) {
			System.out.println("출근 등록");
			service.addWorktime(employeeId);
		} else {
			System.out.println("퇴근 등록");
			service.regClockOut(employeeId);
		}
		return "redirect:/member/office-hours/register";
	}
	
	@GetMapping("exception-req")
	public String exceptionReq() {
		return "/member/office-hours/exception-req";
	}
	
	@PostMapping("exception-req")
	public String exceptionReqPost() {
		return "redirect:register";
	}
	
	@GetMapping("reasons-for-late")
	public String reasonsForLate() {	
		return "/member/office-hours/reasons-for-late";
	}

}
