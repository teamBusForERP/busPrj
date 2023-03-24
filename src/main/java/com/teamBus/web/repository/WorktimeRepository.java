package com.teamBus.web.repository;

import java.sql.Time;

import org.apache.ibatis.annotations.Mapper;

import com.teamBus.web.entity.Worktime;

@Mapper
public interface WorktimeRepository {

	void addWorktime(int employeeId);
	
	void updateWorktime(Worktime worktime);
	
	Worktime findTodayByEmployeeId(int employeeId);
}
