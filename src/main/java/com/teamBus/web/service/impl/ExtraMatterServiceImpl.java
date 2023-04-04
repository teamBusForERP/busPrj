package com.teamBus.web.service.impl;

import java.time.LocalTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.teamBus.web.entity.ExtraMatter;
import com.teamBus.web.repository.ExtraMatterRepository;
import com.teamBus.web.service.ExtraMatterService;

@Service
public class ExtraMatterServiceImpl implements ExtraMatterService {

	@Autowired
	private ExtraMatterRepository extraMatterRepository;

	@Override
	public ExtraMatter getExtraMatterByEmployeeId(int employeeId) {
		return extraMatterRepository.findByEmployeeId(employeeId);
	}

	@Override
	public void addExtraMatter(int employeeId, int matterType, String reason) {
		 extraMatterRepository.insertNow(employeeId,matterType,reason);
	}

	@Override
	public int getMatterTypeStatus() {
		
		/// 기준시간
		LocalTime defaultTime = LocalTime.of(9, 30, 00);
		System.out.println(defaultTime);

		// 현재시간
		LocalTime now = LocalTime.now();
		System.out.println(now);

		if (now.isAfter(defaultTime)) {
			System.out.println("지각사유");
			return 2; 
		} else {
			System.out.println("사전예외신청");
			return 1;
		}
		
	}

	

}
