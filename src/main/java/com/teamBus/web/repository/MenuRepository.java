package com.teamBus.web.repository;

import java.util.List;

import com.teamBus.web.entity.Menu;

public interface MenuRepository {
	
	List<Menu> findAll();
}
