package com.teamBus.web.repository;

import java.time.LocalDate;
import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.teamBus.web.entity.AdminListDayView;
import com.teamBus.web.entity.Employee;

@Mapper
public interface EmployeeRepository {

	List<Employee> findAll();
	Employee findById(Integer id);
	Employee findByIdEmail(Integer id, String email);
	
//	int insert(Employee employee);
	int insertNew(Employee employee);
	
	int update(Employee employee);
	
	int delete(Integer id);
	
//view
	//HR관리자 계정에서내역조회 
    List<AdminListDayView> findViewByCompanyId(Integer companyId, LocalDate date);
    
}
