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
public class Worktime {
	
	private Integer id;
	private Integer employeeId;
	private LocalDate date;
	private LocalDateTime clockIn;
	private LocalTime breakTimeStart;
	private LocalTime breakTimeEnd;
	private LocalDateTime clockOut;
	//추가
	private String totalWorkTime;
	private String totalRestTime;
}
