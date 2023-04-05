package com.teamBus.web.controller.member;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.ZoneId;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.teamBus.web.entity.Employee;
import com.teamBus.web.entity.Worktime;
import com.teamBus.web.service.EmployeeService;
import com.teamBus.web.service.ExtraMatterService;
import com.teamBus.web.service.OfficeHoursService;

@Controller("memberOfficeHoursController")
@RequestMapping("/member/office-hours")
public class OfficeHoursController {
	
	@Autowired
	private OfficeHoursService service;	

    @Autowired
    private EmployeeService employeeService;
		
		@Autowired
    private ExtraMatterService extraMatterService;
    
    int employeeId = 1;

	@GetMapping("list")
	public String list() {
		return "/member/office-hours/list";
	}

	@GetMapping("register")
	public String register() {

		return "/member/office-hours/register2";
	}
	
	@GetMapping("exception-req")
	public String exceptionReq(Model model) {
		
		Employee e = employeeService.getById(employeeId);
    	model.addAttribute("loginInfo", e); 
    	
    	String companyName = employeeService.getCompanyByCompanyId(e.getCompanyId()).getName();
    	model.addAttribute("companyName", companyName);
    	
    	//현재 날짜 
    	LocalDate today = LocalDate.now();
    	model.addAttribute("today", today);
		
    	//시간에 따라 지각사유 or 사전예외신청 
    	int MatterTypeStatus = extraMatterService.getMatterTypeStatus();
    	model.addAttribute("MatterTypeStatus", MatterTypeStatus);
    	
		return "/member/office-hours/exception-req";
	}
	
	@PostMapping("exception-req")
	public String exceptionReqPost(
			int matterType,
			@RequestParam(name="exception-reason",required = false) String reason) {
		
				extraMatterService.addExtraMatter(employeeId, matterType, reason);
		
			
		return "redirect:register";
	}
	
	@GetMapping("reasons-for-late")
	public String reasonsForLate() {	
		return "/member/office-hours/reasons-for-late";
	}

}
