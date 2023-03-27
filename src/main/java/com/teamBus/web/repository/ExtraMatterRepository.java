package com.teamBus.web.repository;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.teamBus.web.entity.ExtraMatter;

@Mapper
public interface ExtraMatterRepository {
	
	ExtraMatter findById(int id);
	ExtraMatter findByEmployeeId(int employeeId);
	List<ExtraMatter> findAll();
	
//	int insert(ExtraMatter extraMatter);
	ExtraMatter insertNow(ExtraMatter extraMatter);
	int update(ExtraMatter extraMatter);
	int delete(int id);
	void insertNow(int employeeId, int matterType, String reason);
	
}
