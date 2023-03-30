package com.teamBus.web.entity;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class AdminListDayView {
	
	private Integer id; 
	private Integer companyId;
	private String name;
	private String image; 
	private String department;
	private String position;
	private LocalDate date;
	private LocalDateTime clockIn;
	private LocalDateTime clockOut;
	private LocalTime breakTimeStart;
	private LocalTime breakTimeEnd;
	private LocalTime workhours;
	private LocalTime resthours;
	private Integer exId;
}
