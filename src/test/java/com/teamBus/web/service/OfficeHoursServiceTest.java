package com.teamBus.web.service;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.teamBus.web.entity.ListWmView;

@SpringBootTest
class OfficeHoursServiceTest {
	
	@Autowired
	private OfficeHoursService service;

	@Test
	void getWHHorusByFilterTest() {
		
		ListWmView hours = service.getWRHorusByFilter(1, "2023-03-01", "2023-03-31");
		System.out.println(hours);
	}

}
