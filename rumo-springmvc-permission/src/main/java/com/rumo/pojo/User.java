package com.rumo.pojo;

import java.util.Date;

public class User {
	private Integer id;

	private String username;

	private String telephone;

	private String mail;

	private String password;

	private Integer status;

	private String remark;

	private String operator;

	private Date operateTime;

	private String operateIp;

	public User(Integer id, String username, String telephone, String mail, String password, Integer status,
			String remark, String operator, Date operateTime, String operateIp) {
		this.id = id;
		this.username = username;
		this.telephone = telephone;
		this.mail = mail;
		this.password = password;
		this.status = status;
		this.remark = remark;
		this.operator = operator;
		this.operateTime = operateTime;
		this.operateIp = operateIp;
	}

	public User() {
		super();
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
		this.username = username == null ? null : username.trim();
	}

	public String getTelephone() {
		return telephone;
	}

	public void setTelephone(String telephone) {
		this.telephone = telephone == null ? null : telephone.trim();
	}

	public String getMail() {
		return mail;
	}

	public void setMail(String mail) {
		this.mail = mail == null ? null : mail.trim();
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password == null ? null : password.trim();
	}

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark == null ? null : remark.trim();
	}

	public String getOperator() {
		return operator;
	}

	public void setOperator(String operator) {
		this.operator = operator == null ? null : operator.trim();
	}

	public Date getOperateTime() {
		return operateTime;
	}

	public void setOperateTime(Date operateTime) {
		this.operateTime = operateTime;
	}

	public String getOperateIp() {
		return operateIp;
	}

	public void setOperateIp(String operateIp) {
		this.operateIp = operateIp == null ? null : operateIp.trim();
	}

	/**
	 * 建造者模式 建造者模式将复杂对象的创建过程简化，用来传参也很合适。lombok的主要作用是通过一些注解，消除样板式代码
	 * 
	 * @author Administrator
	 *
	 */
	public static class UserBuilder {

		private Integer id;
		private String username;
		private String telephone;
		private String mail;
		private String password;
		private Integer status;
		private String remark;
		private String operator;
		private Date operateTime;
		private String operateIp;

		public User build() {
			return new User(id, username, telephone, mail, password, status, remark, operator, operateTime, operateIp);
		}

		public UserBuilder id(Integer id) {
			this.id = id;
			return this;
		}

		public UserBuilder username(String username) {
			this.username = username;
			return this;
		}

		public UserBuilder telephone(String telephone) {
			this.telephone = telephone;
			return this;
		}

		public UserBuilder mail(String mail) {
			this.mail = mail;
			return this;
		}
		
		public UserBuilder password(String password) {
			this.password = password;
			return this;
		}
		
		public UserBuilder status(Integer status) {
			this.status = status;
			return this;
		}
		
		public UserBuilder remark(String remark) {
			this.remark = remark;
			return this;
		}
		
		public UserBuilder operator(String operator) {
			this.operator = operator;
			return this;
		}

		public UserBuilder operateTime(Date operateTime) {
			this.operateTime = operateTime;
			return this;
		}
		
		public UserBuilder operateIp(String operateIp) {
			this.operateIp = operateIp;
			return this;
		}
	}

	public static User.UserBuilder builder() {
		return new User.UserBuilder();
	}
}