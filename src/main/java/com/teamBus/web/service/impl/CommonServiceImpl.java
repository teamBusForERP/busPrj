package com.teamBus.web.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.teamBus.web.entity.Company;
import com.teamBus.web.entity.Employee;
import com.teamBus.web.repository.CompanyRepository;
import com.teamBus.web.repository.EmployeeRepository;
import com.teamBus.web.service.CommonService;

@Service
public class CommonServiceImpl implements CommonService {

	@Autowired
	private EmployeeRepository employeeRepository;
	
	@Autowired
	private CompanyRepository companyRepository;

	@Override
	public Employee getEmployeeByEmployeeId(int employeeId) {
		
		return employeeRepository.findById(employeeId);
	}

	@Override
	public Company getCompanyByCompanyId(int companyId) {
		
		return companyRepository.findById(companyId);
	}
	
	public String getCompanyNameByCompanyId(int companyId) {
		
		return companyRepository.findById(companyId).getName();
	}
	

}
