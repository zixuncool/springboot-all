package com.rumo.params;

import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotBlank;
import org.hibernate.validator.constraints.NotEmpty;

import com.rumo.validator.IsMobile;
import com.rumo.validator.LengthEq;


/**
 * 登录参数
 * 
 * UserVo<br/>
 * 创建人:mofeng<br/>
 * 时间：2018年9月20日-下午2:20:04 <br/>
 * @version 1.0.0<br/>
 *
 */
public class UserVo {

    @NotBlank(message = "电话不可以为空")
    @Length(min = 1, max = 13, message = "电话长度需要在13个字以内")
    @IsMobile
    private String telephone;

    @NotBlank(message = "密码不允许为空")
    @Length(min = 5, max = 50, message = "密码长度需要在50个字符以内")
    private String password;

    @NotEmpty(message="验证码不允许为空")
    @LengthEq(length=4,message="验证码的长度为4")
    private String code;


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

    
}
