package com.rumo.core;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import com.rumo.pojo.User;
import com.rumo.util.JsonUtil;
import com.rumo.vo.RequestThrealLocalUtil;
import com.rumo.vo.SessionKeyContansts;

public class HttpInterceptor extends HandlerInterceptorAdapter {

    private static final String START_TIME = "requestStartTime";
    
    private static Logger log = LoggerFactory.getLogger(HttpInterceptor.class);

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        
    	//User user = (User) request.getSession().getAttribute(SessionKeyContansts.SESSSION_KEY);
    	/*if(user==null) {
    		response.sendRedirect("/login");
    		return false;
    	}*/
    	User user = new User();
    	user.setId(1);
    	user.setUsername("mofeng");
    	//否则放入到threadLocal中
    	RequestThrealLocalUtil.addUser(user);
    	RequestThrealLocalUtil.addRequest(request);
		//放入到本地线程
    	
    	String url = request.getRequestURI().toString();
        Map parameterMap = request.getParameterMap();
        log.info("request start. url:{}, params:{}", url, JsonUtil.obj2String(parameterMap));
        long start = System.currentTimeMillis();
        request.setAttribute(START_TIME, start);
        return true;
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
        String url = request.getRequestURI().toString();
        long start = (Long) request.getAttribute(START_TIME);
        long end = System.currentTimeMillis();
        log.info("request finished. url:{}, cost:{}", url, end - start);
        
        //删除当前线程的副本
        RequestThrealLocalUtil.del();;
    }
    
    
    
    
    

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
       String url = request.getRequestURI().toString();
        long start = (Long) request.getAttribute(START_TIME);
        long end = System.currentTimeMillis();
        log.info("request completed. url:{}, cost:{}", url, end - start);
        
        //删除当前线程的副本
        RequestThrealLocalUtil.del();;
    }

   
}