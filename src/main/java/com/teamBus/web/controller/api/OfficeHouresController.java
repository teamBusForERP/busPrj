package com.teamBus.web.controller.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.teamBus.web.entity.Worktime;
import com.teamBus.web.service.OfficeHoursService;

@RestController
@RequestMapping("api/officehours")
public class OfficeHouresController {

	@Autowired
	OfficeHoursService service;
	
	@GetMapping
	public Worktime getWorktime(
		@RequestParam(name = "id") int employeeId) {
			return service.getRecentByEmployeeId(employeeId);
	}
	
//	@PostMapping("register")
//	public String postRegister(int status) {
//		
//    	System.out.println(status);
//    	
//    	service.regWorktimeByStatus(employeeId, status);
//
//    	return "redirect:/member/office-hours/register";
//	}
//	
//	@PostMapping("reg-rest")
//	public String postRest(
//			int status,
//			@RequestParam (name="rest-start", required = false) Date sDate,
//			@RequestParam (name="rest-end", required = false) Date eDate) {
//		
//    	LocalTime restStart = LocalTime.ofInstant(sDate.toInstant(), ZoneId.systemDefault());
//    	LocalTime restEnd = LocalTime.ofInstant(eDate.toInstant(), ZoneId.systemDefault());
//    	
//    	service.editResttime(employeeId, status, restStart, restEnd);
//    	
//    	return "redirect:/member/office-hours/register";
//	}
//	
	
}
