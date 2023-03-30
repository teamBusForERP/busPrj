package com.teamBus.web.repository;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Date;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.mybatis.spring.boot.test.autoconfigure.MybatisTest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase.Replace;
import org.springframework.boot.test.context.SpringBootTest;

import com.teamBus.web.entity.ListWmView;
import com.teamBus.web.entity.Worktime;

@MybatisTest
@AutoConfigureTestDatabase(replace=Replace.NONE)
class WorktimeRepositoryTest {

	@Autowired
	private WorktimeRepository repository;
	
	
	
	@Test
	void findhoursByFilter() {
//		2023-03-26, 2023-04-01);
//		Date date1 = new Date(2023,02,26);
//		System.out.println(date1);
		
//		ListWmView wm = repository.findhoursByFilter(1, null, null);
		ListWmView wm = repository.findhoursByFilter(1, "2023-03-26", "2023-04-01");
//		ListWmView wm = repository.findhoursByFilter(1);

		
		System.out.println(wm);
	}
	
	
	//@Test
	void testFindAll() {
		List<Worktime> list = repository.findAll();
		System.out.println(list);
		
	}
	
	//@Test
	void testFindById() {
		int id=1;
		
		Worktime findId = repository.findById(id);
		System.out.println(findId);
	}
	
//	@Test
	void testinsertNow() {
		Worktime wt = new Worktime(null, 2, null, null, null, null, null);
		
		
		//int insertNow = repository.insertNow(wt);
		int id=1;
		int delete = repository.delete(id);
	}

}
