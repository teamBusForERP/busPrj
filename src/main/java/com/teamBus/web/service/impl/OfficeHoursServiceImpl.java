package com.teamBus.web.service.impl;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.teamBus.web.entity.AdminListDayView;
import com.teamBus.web.entity.Employee;
import com.teamBus.web.entity.ListWmView;
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
	public Worktime getRecentByEmployeeId(int employeeId) {
		return worktimeRepository.findRecentByEmployeeId(employeeId);
	}

	@Override
	public void regClockOut(int employeeId) {

		Worktime recentWorktime = worktimeRepository.findRecentByEmployeeId(employeeId);
		recentWorktime.setClockIn(LocalDateTime.now());
		worktimeRepository.update(recentWorktime);
	}

	@Override
	public void addWorktime(int employeeId) {
		worktimeRepository.addWorktime(employeeId);
	}

	@Override
	public int getStatusByWorktime(Worktime recentWorktime) {
		// 0: 출근등록 전 상태
		// 1: 근무 중 상태,
		// 2: 퇴근등록 완료 상태
		// 3: 예외처리(퇴근시간이 등록되지 않은 최근근무정보가 오늘이 아닌 상태)

		if (recentWorktime != null) {
			if (recentWorktime.getDate().equals(LocalDate.now())) { // 최근근무정보가 오늘인 경우
				if (recentWorktime.getClockOut() != null) {
					// 오늘의 근무정보가 모두 등록 된 상태
					System.out.println("퇴근 등록 완료 상태");
					return 2;
				} else {
					// 오늘의 근무정보 중 퇴근이 등록되지 않은 상태
					System.out.println("근무 중 상태");
					return 1;
				}
			} else { // 최근근무정보가 오늘이 아닌 경우
				if (recentWorktime.getClockOut() != null) {
					// 최근근무정보가 정상적으로 완료되었고, 오늘 날짜 기준 새로운 근무를 생성하기 전 상태
					System.out.println("출근등록 전 상태");
					return 0;
				} else {
					// 최근근무정보의 퇴근이 정상적으로 등록되지 않은 상태
					System.out.println("예외처리");
					return 3;
				}
			}
		} else { // 한 번도 출근한 적이 없는 경우
			System.out.println("출근등록 전 상태2");
			return 0;
		}
	}

	@Override
	public void regWorktimeByStatus(int employeeId, int status) {
		// 0: 출근등록 전 상태
		// 1: 근무 중 상태,
		// 2: 퇴근등록 완료 상태
		// 3: 예외처리(퇴근시간이 등록되지 않은 최근근무정보가 오늘이 아닌 상태)
		
		Worktime w = new Worktime();
		
		if(status != 0) {
			int recentWorktimeId = worktimeRepository.findRecentByEmployeeId(employeeId).getId();
			w.setId(recentWorktimeId);
			w.setClockOut(LocalDateTime.now());
		}
		
		switch (status) {
		case 0: // 일반적인 출근 등록 입력
			worktimeRepository.addWorktime(employeeId);
			break;
			
		case 1:
			// 최근 근무정보의 퇴근시간이 null인 상태에서 퇴근시간 입력 (근무상태 -> 퇴근등록)
			worktimeRepository.update(w);
			break;
			
		case 2:
			// 최근 근무정보에 퇴근 시간이 이미 입력된 상태에서 퇴근시간 변경 (퇴근상태 -> 퇴근등록)
			worktimeRepository.update(w);
			break;
			
		case 3:
			// 오늘이 아닌 퇴근 등록되지 않은 최근근무정보가 있는 상태
			
			// - 1. 근무 중 상태이나 자정이 넘은 경우
			
			// - 2. 단순 퇴근등록이 누락된 경우
			break;
		}
	}
	
	public void editResttime(int employeeId, int status, LocalTime restStart, LocalTime restEnd) {
		// 0: 출근등록 전 상태
		// 1: 근무 중 상태,
		// 2: 퇴근등록 완료 상태
		// 3: 예외처리(퇴근시간이 등록되지 않은 최근근무정보가 오늘이 아닌 상태)
		
		int recentWorktimeId = worktimeRepository.findRecentByEmployeeId(employeeId).getId();
		Worktime w = new Worktime();
		w.setId(recentWorktimeId);
		w.setBreakTimeStart(restStart);
		w.setBreakTimeEnd(restEnd);
		
		switch (status) {
		case 0: // 당일 출근 등록이 안된 상태
			break;
			
		case 1: // 근무상태 -> 휴게시간 수정
		case 2: // 퇴근상태 -> 휴게시간 수정
		case 3: // 퇴근이 등록되지 않은 상태 -> 휴게시간 수정 
			worktimeRepository.update(w);
			break;
		}
		
	}

	@Override
	public List<Employee> getList() {
		return employeeRepository.findAll();
	}

	@Override
	public List<AdminListDayView> getDayList(Integer companyId, LocalDate date) {
		return employeeRepository.findViewByCompanyId(companyId, date);
	}

	@Override
	public String getWRHorusByFilter(int employeeId, String fromDate, String toDate) {
		// TODO Auto-generated method stub
		String work = worktimeRepository.findhoursByFilter(employeeId, fromDate, toDate).getWorkHoursSum();
		String rest = worktimeRepository.findhoursByFilter(employeeId, fromDate, toDate).getRestHoursSum();
		return work + "\n" + rest;
	}

}
