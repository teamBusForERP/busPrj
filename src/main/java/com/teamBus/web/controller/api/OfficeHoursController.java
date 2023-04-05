package com.teamBus.web.controller.api;

import java.time.LocalTime;
import java.time.ZoneId;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.teamBus.web.entity.ListDayView;
import com.teamBus.web.entity.ListWmView;
import com.teamBus.web.entity.Worktime;
import com.teamBus.web.service.OfficeHoursService;



@RestController("OfficeHoursControllerApi")
@RequestMapping("/api/officehours")
public class OfficeHoursController {

	@Autowired	
	private OfficeHoursService service;
	
	@GetMapping("daylist")
	public List<ListDayView> dayList(
			@RequestParam(name="id", required = false)Integer id,
			@RequestParam(name="companyId", required = false)Integer companyId,
			@RequestParam(name="fromDate" )String fromDate
			) {
		
		List<ListDayView> list = service.WorkTimeList(id, companyId, fromDate);
		
		return list;
	}
	
	@GetMapping("wmlist")
	public List<ListWmView> wmList(
			@RequestParam(name="id", required = false)Integer id,
			@RequestParam(name="companyId", required = false)Integer companyId,
			@RequestParam(name="fromDate" )String fromDate,
			@RequestParam(name="toDate" )String toDate
			) {
		
		List<ListWmView> list = service.WorkTimesList(id, companyId, fromDate, toDate);
		
		return list;
	}


	@GetMapping
	public Worktime getWorktime(
			@RequestParam(name = "id") int employeeId) {
		return service.getRecentByEmployeeId(employeeId);
	}

	@PostMapping
	public String postWorktime(
			@RequestParam(name = "id") int employeeId,
			@RequestParam(name = "s") int workStatus) {
		service.regWorktimeByStatus(employeeId, workStatus);
		if (workStatus == 0)
			return "출근 전 -> 출근등록 완료";
		else if (workStatus == 1)
			return "근무 중 -> 퇴근시간 등록";
		else if (workStatus == 2)
			return "퇴근등록 완료 -> 퇴근시간 수정";
		else if (workStatus == 3)
			return "근무 중(야근) -> 퇴근시간 등록";
		else
			return "예외처리";
	}

	@PutMapping("rest")
	public String postRest(
			@RequestParam(name = "id") int employeeId,
			@RequestParam(name = "s") int workStatus,
			@RequestParam(name = "start") Date sDate,
			@RequestParam(name = "end") Date eDate) {

		LocalTime restStart = LocalTime.ofInstant(sDate.toInstant(), ZoneId.systemDefault());
		LocalTime restEnd = LocalTime.ofInstant(eDate.toInstant(), ZoneId.systemDefault());

		if (workStatus == 0)
				return "출근등록을 마쳐야 휴게시간을 수정할 수 있습니다";

		service.editResttime(employeeId, workStatus, restStart, restEnd);
		
		return String.format("휴게시간 수정 - restStart : %s, restEnd : %s", restStart, restEnd);
	}
		
}
