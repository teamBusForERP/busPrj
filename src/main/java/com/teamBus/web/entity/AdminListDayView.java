package com.teamBus.web.entity;

import java.sql.Date;
import java.sql.Time;
import java.time.LocalTime;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class AdminListDayView {
	
	private Integer id; 
	private Integer companyId;
	private String name;
	private String image; 
	private String department;
	private String position;
	private Date date;
	private LocalTime clockIn;
	private LocalTime clockOut;
	private Time breakTimeStart;
	private Time breakTimeEnd;
	private Integer exId;
}
