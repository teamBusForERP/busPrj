package com.teamBus.web.controller.member;

import java.time.LocalDate;

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
    	
		Employee e = commonService.getEmployeeByEmployeeId(employeeId);
    	model.addAttribute("loginInfo", e);
    	
    	String companyName = commonService.getCompanyNameByCompanyId(e.getCompanyId());
    	model.addAttribute("companyName", companyName);
		
    	Worktime recentWorktime = service.getRecentByEmployeeId(employeeId);
    	int status = service.getStatusByWorktime(recentWorktime);
    	
    	model.addAttribute("status", status);
    	model.addAttribute("worktime", recentWorktime);
    	
		
		return "/member/office-hours/register";
	}
	
	@PostMapping("register")
	public String postRegister(int status, Model model) {
		
    	int employeeId = 1;
    	
    	service.regWorktimeByStatus(employeeId, status);

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
