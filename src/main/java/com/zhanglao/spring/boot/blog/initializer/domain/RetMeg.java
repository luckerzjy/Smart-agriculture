package com.zhanglao.spring.boot.blog.initializer.domain;


import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

//import com.mysql.fabric.xmlrpc.base.Data;

@Entity
@Table(name = "retmeg")
public class RetMeg {
	
	@Id
	// @GeneratedValue(strategy=GenerationType.IDENTITY) 
	private Long id;
	private String devId;
	private String data;
	private Date addTime;
	
	public RetMeg() {
		super();
	}
	
	public RetMeg(String devId, String data) {
		this.devId = devId;
		this.data = data;
	}

	public RetMeg(Long id, String devId, String data) {
		this.id = id;
		this.devId = devId;
		this.data = data;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getDevId() {
		return devId;
	}

	public void setDevId(String devId) {
		this.devId = devId;
	}

	public String getData() {
		return data;
	}

	public void setData(String data) {
		this.data = data;
	}

	public Date getAddTime() {
		return addTime;
	}

	public void setAddTime(Date addTime) {
		this.addTime = addTime;
	}
}
