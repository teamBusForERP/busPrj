package com.teamBus.web.repository;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.teamBus.web.entity.AdminListDayView;
import com.teamBus.web.entity.Employee;

@Mapper
public interface EmployeeRepository {
	
//기본형
	// create
	int insert(Employee emp);
	
	// read
	List<Employee> findAll();
	Employee findById(Integer id);
	
	// update
	int update(Employee emp);
	
	// delete
	int delete(Integer id);
	

//view
	//HR관리자 계정에서내역조회 
    List<AdminListDayView> findViewByCompanyId(Integer companyId);
    
    
}
