package com.teamBus.web.service;

import com.teamBus.web.entity.Company;
import com.teamBus.web.entity.Employee;

public interface CommonService {

	Employee getLoginInfo(int employeeId);
	Company getCompanyInfo(int companyId);
	
}
