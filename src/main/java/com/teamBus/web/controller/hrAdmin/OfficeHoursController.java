package com.teamBus.web.controller.hrAdmin;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.teamBus.web.entity.Menu;
import com.teamBus.web.service.OfficeHoursService;

@Controller("hrAdminOfficeHoursController")
@RequestMapping("/hr-admin/office-hours")
public class OfficeHoursController {
	
	@Autowired
	private OfficeHoursService service;
	
//	public OfficeHoursController(OfficeHoursService service) {
//		this.service = service;
//	}

	@GetMapping("list")
	public String list() {
		
		List<Menu> list = service.getList();
		
		for (Menu l : list) {
			System.out.println(l);
		}
		
		return "/hr-admin/office-hours/list.html";
	}

}
