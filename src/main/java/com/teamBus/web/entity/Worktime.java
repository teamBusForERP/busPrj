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
	
	Integer id;
	Integer employeeId;
	LocalDate date;
	LocalTime clockIn;
	LocalTime breakTimeStart;
	LocalTime breakTimeEnd;
	LocalTime clockOut;
}
