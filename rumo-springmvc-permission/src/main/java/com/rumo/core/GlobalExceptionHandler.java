package com.rumo.core;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.validation.BindException;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import com.rumo.exception.ParameterException;
import com.rumo.exception.PermissionException;
import com.rumo.vo.ResponseCode;
import com.rumo.vo.ServerResponse;

@ControllerAdvice
public class GlobalExceptionHandler {
	
	
	@ResponseBody
	@ExceptionHandler(value=Exception.class)
	public ServerResponse exceptionHandler(HttpServletRequest request, Exception e){
		e.printStackTrace();
		if(e instanceof PermissionException) {
			PermissionException ex = (PermissionException)e;
			return ServerResponse.createByErrorMessage(ex.getDesc());
		}else if(e instanceof BindException) {
			BindException ex = (BindException)e;
			List<ObjectError> errors = ex.getAllErrors();
			ObjectError error = errors.get(0);
			return ServerResponse.createByErrorMessage(ResponseCode.VALIDATOR_ERROR,error);
		}else if(e instanceof ParameterException){
			return ServerResponse.createByErrorMessage(ResponseCode.VALIDATOR_ERROR,((ParameterException) e).getErrors());
		}else {
			return ServerResponse.createByErrorMessage(e.getMessage());
		}
	}
}
