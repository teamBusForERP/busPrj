package com.teamBus.web.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.teamBus.web.entity.Menu;
import com.teamBus.web.repository.MenuRepository;
import com.teamBus.web.service.OfficeHoursService;

@Service
public class OfficeHoursServiceImpl implements OfficeHoursService {

	@Autowired
	private MenuRepository repository;

//	public OfficeHoursServiceImpl(MenuRepository repository) {
//		this.repository = repository;
//	}

	@Override
	public List<Menu> getList() {
		return repository.findAll();
	}

}
