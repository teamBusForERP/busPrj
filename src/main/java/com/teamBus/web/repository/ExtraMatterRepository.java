package com.teamBus.web.repository;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.teamBus.web.entity.ExtraMatter;

@Mapper
public interface ExtraMatterRepository {
	
	ExtraMatter findById(int id);
	List<ExtraMatter> findAll();
	
//	int insert(ExtraMatter extraMatter);
	int insertNow(ExtraMatter extraMatter);
	int update(ExtraMatter extraMatter);
	int delete(int id);
	
}
