
/**
* itbooking系统平台<br/>
* com.rumo.pojo<br/>
* Params.java<br/>
* 创建人:mofeng <br/>
* 时间：2018年9月25日-下午10:01:46 <br/>
* 2018itbooking-版权所有<br/>
*/
package com.rumo.pojo;
import java.util.Date;

/**
 * 
 * Stat<br/>
 * 创建人:mofeng<br/>
 * 时间：2018年9月25日-下午10:01:46 <br/>
 * 
 * @version 1.0.0<br/>
 * 
 */
public class Stat {

	private Integer id;//主键
	private String title;
	private String content;
	private Date createTime;
	private Date updateTime;
	private Integer userId;
	private Integer status;
	
	
	
	public Stat() {
		super();
	}
	 
	/**
	 * 创建一个新的实例 Content.
	 * @param id
	 * @param title
	 * @param content
	 * @param createTime
	 * @param updateTime
	 * @param userId
	 * @param status
	 * @param column
	 */
	public Stat(Integer id, String title, String content, Date createTime, Date updateTime, Integer userId,
			Integer status) {
		super();
		this.id = id;
		this.title = title;
		this.content = content;
		this.createTime = createTime;
		this.updateTime = updateTime;
		this.userId = userId;
		this.status = status;
	}


	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	public Date getUpdateTime() {
		return updateTime;
	}

	public void setUpdateTime(Date updateTime) {
		this.updateTime = updateTime;
	}

	public Integer getUserId() {
		return userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}
	
	
}
