package com.teamBus.web.service.impl;

import java.time.LocalTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.teamBus.web.entity.Company;
import com.teamBus.web.entity.Employee;
import com.teamBus.web.entity.ExtraMatter;
import com.teamBus.web.repository.CompanyRepository;
import com.teamBus.web.repository.EmployeeRepository;
import com.teamBus.web.repository.ExtraMatterRepository;
import com.teamBus.web.service.CommonService;

@Service
public class CommonServiceImpl implements CommonService {

	@Autowired
	private EmployeeRepository employeeRepository;
	
	@Autowired
	private CompanyRepository companyRepository;
	
	@Autowired
	private ExtraMatterRepository extraMatterRepository;

	@Override
	public Employee getEmployeeByEmployeeId(int employeeId) {
		
		return employeeRepository.findById(employeeId);
	}

	@Override
	public Company getCompanyByCompanyId(int companyId) {
		
		return companyRepository.findById(companyId);
	}
	
	@Override
	public String getCompanyNameByCompanyId(int companyId) {
		
		return companyRepository.findById(companyId).getName();
	}

	@Override
	public ExtraMatter getExtraMatterByEmployeeId(int employeeId) {
		// TODO Auto-generated method stub
		return extraMatterRepository.findByEmployeeId(employeeId);
	}

	@Override
	public void addExtraMatter(int employeeId, int matterType, String reason) {
		// TODO Auto-generated method stub
		 extraMatterRepository.insertNow(employeeId,matterType,reason);
	}

	@Override
	public int getMatterTypeStatus() {
		
		/// 기준시간
		LocalTime defaultTime = LocalTime.of(9, 30, 00);
		System.out.println(defaultTime);

		// 현재시간
		LocalTime now = LocalTime.now();
		System.out.println(now);

		if (now.isAfter(defaultTime)) {
			System.out.println("지각사유");
			return 2; 
		} else {
			System.out.println("사전예외신청");
			return 1;
		}
		
	}

	

}
