package com.rumo.config;
import org.springframework.core.MethodParameter;
import org.springframework.web.bind.support.WebDataBinderFactory;
import org.springframework.web.context.request.NativeWebRequest;
import org.springframework.web.method.support.HandlerMethodArgumentResolver;
import org.springframework.web.method.support.ModelAndViewContainer;

import com.rumo.pojo.User;

public class UserArgumentResolver implements HandlerMethodArgumentResolver {

	//此方法是过滤参数条件，如果参数包括User.class对象，那么会进入resolveArgument方法，否则忽略。
	public boolean supportsParameter(MethodParameter parameter) {
		Class clazz = parameter.getParameterType();
		return clazz==User.class;
	}
    
    //满足supportsParameter的条件，就进入进行对数据进行改造

	public Object resolveArgument(MethodParameter parameter, ModelAndViewContainer mavContainer,
			NativeWebRequest webRequest, WebDataBinderFactory binderFactory) throws Exception {
		//获取session中的数据
		User user  = (User)webRequest.getAttribute("session_user",NativeWebRequest.SCOPE_SESSION);//1代表session对象 0请求对象
		return user;
	}

}