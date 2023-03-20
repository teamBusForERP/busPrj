package com.teamBus.web.repository;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.teamBus.web.entity.Menu;

@Mapper
public interface MenuRepository {
	
	List<Menu> findAll();
	void addMenu(Menu menu);
}
