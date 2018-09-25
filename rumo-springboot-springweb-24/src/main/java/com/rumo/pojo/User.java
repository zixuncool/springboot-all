package com.rumo.pojo;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Past;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.Range;

import com.rumo.validator.CaseMode;
import com.rumo.validator.CheckCase;
import com.rumo.validator.IsMobile;

public class User  implements Serializable {

    private Integer id;
    
    
    
    //@NotEmpty(message="用户名不能为空")
    @NotNull(message="用户名不能为空!!!")
    @Length(min=6,max = 12,message="用户名长度必须位于6到12之间")
    @CheckCase(message="用户名填写内容必须小写",value=CaseMode.LOWER)
    private String username;
   // @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    
    @Past(message="出生日期不得早于现在...")
    private Date birthday;
    
    @Range(min = 0, max = 250, message = "range在[0,250]之间")
    private Integer age;
    
    @Size(min = 3,max = 5,message = "names的Size在[3,5]")
    
    private String[] names;
    @Size(min = 3,max = 5,message = "courses的Size在[3,5]")
    private List<String> courses;
    
    @NotNull(message="手机号码不允许为空!!")
	@IsMobile
	private String mobile;
	
	@NotNull(message="密码不允许空!!!")
	@Length(min=12,message="密码不得少于12")
	private String password;
	

	@NotNull(message="邮箱不允许为空!!!")
    @Email(message="请输入正确的邮箱")
    private String email;

    @Pattern(regexp = "^(\\d{18,18}|\\d{15,15}|(\\d{17,17}[x|X]))$", message = "身份证格式错误")
    private String idCard;
    
    

    public List<String> getCourses() {
		return courses;
	}

	public void setCourses(List<String> courses) {
		this.courses = courses;
	}

	public String[] getNames() {
		return names;
	}

	public void setNames(String[] names) {
		this.names = names;
	}

	public Integer getAge() {
		return age;
	}

	public void setAge(Integer age) {
		this.age = age;
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

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }
    

	public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	
	

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getIdCard() {
		return idCard;
	}

	public void setIdCard(String idCard) {
		this.idCard = idCard;
	}

	@Override
	public String toString() {
		return "User [id=" + id + ", username=" + username + ", birthday=" + birthday + ", age=" + age + "]";
	}
    
    
}
