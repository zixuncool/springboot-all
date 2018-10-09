package com.rumo.pojo;

import java.util.Date;

public class User {
	
    private Long id;
    private String username;
    private String account;
    private String password;
    private Date createTime;
    private String headerPic;
    private Date updateTime;
    private Integer isDelete;
    private Integer age;
    private Integer male;
    private Integer active;
    private String sign;
    private String url;
    private Integer gcount;
    private Integer fans;
    private Integer type;//1 普通用户 2：会员  3：管理员
    private String idcard;
    private String salary;
    private String email;
    private Integer jifen;
    private Integer contribution;
    private Integer level;
    private Integer cron;
    private String address;
    private String job;
    private String intro;
    private String userdesc;
    
    public User() {
        super();
    }
    
    public User(Long id,String username,String account,String password,Date createTime,String headerPic,Date updateTime,Integer isDelete,Integer age,Integer male,Integer active,String sign,String url,Integer gcount,Integer fans,Integer type,String idcard,String salary,String email,Integer jifen,Integer contribution,Integer level,Integer cron,String address,String job,String intro,String userdesc) {
        super();
        this.id = id;
        this.username = username;
        this.account = account;
        this.password = password;
        this.createTime = createTime;
        this.headerPic = headerPic;
        this.updateTime = updateTime;
        this.isDelete = isDelete;
        this.age = age;
        this.male = male;
        this.active = active;
        this.sign = sign;
        this.url = url;
        this.gcount = gcount;
        this.fans = fans;
        this.type = type;
        this.idcard = idcard;
        this.salary = salary;
        this.email = email;
        this.jifen = jifen;
        this.contribution = contribution;
        this.level = level;
        this.cron = cron;
        this.address = address;
        this.job = job;
        this.intro = intro;
        this.userdesc = userdesc;
    }
    
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
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
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }
    public String getHeaderPic() {
        return headerPic;
    }

    public void setHeaderPic(String headerPic) {
        this.headerPic = headerPic;
    }
    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }
    public Integer getIsDelete() {
        return isDelete;
    }

    public void setIsDelete(Integer isDelete) {
        this.isDelete = isDelete;
    }
    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }
    public Integer getMale() {
        return male;
    }

    public void setMale(Integer male) {
        this.male = male;
    }
    public Integer getActive() {
        return active;
    }

    public void setActive(Integer active) {
        this.active = active;
    }
    public String getSign() {
        return sign;
    }

    public void setSign(String sign) {
        this.sign = sign;
    }
    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }
    public Integer getGcount() {
        return gcount;
    }

    public void setGcount(Integer gcount) {
        this.gcount = gcount;
    }
    public Integer getFans() {
        return fans;
    }

    public void setFans(Integer fans) {
        this.fans = fans;
    }
    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }
    public String getIdcard() {
        return idcard;
    }

    public void setIdcard(String idcard) {
        this.idcard = idcard;
    }
    public String getSalary() {
        return salary;
    }

    public void setSalary(String salary) {
        this.salary = salary;
    }
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
    public Integer getJifen() {
        return jifen;
    }

    public void setJifen(Integer jifen) {
        this.jifen = jifen;
    }
    public Integer getContribution() {
        return contribution;
    }

    public void setContribution(Integer contribution) {
        this.contribution = contribution;
    }
    public Integer getLevel() {
        return level;
    }

    public void setLevel(Integer level) {
        this.level = level;
    }
    public Integer getCron() {
        return cron;
    }

    public void setCron(Integer cron) {
        this.cron = cron;
    }
    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
    public String getJob() {
        return job;
    }

    public void setJob(String job) {
        this.job = job;
    }
    public String getIntro() {
        return intro;
    }

    public void setIntro(String intro) {
        this.intro = intro;
    }
    public String getUserdesc() {
        return userdesc;
    }

    public void setUserdesc(String userdesc) {
        this.userdesc = userdesc;
    }
 	
 	public String toString(Long id,String username,String account,String password,Date createTime,String headerPic,Date updateTime,Integer isDelete,Integer age,Integer male,Integer active,String sign,String url,Integer gcount,Integer fans,Integer type,String idcard,String salary,String email,Integer jifen,Integer contribution,Integer level,Integer cron,String address,String job,String intro,String userdesc) {
        return "User:【this.id:"+id+",this.username:"+username+",this.account:"+account+",this.password:"+password+",this.createTime:"+createTime+",this.headerPic:"+headerPic+",this.updateTime:"+updateTime+",this.isDelete:"+isDelete+",this.age:"+age+",this.male:"+male+",this.active:"+active+",this.sign:"+sign+",this.url:"+url+",this.gcount:"+gcount+",this.fans:"+fans+",this.type:"+type+",this.idcard:"+idcard+",this.salary:"+salary+",this.email:"+email+",this.jifen:"+jifen+",this.contribution:"+contribution+",this.level:"+level+",this.cron:"+cron+",this.address:"+address+",this.job:"+job+",this.intro:"+intro+",this.userdesc:"+userdesc+"】";
    }
    
    public static class UserBuilder{
 	   
	    private Long id;
	    private String username;
	    private String account;
	    private String password;
	    private Date createTime;
	    private String headerPic;
	    private Date updateTime;
	    private Integer isDelete;
	    private Integer age;
	    private Integer male;
	    private Integer active;
	    private String sign;
	    private String url;
	    private Integer gcount;
	    private Integer fans;
	    private Integer type;
	    private String idcard;
	    private String salary;
	    private String email;
	    private Integer jifen;
	    private Integer contribution;
	    private Integer level;
	    private Integer cron;
	    private String address;
	    private String job;
	    private String intro;
	    private String userdesc;

 	    public String toString(){
 	    	 return "User.UserBuilder:【this.id:"+id+",this.username:"+username+",this.account:"+account+",this.password:"+password+",this.createTime:"+createTime+",this.headerPic:"+headerPic+",this.updateTime:"+updateTime+",this.isDelete:"+isDelete+",this.age:"+age+",this.male:"+male+",this.active:"+active+",this.sign:"+sign+",this.url:"+url+",this.gcount:"+gcount+",this.fans:"+fans+",this.type:"+type+",this.idcard:"+idcard+",this.salary:"+salary+",this.email:"+email+",this.jifen:"+jifen+",this.contribution:"+contribution+",this.level:"+level+",this.cron:"+cron+",this.address:"+address+",this.job:"+job+",this.intro:"+intro+",this.userdesc:"+userdesc+"】";
 	    }

 	    public User build(){
 	      return new User(id,username,account,password,createTime,headerPic,updateTime,isDelete,age,male,active,sign,url,gcount,fans,type,idcard,salary,email,jifen,contribution,level,cron,address,job,intro,userdesc);
 	    }

 	    public UserBuilder id(Long id){
 	      this.id = id;
 	      return this;
 	    }
 	    
 	    public UserBuilder username(String username){
 	      this.username = username;
 	      return this;
 	    }
 	    
 	    public UserBuilder account(String account){
 	      this.account = account;
 	      return this;
 	    }
 	    
 	    public UserBuilder password(String password){
 	      this.password = password;
 	      return this;
 	    }
 	    
 	    public UserBuilder createTime(Date createTime){
 	      this.createTime = createTime;
 	      return this;
 	    }
 	    
 	    public UserBuilder headerPic(String headerPic){
 	      this.headerPic = headerPic;
 	      return this;
 	    }
 	    
 	    public UserBuilder updateTime(Date updateTime){
 	      this.updateTime = updateTime;
 	      return this;
 	    }
 	    
 	    public UserBuilder isDelete(Integer isDelete){
 	      this.isDelete = isDelete;
 	      return this;
 	    }
 	    
 	    public UserBuilder age(Integer age){
 	      this.age = age;
 	      return this;
 	    }
 	    
 	    public UserBuilder male(Integer male){
 	      this.male = male;
 	      return this;
 	    }
 	    
 	    public UserBuilder active(Integer active){
 	      this.active = active;
 	      return this;
 	    }
 	    
 	    public UserBuilder sign(String sign){
 	      this.sign = sign;
 	      return this;
 	    }
 	    
 	    public UserBuilder url(String url){
 	      this.url = url;
 	      return this;
 	    }
 	    
 	    public UserBuilder gcount(Integer gcount){
 	      this.gcount = gcount;
 	      return this;
 	    }
 	    
 	    public UserBuilder fans(Integer fans){
 	      this.fans = fans;
 	      return this;
 	    }
 	    
 	    public UserBuilder type(Integer type){
 	      this.type = type;
 	      return this;
 	    }
 	    
 	    public UserBuilder idcard(String idcard){
 	      this.idcard = idcard;
 	      return this;
 	    }
 	    
 	    public UserBuilder salary(String salary){
 	      this.salary = salary;
 	      return this;
 	    }
 	    
 	    public UserBuilder email(String email){
 	      this.email = email;
 	      return this;
 	    }
 	    
 	    public UserBuilder jifen(Integer jifen){
 	      this.jifen = jifen;
 	      return this;
 	    }
 	    
 	    public UserBuilder contribution(Integer contribution){
 	      this.contribution = contribution;
 	      return this;
 	    }
 	    
 	    public UserBuilder level(Integer level){
 	      this.level = level;
 	      return this;
 	    }
 	    
 	    public UserBuilder cron(Integer cron){
 	      this.cron = cron;
 	      return this;
 	    }
 	    
 	    public UserBuilder address(String address){
 	      this.address = address;
 	      return this;
 	    }
 	    
 	    public UserBuilder job(String job){
 	      this.job = job;
 	      return this;
 	    }
 	    
 	    public UserBuilder intro(String intro){
 	      this.intro = intro;
 	      return this;
 	    }
 	    
 	    public UserBuilder userdesc(String userdesc){
 	      this.userdesc = userdesc;
 	      return this;
 	    }
 	    
 	  }

 	  public static User.UserBuilder builder(){
 	    return new User.UserBuilder();
 	  }
}