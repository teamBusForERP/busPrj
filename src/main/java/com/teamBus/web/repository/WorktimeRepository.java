package com.teamBus.web.repository;

import java.sql.Time;
import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.teamBus.web.entity.Worktime;

@Mapper
public interface WorktimeRepository {

	List<Worktime> findAll();
	Worktime findById(int id);
	//int insert(Worktime worktime);
	int update(Worktime worktime);
	int delete(int id);
	
	int insertNow(Worktime worktime);
	void addWorktime(int employeeId);
	
	void updateWorktime(Worktime worktime);
	
	Worktime findTodayByEmployeeId(int employeeId);
}
