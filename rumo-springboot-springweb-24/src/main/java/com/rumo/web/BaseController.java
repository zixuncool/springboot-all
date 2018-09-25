package com.rumo.web;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import com.rumo.pojo.User;

public class BaseController {
	
	@Autowired
	private HttpServletRequest request;
	
	
	public Integer getUserId() {
		HttpServletRequest request2 = ((ServletRequestAttributes)RequestContextHolder.getRequestAttributes()).getRequest(); 
		User user = (User)request2.getSession().getAttribute("session_user");
		return user.getId();
	}
	
	public Integer getUserId2() {
		User user = (User)request.getSession().getAttribute("session_user");
		return user.getId();
	}

	/*@InitBinder
	public void initBinder(ServletRequestDataBinder binder) {
	    SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
	    binder.registerCustomEditor(Date.class, new CustomDateEditor(sdf, true));        
	}*/
	
}
