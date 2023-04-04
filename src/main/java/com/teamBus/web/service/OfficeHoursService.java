package com.teamBus.web.service;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

import org.springframework.stereotype.Service;

import com.teamBus.web.entity.AdminListDayView;
import com.teamBus.web.entity.Employee;
import com.teamBus.web.entity.ListDayView;
import com.teamBus.web.entity.ListWmView;
import com.teamBus.web.entity.Worktime;

@Service
public interface OfficeHoursService {
	
	// member/register 사용 메소드
	Worktime getRecentByEmployeeId(int employeeId);
	int getStatusByWorktime(Worktime recentWorktime);
	void regWorktimeByStatus(int employeeId, int status);
	void editResttime(int employeeId, int status, LocalTime restStart, LocalTime restEnd);
	

	void addWorktime(int employeeId);
	void regClockOut(int employeeId);
	
	
//	admin/list service
	List<Employee> getList();
    List<AdminListDayView> getDayList(Integer companyId, LocalDate date);
    
//	member/List service 추가
    List<ListDayView> WorkTimeList(Integer employeeId, Integer companyId, String fromDate);
    List<ListWmView> WorkTimesList(Integer employeeId, Integer companyId, String fromDate, String toDate);

}
