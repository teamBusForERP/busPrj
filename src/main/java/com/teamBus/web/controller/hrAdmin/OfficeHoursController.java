package com.teamBus.web.controller.hrAdmin;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.teamBus.web.entity.Member;
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
	public String list(Model model) {
		
//		List<Menu> list = service.getList();
//		List<Member> mList = service.getMemberList();
//		model.addAttribute("list", list);
//		model.addAttribute("mList", mList);
		
//		for (Menu l : list) {
//			System.out.println(l);
//		}
		
		return "/hr-admin/office-hours/list";
	}

}
