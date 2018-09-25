package com.rumo.config;

import java.util.Map;
import java.util.Map.Entry;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.view.freemarker.FreeMarkerViewResolver;

import freemarker.template.TemplateModel;

@Component
public class MyFreemarkerViewResolver  implements ApplicationContextAware,CommandLineRunner {
 
	private ApplicationContext context;
	
	@Autowired
	private FreeMarkerViewResolver resolver;
	
	public void init() {
		//注册路由视图
		resolver.setViewClass(MyFreemarkerView.class);
		Map<String, TemplateModel> beans = (Map<String, TemplateModel>) context.getBeansOfType(TemplateModel.class);
		for (Entry<String, TemplateModel> entry: beans.entrySet()) {
			resolver.getAttributesMap().put(entry.getKey(), entry.getValue());
		}
	}
	 
	@Override
	public void setApplicationContext(ApplicationContext context)
			throws BeansException {
		this.context = context;
	}

	@Override
	public void run(String... args) throws Exception {
		init();
	}
	
	
	
}
