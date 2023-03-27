package com.teamBus.web.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.teamBus.web.entity.Employee;
import com.teamBus.web.repository.EmployeeRepository;
import com.teamBus.web.service.EmployeeService;

@Service
public class EmployeeServiceImpl implements EmployeeService {

	@Autowired
	private EmployeeRepository repository;
	
//	@Override
//	public Employee getEmployeeById(int employeeId) {
//
//		return repository.findById(employeeId);
//	}

	@Override
	public Employee getById(int employeeId) {
		// TODO Auto-generated method stub
		return repository.findById(employeeId);
	}

	@Override
	public String getLoginInfo(String email) {
		// TODO Auto-generated method stub
		Employee em = repository.findByIdEmail(null,email);
		
		//비밀번호 계정 불러오기
		String pw = em.getPassword();
		char at = em.getAuthority();
		
		String info = pw + "\n" + at;
		return info;
	}

	@Override
	public int signUp(Employee emp) {
		// TODO Auto-generated method stub
		
		int x = repository.insertNew(emp);
		
		return x;
	}


	
	

}
