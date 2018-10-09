package com.rumo.vo;

import javax.validation.constraints.NotBlank;

import com.rumo.pojo.User;
import com.rumo.validator.IsMobile;
import com.rumo.validator.LengthEq;

/**
 * 登录参数
 * 
 * UserVo<br/>
 * 创建人:mofeng<br/>
 * 时间：2018年9月20日-下午2:20:04 <br/>
 * 
 * @version 1.0.0<br/>
 *
 */
public class UserVo extends User {

	@NotBlank(message = "电话不允许为空")
	@IsMobile
	private String telephone;

	@NotBlank(message = "密码不允许为空")
	//@Size(min = 6, max = 16, message = "密码长度范围{6-16}")
	private String password;

	@LengthEq(length = 4, message = "验证码长度必须是四位")
	private String code;
	
	//错误计数器
	private int errorCode;
	//用户的sessioncode
	private String sessionCode;
	//手机验证码
	private String phonecode;
	
	
	private String sort;
	private Integer status = 1;
	private Integer isDelete = 0;
	private Integer pageNo = 0;
	private Integer pageSize = 10;
	private String keyword;
	private Integer userId;
	private Integer filterId;
	
	

	public String getSort() {
		return sort;
	}

	public void setSort(String sort) {
		this.sort = sort;
	}

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	public Integer getIsDelete() {
		return isDelete;
	}

	public void setIsDelete(Integer isDelete) {
		this.isDelete = isDelete;
	}

	public Integer getPageNo() {
		return pageNo;
	}

	public void setPageNo(Integer pageNo) {
		this.pageNo = pageNo;
	}

	public Integer getPageSize() {
		return pageSize;
	}

	public void setPageSize(Integer pageSize) {
		this.pageSize = pageSize;
	}

	public String getKeyword() {
		return keyword;
	}

	public void setKeyword(String keyword) {
		this.keyword = keyword;
	}

	public Integer getUserId() {
		return userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	public Integer getFilterId() {
		return filterId;
	}

	public void setFilterId(Integer filterId) {
		this.filterId = filterId;
	}

	
	

	public String getSessionCode() {
		return sessionCode;
	}

	public void setSessionCode(String sessionCode) {
		this.sessionCode = sessionCode;
	}

	public int getErrorCode() {
		return errorCode;
	}

	public void setErrorCode(int errorCode) {
		this.errorCode = errorCode;
	}

	public String getTelephone() {
		return telephone;
	}

	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getPhonecode() {
		return phonecode;
	}

	public void setPhonecode(String phonecode) {
		this.phonecode = phonecode;
	}
	
	

}
