package com.teamBus.web.repository;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.mybatis.spring.boot.test.autoconfigure.MybatisTest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase.Replace;

import com.teamBus.web.entity.AdminListDayView;
import com.teamBus.web.entity.Company;
import com.teamBus.web.entity.Employee;

// 자료형 변경 

// company name unique 
// 삭제시 외래키 제약 꼭 확인


@AutoConfigureTestDatabase(replace = Replace.NONE)
@MybatisTest
class CompanyRepositoryTest {
	
	@Autowired
	private CompanyRepository repository;
	

//	@Test
//	void findTest() {
//		List <Employee> list = repository.findAll();
//		System.out.println(list);
//	}
	
	//@Test
	void findByIdTest() {
		
		Company cm = repository.findById(3);
		
		System.out.println(cm);
	}
	
////	@Test
//	void findidViewTest() {
//		List <AdminListDayView> list = repository.findViewByCompanyId(1);
//		System.out.println(list);
//	}
	
	@Test
	void insertTest() {

	
		Company cp = new Company(
				null,"LG",
				null, null,
				null, null, null, null);	
		
		int t = repository.insertNew(cp);
		System.out.println(t);
		
	}

//	@Test
	void updateTest() {

		Company cp = new Company(
				1,"LG2",
				null, "구광모",
				null, "0270004306", "백범로47", "a@back.com");	
		
		
		int t = repository.update(cp);
		System.out.println("update "+ t);
		
//		System.out.println(list);
		
	}
	
	
//	@Test
	void deleteTest() {
		
		int t = repository.delete(3);
		System.out.println("delete "+t);
		
//		System.out.println(list);
		
	}
	
	
	

}
