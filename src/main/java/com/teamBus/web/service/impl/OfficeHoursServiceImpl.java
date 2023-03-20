package com.teamBus.web.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.teamBus.web.entity.ClockIn;
import com.teamBus.web.repository.ClockInRepository;
import com.teamBus.web.service.OfficeHoursService;

@Service
public class OfficeHoursServiceImpl implements OfficeHoursService {
	
	@Autowired
	ClockInRepository clockInRepository;

	public void addClockIn(String employeeId) {
		ClockIn clockIn = new ClockIn(null, null, Integer.parseInt(employeeId));
		clockInRepository.insertClockIn(clockIn);
	}
}
