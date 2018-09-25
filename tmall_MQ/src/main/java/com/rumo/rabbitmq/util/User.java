package com.rumo.rabbitmq.util;

import java.util.Date;

public class User {

	private Integer id;
	private String username;
	private String account;
	private Date createTime;

	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getAccount() {
		return account;
	}

	public void setAccount(String account) {
		this.account = account;
	}

	@Override
	public String toString() {
		return "User [id=" + id + ", username=" + username + ", account=" + account + ", createTime=" + createTime
				+ "]";
	}

}
