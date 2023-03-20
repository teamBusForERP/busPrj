package com.teamBus.web.repository;

import org.apache.ibatis.annotations.Mapper;

import com.teamBus.web.entity.ClockIn;

@Mapper
public interface ClockInRepository {

	void insertClockIn(ClockIn clockIn);
	
}
