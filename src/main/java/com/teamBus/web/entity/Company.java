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
	
	private int id;
	private String name;
	private String image;
	private String ceoName;
	private Date establishmentDate;
	private String phoneNumber;
	private String address;
	private String email;

}
