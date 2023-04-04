package com.teamBus.web.entity;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ListDayView {
	private Integer id; //직원id
	private Integer companyId;
	
	private String name;
	private String image;
	private String department;
	private String position;
	private LocalDate date;
	private LocalDateTime clockIn;
	private LocalTime breakTimeStart;
	private LocalTime breakTimeEnd;
	private LocalDateTime clockOut;
	
	private String workHours;
	private String restHours;
}


