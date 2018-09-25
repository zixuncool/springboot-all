
/**
* itbooking系统平台<br/>
* com.rumo.pojo<br/>
* Params.java<br/>
* 创建人:mofeng <br/>
* 时间：2018年9月25日-下午10:01:46 <br/>
* 2018itbooking-版权所有<br/>
*/
package com.rumo.pojo;

/**
 * 
 * Params<br/>
 * 创建人:mofeng<br/>
 * 时间：2018年9月25日-下午10:01:46 <br/>
 * 
 * @version 1.0.0<br/>
 * 
 */
public class Params {

	private Integer pageNo = 1;
	private Integer pageSize = 10;
	private String keyword;
	private String startDate;
	private String endDate;
	private Integer status;

	public String getKeyword() {
		return keyword;
	}

	public void setKeyword(String keyword) {
		this.keyword = keyword;
	}

	public String getStartDate() {
		return startDate;
	}

	public void setStartDate(String startDate) {
		this.startDate = startDate;
	}

	public String getEndDate() {
		return endDate;
	}

	public void setEndDate(String endDate) {
		this.endDate = endDate;
	}

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
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
	
}
