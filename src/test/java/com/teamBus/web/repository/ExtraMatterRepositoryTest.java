package com.teamBus.web.repository;

import org.junit.jupiter.api.Test;
import org.mybatis.spring.boot.test.autoconfigure.MybatisTest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase.Replace;

import com.teamBus.web.entity.ExtraMatter;

@AutoConfigureTestDatabase(replace = Replace.NONE)
@MybatisTest
class ExtraMatterRepositoryTest {
	
	@Autowired
	ExtraMatterRepository repository;

//	@Test
//	void testFindById() {
//		System.out.println(repository.findById(1));
//	}
//
//	@Test
//	void testFindAll() {
//		System.out.println(repository.findAll());
//	}
//
	@Test
	void testInsert() {
		ExtraMatter e = new ExtraMatter(null, null, 1, 2, "abc");
		repository.insertNow(e);
	}
//
//	@Test
//	void testUpdate() {
//		fail("Not yet implemented");
//	}
//
//	@Test
//	void testDelete() {
//		repository.delete(2);
//	}

}
