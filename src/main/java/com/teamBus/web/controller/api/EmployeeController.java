package com.teamBus.web.controller.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.teamBus.web.entity.Company;
import com.teamBus.web.entity.Employee;
import com.teamBus.web.service.EmployeeService;

@RestController
@RequestMapping("api/employee")
public class EmployeeController {

	@Autowired
	EmployeeService service;
	
	@GetMapping
	public Employee getEmployee(
		@RequestParam(name = "id") int employeeId) {
			return service.getById(employeeId);
	}

	@GetMapping("company")
	public Company getCompanybyEmployee(
		@RequestParam(name = "eid") int employeeId) {
			Employee e = service.getById(employeeId);
			return service.getCompanyByCompanyId(e.getCompanyId());
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
