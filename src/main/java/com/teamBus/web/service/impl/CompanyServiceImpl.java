package com.teamBus.web.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.teamBus.web.entity.Company;
import com.teamBus.web.repository.CompanyRepository;
import com.teamBus.web.service.CompanyService;

@Service
public class CompanyServiceImpl implements CompanyService {

	@Autowired
	CompanyRepository companyRepository;

	@Override
	public Company getById(int companyId) {
		return companyRepository.findById(companyId);
	}
	
}
