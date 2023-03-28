package com.teamBus.web.service;

import com.teamBus.web.entity.Company;
import com.teamBus.web.entity.Employee;
import com.teamBus.web.entity.ExtraMatter;

public interface CommonService {

	Employee getEmployeeByEmployeeId(int employeeId);
	
	Company getCompanyByCompanyId(int companyId);
	String getCompanyNameByCompanyId(int companyId);
	ExtraMatter getExtraMatterByEmployeeId(int employeeId);
	void addExtraMatter(int employeeId,int matterType,String reason);

	int getMatterTypeStatus();
}
