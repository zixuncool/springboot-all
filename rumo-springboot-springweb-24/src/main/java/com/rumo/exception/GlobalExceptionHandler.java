package com.rumo.exception;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.validation.BindException;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

@ControllerAdvice
@ResponseBody
public class GlobalExceptionHandler {
	
	

	@ExceptionHandler(value=Exception.class)
	public Map<String,Object> exceptionHandler(HttpServletRequest request, Exception e){
		e.printStackTrace();
		Map<String,Object> map = new HashMap<>();
		if(e instanceof GlobalException) {
			GlobalException ex = (GlobalException)e;
			map.put("errorCode",500);
			map.put("errorMsg",ex.getMessage());
		}else if(e instanceof BindException) {
			BindException ex = (BindException)e;
			List<ObjectError> errors = ex.getAllErrors();
			//String msg = error.getDefaultMessage();
			map.put("errorCode",500);
			map.put("errorMsg",errors);
		}else {
			map.put("errorCode",500);
			map.put("errorMsg","服务器出错了");
		}
		return map;
	}
}