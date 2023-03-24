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
public class ExtraMatter {
	
	private Integer id;
	private Date dateTime;
	private int employeeId;
	private int matterType;
	private String reason;
	
}
