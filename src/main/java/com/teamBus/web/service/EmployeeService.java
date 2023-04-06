package com.teamBus.web.service;

import com.teamBus.web.entity.Company;
import com.teamBus.web.entity.Employee;

public interface EmployeeService {

//	List<Employee> getList();


	Employee getById(int employeeId);

	Company getCompanyByCompanyId(int companyId);

	//로그인 서비스
	String getLoginInfo(String email);
	
	//회원가입 서비스
	int signUp(Employee emp);
}
