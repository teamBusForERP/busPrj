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
	private String department;
	private String position;
	
	private String workHours; //date 가 X
	private String restHours;
	
	
}
