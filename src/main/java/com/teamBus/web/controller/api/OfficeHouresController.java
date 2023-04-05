package com.teamBus.web.controller.api;

import java.time.LocalTime;
import java.time.ZoneId;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.teamBus.web.entity.Worktime;
import com.teamBus.web.service.OfficeHoursService;

@RestController
@RequestMapping("api/officehours")
public class OfficeHouresController {

	@Autowired
	OfficeHoursService service;

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

	// @PostMapping("register")
	// public String postRegister(int status) {
	//
	// System.out.println(status);
	//
	// service.regWorktimeByStatus(employeeId, status);
	//
	// return "redirect:/member/office-hours/register";
	// }
	//
	// @PostMapping("reg-rest")
	// public String postRest(
	// int status,
	// @RequestParam (name="rest-start", required = false) Date sDate,
	// @RequestParam (name="rest-end", required = false) Date eDate) {
	//
	// LocalTime restStart = LocalTime.ofInstant(sDate.toInstant(),
	// ZoneId.systemDefault());
	// LocalTime restEnd = LocalTime.ofInstant(eDate.toInstant(),
	// ZoneId.systemDefault());
	//
	// service.editResttime(employeeId, status, restStart, restEnd);
	//
	// return "redirect:/member/office-hours/register";
	// }
	//

}
