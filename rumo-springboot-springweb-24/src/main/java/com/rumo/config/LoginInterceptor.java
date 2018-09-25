package com.rumo.config;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import com.rumo.pojo.User;

public class LoginInterceptor implements HandlerInterceptor {

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		System.out.println("1============preHandle=============>1");
		User user = (User)request.getSession().getAttribute("session_user");
		//如果没有登录，user==null
		if(user==null) {
			//重定向到首页去
			response.sendRedirect(request.getContextPath()+"/login");
			return false;
		}
		//否则进入到路由名字和requestmapping相同方法中去执行。
		return true;
	}

	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {
		System.out.println("2============postHandle=============>2");
		// 记录日志信息，这类执行什么方法执行多久 还可以拿到页面，以及改变页面的返回
		HandlerInterceptor.super.postHandle(request, response, handler, modelAndView);
	}

	// 此处两个方法，一定都是要preHandle方法返回为true的时候执行
	@Override
	public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex)
			throws Exception {
		// 记录日志信息，这类执行什么方法执行多久
		System.out.println("3============afterCompletion=============>3");
		HandlerInterceptor.super.afterCompletion(request, response, handler, ex);
	}
}