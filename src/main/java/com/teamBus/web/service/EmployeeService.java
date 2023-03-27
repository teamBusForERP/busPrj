package com.teamBus.web.service;

import org.springframework.stereotype.Service;

import com.teamBus.web.entity.Employee;

@Service
public interface EmployeeService {

//	List<Employee> getList();
	
	Employee getById(int employeeId);
	
	//로그인 서비스
	String getLoginInfo(String email);
	
	//회원가입 서비스
	int signUp(Employee emp);
}
