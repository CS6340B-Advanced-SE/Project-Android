package com.project.choretracker.data.access.vo;

import java.sql.Date;

public class ChildVO {

	private long id;
	private String name;
	private String dob;
	
	public ChildVO(){
		super();
	}
	
	public long getId() {
		return id;
	}
	
	public void setId(long id) {
		this.id = id;
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public String getDob() {
		return dob;
	}
	
	public void setDob(String dob) {
		this.dob = dob;
	}
}
