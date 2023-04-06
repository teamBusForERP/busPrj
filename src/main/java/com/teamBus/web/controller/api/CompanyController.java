package com.teamBus.web.controller.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.teamBus.web.entity.Company;
import com.teamBus.web.service.CompanyService;

@RestController
@RequestMapping("api/company")
public class CompanyController {

	@Autowired
	CompanyService service;
	
	@GetMapping
	public Company getCompany(
		@RequestParam(name = "id") int companyId) {
			return service.getById(companyId);
	}


}
