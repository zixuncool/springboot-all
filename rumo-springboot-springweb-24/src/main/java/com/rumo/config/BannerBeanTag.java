//package com.tz.core.tag.banner;
//
//import java.io.IOException;
//import java.util.HashMap;
//import java.util.Map;
//
//import javax.servlet.ServletContext;
//
//import org.springframework.context.ApplicationContext;
//import org.springframework.stereotype.Component;
//import org.springframework.web.context.ServletContextAware;
//import org.springframework.web.context.support.WebApplicationContextUtils;
//
//import com.tz.core.tag.TmTemplateDirectiveModelUtil;
//import com.tz.dao.banner.IBannerDao;
//import com.tz.util.TmStringUtils;
//
//import freemarker.core.Environment;
//import freemarker.ext.beans.BeansWrapper;
//import freemarker.template.TemplateDirectiveBody;
//import freemarker.template.TemplateDirectiveModel;
//import freemarker.template.TemplateException;
//import freemarker.template.TemplateModel;
//
///**
// * 首页的图集管理
// * TzBannerListTag
// * 创建人:柯柯 
// * 时间：2016年04月05日 12:57:41
// * @version 1.0.0
// *
// */
//@Component("bannerBean")
//public class BannerBeanTag implements TemplateDirectiveModel ,ServletContextAware {
//	private ServletContext servletContext;
//	@SuppressWarnings({ "rawtypes", "unchecked" })
//	public void execute(Environment env, Map params, TemplateModel[] loopVars,
//			TemplateDirectiveBody body) throws TemplateException, IOException {
//		ApplicationContext applicationContext = WebApplicationContextUtils.getWebApplicationContext(servletContext);
//		IBannerDao bannerDao =  (IBannerDao) applicationContext.getBean("IBannerDao");
//		String var = TmTemplateDirectiveModelUtil.getString("var", params);
//		Integer id = TmTemplateDirectiveModelUtil.getInteger("id", params);
//		if(TmStringUtils.isEmpty(var))var="banner";
//		HashMap<String, Object> banner = bannerDao.getBanner(id);
//		if (banner != null) {
//			env.setVariable(var, BeansWrapper.BEANS_WRAPPER.wrap(banner));
//		}
//
//		if (body != null) {
//			if (banner != null) {
//				body.render(env.getOut());
//			}
//		}
//	}
//	
//	@Override
//	public void setServletContext(ServletContext servletContext) {
//		this.servletContext = servletContext;
//	}
//}
