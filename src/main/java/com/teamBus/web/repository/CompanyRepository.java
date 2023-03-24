package com.teamBus.web.repository;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.teamBus.web.entity.Company;
import com.teamBus.web.entity.Employee;

@Mapper
public interface CompanyRepository {
	
//기본형
		// create
		int insert(Company emp);
		// read
//		List<Company> findAll();
		Company findById(int companyId);
		// update
		int update(Company emp);
		// delete
		int delete(int companyId);
		
//view
}
