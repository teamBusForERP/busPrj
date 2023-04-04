package com.teamBus.web.repository;

import java.util.Date;
import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.teamBus.web.entity.ListDayView;
import com.teamBus.web.entity.ListWmView;
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
	
	ListWmView findhoursByFilter(int employeeId, String fromDate, String toDate);
	
	//추가
	List<ListDayView> findFromDayView(Integer employeeId, Integer companyId, String fromDate);
	List<ListWmView> findFromWmView(Integer employeeId, Integer companyId, String fromDate, String toDate);
	
}
