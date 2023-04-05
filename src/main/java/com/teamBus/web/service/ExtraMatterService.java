package com.teamBus.web.service;

import com.teamBus.web.entity.ExtraMatter;

public interface ExtraMatterService {

	ExtraMatter getExtraMatterByEmployeeId(int employeeId);
	void addExtraMatter(int employeeId,int matterType,String reason);
	int getMatterTypeStatus();
}
