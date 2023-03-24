package com.teamBus.web.repository;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.teamBus.web.entity.Worktime;

@Mapper
public interface WorktimeRepository {

	List<Worktime> findAll();
	Worktime findById(int id);
	
	//int insert(Worktime worktime);
	int insertNow(Worktime worktime);
	int update(Worktime worktime);
	int delete(int id);
	
	void addWorktime(int employeeId);
	void updateWorktime(Worktime worktime);
	Worktime findRecentByEmployeeId(int employeeId);
	Worktime findTodayByEmployeeId(int employeeId);
}
