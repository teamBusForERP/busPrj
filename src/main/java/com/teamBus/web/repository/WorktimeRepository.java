package com.teamBus.web.repository;

import java.sql.Time;

import org.apache.ibatis.annotations.Mapper;

import com.teamBus.web.entity.Worktime;

@Mapper
public interface WorktimeRepository {

	void addWorktime(int employeeId);
	void updateWorktime(Worktime worktime);
//	void updateWorktime(int employeeId, Time clockOut);
//	void updateWorktime(int employeeId, Time breakTimeStart, Time breakTimeEnd);
//	void updateWorktime(int employeeId, Time breakTimeStart, Time breakTimeEnd, Time clockOut);
	Worktime findTodayByEmployeeId(int employeeId);
}
