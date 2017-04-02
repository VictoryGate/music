package com.music.model;

public class Role {
	private String id;
	private String name;
	
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	@Override
	public String toString() {
		return "AcctRole [id=" + id + ", name=" + name + "]";
	}
	
	
	
}
