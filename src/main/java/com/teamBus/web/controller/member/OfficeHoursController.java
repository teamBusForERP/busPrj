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
import com.teamBus.web.service.CommonService;
import com.teamBus.web.service.OfficeHoursService;

@Controller("memberOfficeHoursController")
@RequestMapping("/member/office-hours")
public class OfficeHoursController {
	
	@Autowired
	private OfficeHoursService service;

    @Autowired
    private CommonService commonService;
    
    int employeeId = 7;

	@GetMapping("list")
	public String list() {
		return "/member/office-hours/list";
	}

	
	@GetMapping("register")
	public String register(Model model) {
		
		Employee e = commonService.getEmployeeByEmployeeId(employeeId);
    	model.addAttribute("loginInfo", e);
    	
    	String companyName = commonService.getCompanyNameByCompanyId(e.getCompanyId());
    	model.addAttribute("companyName", companyName);
    	
    	//현재 날짜 
    	LocalDate today = LocalDate.now();
    	model.addAttribute("today", today);
		
    	Worktime recentWorktime = service.getRecentByEmployeeId(employeeId);
    	int status = service.getStatusByWorktime(recentWorktime);
    	
    	if (status != 0)
    		model.addAttribute("worktime", recentWorktime);
//    	if (status == 3)
//    		return "redirect:/member/office-hours/exception-req";
		
		model.addAttribute("status", status);
    	
		return "/member/office-hours/register";
	}
	
	@PostMapping("register")
	public String postRegister(int status) {
		
    	System.out.println(status);
    	
    	service.regWorktimeByStatus(employeeId, status);

    	return "redirect:/member/office-hours/register";
	}
	
	@PostMapping("reg-rest")
	public String postRest(
			int status,
			@RequestParam (name="rest-start", required = false) Date sDate,
			@RequestParam (name="rest-end", required = false) Date eDate) {
		
    	LocalTime restStart = LocalTime.ofInstant(sDate.toInstant(), ZoneId.systemDefault());
    	LocalTime restEnd = LocalTime.ofInstant(eDate.toInstant(), ZoneId.systemDefault());
    	
    	service.editResttime(employeeId, status, restStart, restEnd);
    	
    	return "redirect:/member/office-hours/register";
	}
	
	@GetMapping("exception-req")
	public String exceptionReq(Model model) {
		
		Employee e = commonService.getEmployeeByEmployeeId(employeeId);
    	model.addAttribute("loginInfo", e); 
    	
    	String companyName = commonService.getCompanyNameByCompanyId(e.getCompanyId());
    	model.addAttribute("companyName", companyName);
    	
    	//현재 날짜 
    	LocalDate today = LocalDate.now();
    	model.addAttribute("today", today);
		
    	//시간에 따라 지각사유 or 사전예외신청 
    	int MatterTypeStatus = commonService.getMatterTypeStatus();
    	model.addAttribute("MatterTypeStatus", MatterTypeStatus);
    	
		return "/member/office-hours/exception-req";
	}
	
	@PostMapping("exception-req")
	public String exceptionReqPost(
			int matterType,
			@RequestParam(name="exception-reason",required = false) String reason) {
		
		commonService.addExtraMatter(employeeId, matterType, reason);
		
			
		return "redirect:register";
	}
	
	@GetMapping("reasons-for-late")
	public String reasonsForLate() {	
		return "/member/office-hours/reasons-for-late";
	}

}
