package com.music.model;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;
@Entity
@Table(name = "APP_role")
@Cache(usage=CacheConcurrencyStrategy.READ_WRITE)
public class Role {
	private String id;
	private String name;
	private Set<Authority> authorities = new HashSet<Authority>(0);
	
	
	public Role() {
	}
	public Role(String id, String name, Set<Authority> authorities) {
		super();
		this.id = id;
		this.name = name;
		this.authorities = authorities;
	}
	@Column(name="name")
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	@Id
	@Column(name="role_id")
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	@ManyToMany(fetch=FetchType.LAZY)
	@Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
	@JoinTable(name="app_role_authority",catalog="music",joinColumns={@JoinColumn(name="role_id",nullable=false)},inverseJoinColumns={@JoinColumn(name="authority_id",nullable=false)})
	public Set<Authority> getAuthorities() {
		return authorities;
	}
	public void setAuthorities(Set<Authority> authorities) {
		this.authorities = authorities;
	}
	
	@Override
	public String toString() {
		return "AcctRole [id=" + id + ", name=" + name + "]";
	}
	
	
}
