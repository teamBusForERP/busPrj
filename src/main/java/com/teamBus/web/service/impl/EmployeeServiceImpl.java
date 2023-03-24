package com.teamBus.web.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.teamBus.web.entity.Employee;
import com.teamBus.web.repository.EmployeeRepository;
import com.teamBus.web.service.EmployeeService;

@Service
public class EmployeeServiceImpl implements EmployeeService {

	@Autowired
	private EmployeeRepository repository;
	
	@Override
	public Employee getEmployeeById(int employeeId) {

		return repository.findById(employeeId);
	}

}
