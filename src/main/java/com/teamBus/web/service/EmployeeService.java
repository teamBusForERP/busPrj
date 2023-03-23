package com.teamBus.web.service;

import org.springframework.stereotype.Service;

import com.teamBus.web.entity.Employee;

@Service
public interface EmployeeService {

//	List<Employee> getList();
	Employee getById(int employeeId);
	
	
}
