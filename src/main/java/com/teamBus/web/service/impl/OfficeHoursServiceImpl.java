package com.teamBus.web.service.impl;

import java.time.LocalTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.teamBus.web.entity.AdminListDayView;
import com.teamBus.web.entity.Employee;
import com.teamBus.web.entity.Worktime;
import com.teamBus.web.repository.EmployeeRepository;
import com.teamBus.web.repository.WorktimeRepository;
import com.teamBus.web.service.OfficeHoursService;

@Service
public class OfficeHoursServiceImpl implements OfficeHoursService {

	@Autowired
	EmployeeRepository employeeRepository;

	@Autowired
	WorktimeRepository worktimeRepository;

	@Override
	public void addWorktime(int employeeId) {
		worktimeRepository.addWorktime(employeeId);
	}

	@Override
	public void regClockOut(int employeeId) {
		
		Worktime recentWorktime = worktimeRepository.findRecentByEmployeeId(employeeId);
		recentWorktime.setClockIn(LocalTime.now());
		worktimeRepository.updateWorktime(recentWorktime);
	}
	

	@Override
	public List<Employee> getList() {
		return employeeRepository.findAll();
	}

	@Override
	public List<AdminListDayView> getDayList(Integer companyId) {
		return employeeRepository.findViewByCompanyId(companyId);
	}

	@Override
	public Worktime getTodayWorktimeById(int employeeId) {
		return worktimeRepository.findTodayByEmployeeId(employeeId);
	}

}
