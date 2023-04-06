package com.teamBus.web.controller.hrAdmin;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller("hrAdminOfficeHoursController")
@RequestMapping("/hr-admin/office-hours")
public class OfficeHoursController {

	@GetMapping("list")
	public String list() {

		return "/hr-admin/office-hours/list";
	}

}
