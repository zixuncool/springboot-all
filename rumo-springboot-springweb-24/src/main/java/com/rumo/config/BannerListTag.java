//package com.tz.core.tag.banner;
//
//import java.io.IOException;
//import java.util.List;
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
//import com.tz.model.Banner;
//import com.tz.model.TmParams;
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
//@Component("bannerList")
//public class BannerListTag implements TemplateDirectiveModel ,ServletContextAware {
//	private ServletContext servletContext;
//	@SuppressWarnings({ "rawtypes", "unchecked" })
//	public void execute(Environment env, Map params, TemplateModel[] loopVars,
//			TemplateDirectiveBody body) throws TemplateException, IOException {
//		ApplicationContext applicationContext = WebApplicationContextUtils.getWebApplicationContext(servletContext);
//		IBannerDao bannerDao =  (IBannerDao) applicationContext.getBean("IBannerDao");
//		String var = TmTemplateDirectiveModelUtil.getString("var", params);
//		Integer pageNo = TmTemplateDirectiveModelUtil.getInteger("pageNo", params);
//		Integer period = TmTemplateDirectiveModelUtil.getInteger("period", params);
//		Integer pageSize = TmTemplateDirectiveModelUtil.getInteger("pageSize", params);
//		String orderSql = TmTemplateDirectiveModelUtil.getString("order", params);
//		Integer collegeId = TmTemplateDirectiveModelUtil.getInteger("collegeId", params);
//		Integer type = TmTemplateDirectiveModelUtil.getInteger("type", params);
//		
//		if(TmStringUtils.isEmpty(var))var="banner";
//		TmParams tmParams = new TmParams();
//		tmParams.setCollegeId(collegeId);
//		tmParams.setStatus(1);
//		tmParams.setPeriod(period);
//		tmParams.setType(type);
//		tmParams.setPageNo(pageNo==null?0:pageNo);
//		tmParams.setPageSize(pageSize==null?60:pageSize);
//		tmParams.setOrderSql(orderSql==null?" sort desc":orderSql);
//		List<Banner> banners = bannerDao.findBanners(tmParams);
//		if (body != null) {
//			int i = 0;
//			env.setVariable(var+"_size", BeansWrapper.BEANS_WRAPPER.wrap(banners.size()));
//			for (Banner banner : banners) {
//				env.setVariable(var, BeansWrapper.BEANS_WRAPPER.wrap(banner));
//				env.setVariable(var+"_index", BeansWrapper.BEANS_WRAPPER.wrap(i));
//				body.render(env.getOut());
//				i++;
//			}
//		} else {
//		}
//	}
//	
//	@Override
//	public void setServletContext(ServletContext servletContext) {
//		this.servletContext = servletContext;
//	}
//}
