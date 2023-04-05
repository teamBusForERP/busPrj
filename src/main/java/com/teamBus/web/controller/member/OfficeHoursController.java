package com.teamBus.web.controller.member;

import java.text.SimpleDateFormat;
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
	public String list(
//			int employeeId, //종업원 id
//			String fromDate, //시작일 
//			String toDate,	//종료 일
			Model model
			){
		
		//tmp값
		int employeeId = 1;
		String fromDate = "2023-03-01";
		String toDate = "2023-03-31";
		
		//서비스에서 받은 값 / 근무,휴게시간 나누기
		String time = service.getWRHorusByFilter(1, fromDate, toDate);
		String []times = time.split("\n");
		
		// : 단위로 나누기
		String []worktime = times[0].split(":");
		String []resttime = times[1].split(":");
		//나눈것을 시간 분으로 만들기
		String workTimePrint = worktime[0] + "시간 " + worktime[1] + "분";
		String restTimeprint = resttime[0] + "시간 " + resttime[1] + "분";
		
		model.addAttribute("workTime", workTimePrint);
		model.addAttribute("restTime", restTimeprint);
		
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
