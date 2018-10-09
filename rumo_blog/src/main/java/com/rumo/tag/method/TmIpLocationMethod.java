package com.rumo.tag.method;

import java.util.List;

import javax.servlet.ServletContext;

import org.springframework.stereotype.Component;
import org.springframework.web.context.ServletContextAware;

import com.rumo.util.TmStringUtils;
import com.rumo.util.ip.TmIpUtil;

import freemarker.template.TemplateMethodModelEx;
import freemarker.template.TemplateModelException;

@Component("ipLocation")
public class TmIpLocationMethod implements TemplateMethodModelEx, ServletContextAware {

	private ServletContext context;

	// 这里的长度计算，以汉字为标准，两个字母作为一个字符
	@SuppressWarnings("rawtypes")
	public Object exec(List args) throws TemplateModelException {
		String filePath = getRoot() + "\\WEB-INF\\ip";
		if (args.size() > 1)
			throw new TemplateModelException("Wrong arguments!");

		String ip = String.valueOf(args.get(0));
		String ipLocation = "";
		if (TmStringUtils.isEmpty(ip)) {
			return ipLocation;
		}
		ipLocation = TmIpUtil.ipLocation(ip, filePath);
		return ipLocation;
	}

	/**
	 * 获得服务器端操作的项目路径:X:/tomcat6/webapps/ExmayCMS/ 注意结尾带有/
	 * 
	 * @return
	 */
	public String getRoot() {
		String applicationRoot = context.getRealPath("/");
		applicationRoot = applicationRoot.replaceAll("//", "/");
		return applicationRoot;
	}

	@Override
	public void setServletContext(ServletContext context) {
		this.context = context;
	}

}
