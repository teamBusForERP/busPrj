package com.teamBus.web.entity;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ListWmView {

	private Integer id; //직원id
	private Integer companyId;
	
	private String name;
	private String image;
	private String position;
	
	private String workHoursSum; //date 가 X
	private String restHoursSum;
	
	
}