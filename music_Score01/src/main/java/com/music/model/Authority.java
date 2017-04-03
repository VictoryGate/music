package com.music.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

@Entity
@Table(name="App_authority")
@Cache(usage=CacheConcurrencyStrategy.READ_WRITE)
public class Authority {
	private String id;
	private String name;
	
	public Authority() {
	}
	
	public Authority(String id, String name) {
		super();
		this.id = id;
		this.name = name;
	}
	@Id
	@Column(name="authority_id")
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	@Column(name="name")
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	@Override
	public String toString() {
		return "AcctAuthority [id=" + id + ", name=" + name + "]";
	}
	
	
	
}
