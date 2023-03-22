package com.teamBus.web.repository;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.teamBus.web.entity.AdminListDayView;
import com.teamBus.web.entity.Employee;

@Mapper
public interface EmployeeRepository {
	
	List<Employee> findAll();
	Employee findById(Integer id);
	
    List<AdminListDayView> findViewByCompanyId(Integer companyId);
}
