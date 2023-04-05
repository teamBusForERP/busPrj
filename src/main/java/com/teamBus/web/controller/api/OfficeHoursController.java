package com.teamBus.web.controller.api;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
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
		
}
