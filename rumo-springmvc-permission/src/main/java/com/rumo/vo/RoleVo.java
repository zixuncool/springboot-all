
 /**
 * itbooking系统平台<br/>
 * com.rumo.vo<br/>
 * RoleVo.java<br/>
 * 创建人:mofeng <br/>
 * 时间：2018年9月27日-下午8:21:41 <br/>
 * 2018itbooking-版权所有<br/>
 */
package com.rumo.vo;

import org.hibernate.validator.constraints.NotEmpty;

import com.rumo.pojo.Role;

/**
 * 
 * RoleVo<br/>
 * 创建人:mofeng<br/>
 * 时间：2018年9月27日-下午8:21:41 <br/>
 * @version 1.0.0<br/>
 * 
 */
public class RoleVo {

	@NotEmpty(message="请输入角色名称")
	private String name;
	
	@NotEmpty(message="请选择类型")
    private Integer type;
	
	@NotEmpty(message="请填写状态")
    private Integer status;
	
	private String remark;
    
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Integer getType() {
		return type;
	}
	public void setType(Integer type) {
		this.type = type;
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
		this.remark = remark;
	}
    
}
