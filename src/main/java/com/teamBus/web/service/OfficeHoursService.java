package com.teamBus.web.service;

import java.time.LocalTime;
import java.util.List;

import org.springframework.stereotype.Service;

import com.teamBus.web.entity.AdminListDayView;
import com.teamBus.web.entity.Employee;
import com.teamBus.web.entity.Worktime;

@Service
public interface OfficeHoursService {
	
	void addWorktime(int employeeId);
	void regClockOut(int employeeId);
	Worktime getTodayWorktimeById(int employeeId);
	
//	admin/list service
	List<Employee> getList();
    List<AdminListDayView> getDayList(Integer companyId);

}
