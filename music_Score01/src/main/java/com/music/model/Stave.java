package com.music.model;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

@Entity  
@Table(name = "APP_STAVE_LIST")  
@Cache(usage = CacheConcurrencyStrategy.READ_WRITE)  
public class Stave implements java.io.Serializable{

	
	private static final long serialVersionUID = 1L;
	
	private String uuid;
	private String staveName;
	private String creater;
	private String staveType;
	private String creatTime;
	private String lastUpdateTime;
	private String remark;
	
	private User user = new User();

	public Stave(){
		
	}
	
	public Stave(String uuid, String staveName, String creater, String staveType, String creatTime,
			String lastUpdateTime, String remark, User user) {
		super();
		this.uuid = uuid;
		this.staveName = staveName;
		this.creater = creater;
		this.staveType = staveType;
		this.creatTime = creatTime;
		this.lastUpdateTime = lastUpdateTime;
		this.remark = remark;
		this.user = user;
	}

	@Id  
    @Column(name = "uuid", unique = true, nullable = false, length = 64)
	public String getUuid() {
		return uuid;
	}

	public void setUuid(String uuid) {
		this.uuid = uuid;
	}

	@Column(name = "stave_name", nullable = false)
	public String getStaveName() {
		return staveName;
	}

	public void setStaveName(String staveName) {
		this.staveName = staveName;
	}

	@Column(name = "creater", nullable = false)
	public String getCreater() {
		return creater;
	}

	public void setCreater(String creater) {
		this.creater = creater;
	}

	@Column(name = "stave_type", nullable = false)
	public String getStaveType() {
		return staveType;
	}

	public void setStaveType(String staveType) {
		this.staveType = staveType;
	}

	@Column(name = "creat_time", nullable = false)
	public String getCreatTime() {
		return creatTime;
	}

	public void setCreatTime(String creatTime) {
		this.creatTime = creatTime;
	}

	@Column(name = "last_update_time", nullable = false)
	public String getLastUpdateTime() {
		return lastUpdateTime;
	}

	public void setLastUpdateTime(String lastUpdateTime) {
		this.lastUpdateTime = lastUpdateTime;
	}

	@Column(name = "remark")
	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	@ManyToOne( cascade = {CascadeType.PERSIST, CascadeType.MERGE} )
    @JoinColumn(name="user_id")
	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}
	
	
	

}
