
/**
* itbooking系统平台<br/>
* com.rumo.pojo<br/>
* Course.java<br/>
* 创建人:mofeng <br/>
* 时间：2018年9月25日-下午8:16:08 <br/>
* 2018itbooking-版权所有<br/>
*/
package com.rumo.pojo;

import java.util.Date;

/**
 * 
 * Course<br/>
 * 创建人:mofeng<br/>
 * 时间：2018年9月25日-下午8:16:08 <br/>
 * 
 * @version 1.0.0<br/>
 * 
 */
public class Course {

	private Integer id;
	private String title;
	private Date createTime;
	private String content;
	private Float price;

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

	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public Float getPrice() {
		return price;
	}

	public void setPrice(Float price) {
		this.price = price;
	}

}
