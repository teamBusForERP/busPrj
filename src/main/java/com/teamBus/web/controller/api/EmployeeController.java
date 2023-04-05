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


}
