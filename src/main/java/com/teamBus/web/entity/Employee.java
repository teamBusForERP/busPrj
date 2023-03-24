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
	
	//구분1
	private Integer id;
	private Integer companyId; 
	
	//구분2
	private String password; //update
	private String name; //update
	private String phoneNumber; //update
	private String email;
	
	//구분3
	private String image; //update
	private String department; //update
	private String position; //update
	private Character authority; //update
	private Date joinDate;
	private Character joinStatus; //update
	
}
