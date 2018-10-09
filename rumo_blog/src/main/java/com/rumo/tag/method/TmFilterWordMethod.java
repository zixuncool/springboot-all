package com.rumo.tag.method;

import java.io.File;
import java.util.List;

import javax.servlet.ServletContext;

import org.springframework.stereotype.Component;
import org.springframework.web.context.ServletContextAware;

import com.rumo.util.TmStringUtils;
import com.rumo.util.filterword.SensitivewordFilter;

import freemarker.template.TemplateMethodModelEx;
import freemarker.template.TemplateModelException;

@Component("filterWord")
public class TmFilterWordMethod implements TemplateMethodModelEx, ServletContextAware {
	private ServletContext application;

	// 这里的长度计算，以汉字为标准，两个字母作为一个字符
	@SuppressWarnings("rawtypes")
	public Object exec(List args) throws TemplateModelException {
		if (args.size() > 1)
			throw new TemplateModelException("Wrong arguments!");
		String content = String.valueOf(args.get(0));
		if (TmStringUtils.isNotEmpty(content)) {
			String pathname = application.getRealPath("filter");
			SensitivewordFilter filter = new SensitivewordFilter(new File(pathname, "filterword.txt"));
			String result = filter.replaceSensitiveWord(content, 2, "*");
			return result;
		} else {
			return null;
		}
	}

	@Override
	public void setServletContext(ServletContext application) {
		this.application = application;
	}

}
