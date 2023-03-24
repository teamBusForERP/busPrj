package com.teamBus.web.repository;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.teamBus.web.entity.Company;
import com.teamBus.web.entity.Employee;

@Mapper
public interface CompanyRepository {
	
	List<Company> findAll();
	Company findById(int companyId);
		
//	int insert(Company company);
	int insertNew(Company company);
	
	int update(Company company);
	
	int delete(int companyId);
	
}
