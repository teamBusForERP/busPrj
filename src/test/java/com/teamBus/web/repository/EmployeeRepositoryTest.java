package com.teamBus.web.repository;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.mybatis.spring.boot.test.autoconfigure.MybatisTest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase.Replace;

import com.teamBus.web.entity.AdminListDayView;
import com.teamBus.web.entity.Employee;


@AutoConfigureTestDatabase(replace = Replace.NONE)
@MybatisTest
class EmployeeRepositoryTest {
	
	@Autowired
	private EmployeeRepository repository;
	

//	@Test
	void findTest() {
		List <Employee> list = repository.findAll();
		System.out.println(list);
	}
	
//	@Test
	void findByIdTest() {
		
		Employee em = repository.findById(10);
		
		System.out.println(em);
	}
	
//	@Test
	void findidViewTest() {
		List <AdminListDayView> list = repository.findViewByCompanyId(1);
		System.out.println(list);
	}
	
//	@Test
	void insertTest() {

	
		Employee em = new Employee
			(null,1, //구분1  
			"0000","박동조","01012323522","q@a.com", //구분2
			null,null,null,null,null,null); //구분3
		
		int t = repository.insert(em);
		System.out.println(t);
		
//		System.out.println(list);
		
	}
	
	@Test
	void updateTest() {

		Employee em = new Employee
			(10,1, //구분1  
			"0000","박동조","01012323522","q@a.com", //구분2
			null,"인성팀","대리",'1',null,'1'); //구분3
		
		int t = repository.update(em);
		System.out.println("update "+t);
		
//		System.out.println(list);
		
	}
	
//	@Test
	void deleteTest() {

		
		
		int t = repository.delete(10);
		System.out.println("delete "+t);
		
//		System.out.println(list);
		
	}
	
	
	

}
