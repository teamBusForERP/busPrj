package com.teamBus.web.service;

import static org.junit.jupiter.api.Assertions.*;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.teamBus.web.entity.ListWmView;

@SpringBootTest
class OfficeHoursServiceTest {
	
	@Autowired
	private OfficeHoursService service;
//
//	@Test
//	void getWHHorusByFilterTest() throws ParseException {
//		
//		String hours = service.getWRHorusByFilter(1, "2023-03-01", "2023-03-31");
//		System.out.println(hours);
//
////		SimpleDateFormat sdf = new SimpleDateFormat("kk:mm:ss");
////		String []times = hours.split("\n");
////		System.out.println("작업시간 "+ times[0]);
////		Date date1 = sdf.parse(times[0]);
////		System.out.println("변환"+sdf.format(date1));
////		
////		sdf.applyPattern("hh시간 mm분");
////		System.out.println(sdf.format(date1));
//		
//		String []times = hours.split("\n");
//		String []time =times[0].split(":");
//		System.out.println(time[0] + "시간 " + time[1] + " 분");
//		
//		
//	}

}
