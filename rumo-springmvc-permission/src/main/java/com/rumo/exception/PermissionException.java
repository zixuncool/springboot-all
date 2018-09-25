package com.rumo.exception;

import com.rumo.vo.ResponseCode;

/**
 * 自定义权限拦截异常
 * 
 * @author mengk
 *
 */
public class PermissionException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	private ResponseCode responseCode;

	public PermissionException(ResponseCode responseCode) {
		super(responseCode.toString());
		this.responseCode = responseCode;
	}

	public ResponseCode getDesc() {
		return responseCode;
	}

}
