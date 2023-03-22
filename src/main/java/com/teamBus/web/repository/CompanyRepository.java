package com.teamBus.web.repository;

import org.apache.ibatis.annotations.Mapper;

import com.teamBus.web.entity.Company;

@Mapper
public interface CompanyRepository {
	
//	List<Company> findAll();
	Company findById(int companyId);
//	int insert(Company rcmdMenu);
//	int update(Company rcmdMenu);
//	int delete(int companyId);
}
