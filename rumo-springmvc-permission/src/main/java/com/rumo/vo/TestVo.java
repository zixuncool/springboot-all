/**
 * TODO濡沫系统平台<br/>
 * com.rumo.vo<br/>
 * TestVo.java<br/>
 *  创建人:mofeng <br/>
 * 时间：2018年9月18日-下午3:49:33 <br/>
 * 2018濡沫公司-版权所有<br/>
 */
package com.rumo.vo;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.NotEmpty;

import com.rumo.validator.IsMobile;

/**
 * 
 * TestVo<br/>
 * 创建人:mofeng<br/>
 * 时间：2018年9月18日-下午3:49:33 <br/>
 * @version 1.0.0<br/>
 * 
 */
public class TestVo {

	@Max(value=10,message="id不能大于10")
	@Min(value=3,message="id至少大于等于3")
	@NotNull(message="id不允许为null")
	private Integer id;
	@NotEmpty(message="不允许为空!!!")
	private String msg;
	
	@IsMobile
	@NotEmpty
	private String phone;
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getMsg() {
		return msg;
	}
	public void setMsg(String msg) {
		this.msg = msg;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	
	
	
}
