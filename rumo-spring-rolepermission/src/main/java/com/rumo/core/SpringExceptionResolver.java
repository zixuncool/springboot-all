package com.rumo.core;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.ModelAndView;

import com.rumo.exception.ParameterException;
import com.rumo.exception.PermissionException;
import com.rumo.vo.ResponseCode;
import com.rumo.vo.ServerResponse;

/**
 * 
 * 
 * SpringExceptionResolver<br/>
 * 创建人:mofeng<br/>
 * 时间：2018年9月18日-下午2:55:33 <br/>
 * @version 1.0.0<br/>
 *
 */
 
public class SpringExceptionResolver implements HandlerExceptionResolver {

	private static Logger log = LoggerFactory.getLogger(SpringExceptionResolver.class);
	
	@Override
	public ModelAndView resolveException(HttpServletRequest request, HttpServletResponse response, Object handler,
			Exception ex) {
		//获取请求地址
		String url = request.getRequestURL().toString();
		ModelAndView modelAndView = null;
		
		//这里的项目要求项目中所有的请求页面，都以.html结尾
		if(url.endsWith(".html")) {
			log.error("【html】unkown {} url is {},异常信息是:{}",ex.getClass().getName(),url,ex.getMessage());
			ServerResponse serverResponse = ServerResponse.createByErrorMessage(ResponseCode.ERROR);
			modelAndView = new ModelAndView("redirect:/error", serverResponse.toMap());
			//modelAndView = new ModelAndView("error", serverResponse.toMap());
		}else {
			//ajax异步处理
			//并且异常是PermissionException
			if(ex instanceof PermissionException) {
				log.error("【json 】unkown PermissionException url is {},异常信息是:{}",url,ex.getMessage());
				ServerResponse serverResponse = ServerResponse.createByErrorMessage(((PermissionException) ex).getResponseCode());
				modelAndView = new ModelAndView("jsonView", serverResponse.toMap());
			}else if(ex instanceof ParameterException){
				log.error("【validator paramaters json 】unkown ParameterException url is {},异常信息是:{}",url,ex.getMessage());
				ServerResponse serverResponse = ServerResponse.createByErrorMessage(ResponseCode.VALIDATOR_ERROR,((ParameterException) ex).getErrors());
				modelAndView = new ModelAndView("jsonView", serverResponse.toMap());
			}else {
				log.error("【json】unkown {} url is {},异常信息是:{}",ex.getClass().getName(),url,ex.getMessage());
				ServerResponse serverResponse = ServerResponse.createByErrorMessage(ResponseCode.ERROR);
				modelAndView = new ModelAndView("jsonView", serverResponse.toMap());
			}
		}
		return modelAndView;
	}

}
