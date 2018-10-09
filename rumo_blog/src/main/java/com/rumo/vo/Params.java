
/**
* itbooking系统平台<br/>
* com.rumo.vo<br/>
* Params.java<br/>
* 创建人:mofeng <br/>
* 时间：2018年9月24日-上午12:59:47 <br/>
* 2018itbooking-版权所有<br/>
*/
package com.rumo.vo;

/**
 * 
 * Params<br/>
 * 创建人:mofeng<br/>
 * 时间：2018年9月24日-上午12:59:47 <br/>
 * 
 * @version 1.0.0<br/>
 * 
 */
public class Params {

	private String sort;
	private Integer status = 1;
	private Integer isDelete = 0;
	private Integer pageNo = 0;
	private Integer pageSize = 10;
	private String keyword;
	private Integer userId;
	private Integer filterId;
	private Integer categoryId;
	private Integer mark;

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

	public Integer getCategoryId() {
		return categoryId;
	}

	public void setCategoryId(Integer categoryId) {
		this.categoryId = categoryId;
	}

	public Integer getMark() {
		return mark;
	}

	public void setMark(Integer mark) {
		this.mark = mark;
	}

}
