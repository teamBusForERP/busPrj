package com.teamBus.web.entity;

import java.util.Date;

public class ClockIn {
	private Integer id;
	private Date dateTime;
	private Integer employeeId;
	
	public ClockIn() {
	}

	public ClockIn(Integer id, Date dateTime, Integer employeeId) {
		this.id = id;
		this.dateTime = dateTime;
		this.employeeId = employeeId;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Date getDateTime() {
		return dateTime;
	}

	public void setDateTime(Date dateTime) {
		this.dateTime = dateTime;
	}

	public Integer getEmployeeId() {
		return employeeId;
	}

	public void setEmployeeId(Integer employeeId) {
		this.employeeId = employeeId;
	}
	
}
