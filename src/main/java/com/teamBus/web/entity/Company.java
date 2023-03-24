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
public class Company {
	
	private Integer id;	
	private String name; //update
	
	private String image; //update
	private String ceoName; //update
	
	private Date establishmentDate;	//update
	private String phoneNumber; //update
	private String address;	//update
	private String email;	//update

}
