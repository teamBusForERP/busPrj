package com.teamBus.web.service;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.mybatis.spring.boot.test.autoconfigure.MybatisTest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase.Replace;
import org.springframework.boot.test.context.SpringBootTest;

import com.teamBus.web.entity.Employee;

@SpringBootTest
class EmployeeServiceTest {
	
	@Autowired
	private EmployeeService Loginservice;
	

	@Test
	void getLoginInfotest() {
		
		String e = Loginservice.getLoginInfo("jym2013@gmail.com");
		
		System.out.println(e);
		
		
	}

}
