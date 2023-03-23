package com.teamBus.web.service;

import com.teamBus.web.entity.Company;
import com.teamBus.web.entity.Employee;

public interface CommonService {

	Employee getEmployeeByEmployeeId(int employeeId);
	
	Company getCompanyByCompanyId(int companyId);
	String getCompanyNameByCompanyId(int companyId);
	
}
