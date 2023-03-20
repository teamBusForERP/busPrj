package com.teamBus.web.repository;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.teamBus.web.entity.Member;
import com.teamBus.web.entity.Menu;

@Mapper
public interface MemberRepository {
	
	List<Member> findAll();
	void addMenu(Menu menu);
}
