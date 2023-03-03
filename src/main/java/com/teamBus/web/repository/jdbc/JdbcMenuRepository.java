package com.teamBus.web.repository.jdbc;

import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.teamBus.web.entity.Menu;
import com.teamBus.web.repository.MenuRepository;

@Repository
public class JdbcMenuRepository implements MenuRepository {
	
	@Autowired
	private DataSource dataSource;

//	public JdbcMenuRepository(DataSource dataSource) {
//		this.dataSource = dataSource;
//	}

	@Override
	public List<Menu> findAll() {
		
		String sql = "select id, name, price, regDate, categoryId from menu";
		
		JdbcTemplate template = new JdbcTemplate(dataSource);
		List<Menu> list = template.query(sql, new BeanPropertyRowMapper(Menu.class));
		
		return list;
	}	

}
