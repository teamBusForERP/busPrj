package com.teamBus.web.controller.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.teamBus.web.entity.Worktime;
import com.teamBus.web.service.OfficeHoursService;



@RestController("OfficeHoursControllerApi")
@RequestMapping("/api/officehours")
public class OfficeHoursController {

	@Autowired	
	private OfficeHoursService service;
	
	@GetMapping
	public Worktime getList(
			@RequestParam(name="employeeId")int employeeId,
			@RequestParam(name="fromDate" )String fromDate,
			@RequestParam(name="toDate", required = false)String toDate
			) {
		Worktime workTime = service.myWorkTime( employeeId, fromDate, toDate);
		return workTime;
	}
}
