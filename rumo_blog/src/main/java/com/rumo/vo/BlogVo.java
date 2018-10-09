package com.rumo.vo;

import com.rumo.pojo.Blog;

/**
 * 
 * BlogVo<br/>
 * 创建人:mofeng<br/>
 * 时间：2018年9月26日-下午7:09:35 <br/>
 * @version 1.0.0<br/>
 * 
 */
public class BlogVo extends Blog {

	//排序字段
	private String sort;
	//一定发布的
	private Integer status = 1;
	private Integer mark ;
	//一定是未删除的
	private Integer isDelete = 0;
	//默认查询从第一页开始，查询10条出来
	private Integer pageNo = 1;
	private Integer pageSize = 10;
	private String keyword;
	private Long userId;
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
	public Integer getMark() {
		return mark;
	}
	public void setMark(Integer mark) {
		this.mark = mark;
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
	public Long getUserId() {
		return userId;
	}
	public void setUserId(Long userId) {
		this.userId = userId;
	}
	public Integer getFilterId() {
		return filterId;
	}
	public void setFilterId(Integer filterId) {
		this.filterId = filterId;
	}

	
}
