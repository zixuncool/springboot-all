package com.rumo.config;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import com.rumo.pojo.User;
import com.rumo.vo.SessionConstants;

@Component
public class LoginInterceptor implements HandlerInterceptor {

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		User user = (User) request.getSession().getAttribute(SessionConstants.SESSION_KEY_USER);
		// 如果没有登录，user==null
		if (user == null) {
			// 重定向到首页去
			response.sendRedirect(request.getContextPath() + "/");
			return false;
		}
		
		RequestThrealLocal.addUser(user);
		RequestThrealLocal.addRequest(request);
		return true;
	}

	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {
		RequestThrealLocal.del();
	}

	// 此处两个方法，一定都是要preHandle方法返回为true的时候执行
	@Override
	public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex)
			throws Exception {
		RequestThrealLocal.del();
	}
}