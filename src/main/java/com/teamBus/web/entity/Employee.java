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
public class Employee {
	
	private Integer id;
	private Integer companyId;
	private String password;
	private String name;
	private String phoneNumber;
	private String email;
	private String image;
	private String department;
	private String position;
	private Character authority;
	private Date joinDate;
	private Character joinStatus;
	
}
