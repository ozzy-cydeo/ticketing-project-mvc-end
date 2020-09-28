package com.cybertek.entity;

public class Role {
	
	private long id;
	private String description;
	
	//No-Arg Constructor
	//All-Arg Constructor
	//Getter,Setter
	
	
	public Role() {
		super();
	}


	public Role(long id, String description) {
		super();
		this.id = id;
		this.description = description;
	}


	public long getId() {
		return id;
	}


	public void setId(long id) {
		this.id = id;
	}


	public String getDescription() {
		return description;
	}


	public void setDescription(String description) {
		this.description = description;
	}
	
	
	
	

}
