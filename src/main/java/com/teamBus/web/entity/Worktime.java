package com.teamBus.web.entity;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Worktime {
	
	private Integer id;
	private Integer employeeId;
	private LocalDate date;
	private LocalTime clockIn;
	private LocalTime breakTimeStart;
	private LocalTime breakTimeEnd;
	private LocalTime clockOut;
}
