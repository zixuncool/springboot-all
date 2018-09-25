
 /**
 * itbooking系统平台<br/>
 * com.rumo.pojo<br/>
 * User.java<br/>
 * 创建人:mofeng <br/>
 * 时间：2018年9月24日-下午8:32:00 <br/>
 * 2018itbooking-版权所有<br/>
 */
package com.rumo.pojo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * 
 * User<br/>
 * 创建人:mofeng<br/>
 * 时间：2018年9月24日-下午8:32:00 <br/>
 * @version 1.0.0<br/>
 * 
 */

@ApiModel(value="用户实体")
public class User {

	@ApiModelProperty(name="username",value="用户名称",required=true)
	private String username;
	@ApiModelProperty(name="password",value="密码",required=true)
	private String password;
	@ApiModelProperty(name="money",value="金额",required=true)
	private Float money;
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public Float getMoney() {
		return money;
	}
	public void setMoney(Float money) {
		this.money = money;
	}
	
	
	
}
