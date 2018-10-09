package com.rumo.tag.comment;

import java.io.IOException;
import java.util.Map;

import javax.servlet.ServletContext;

import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;
import org.springframework.web.context.ServletContextAware;
import org.springframework.web.context.support.WebApplicationContextUtils;

import com.rumo.service.comment.CommentServiceImpl;
import com.rumo.service.comment.ICommentService;
import com.rumo.tag.TmTemplateDirectiveModelUtil;
import com.rumo.util.TmStringUtils;

import freemarker.core.Environment;
import freemarker.ext.beans.BeansWrapperBuilder;
import freemarker.template.Configuration;
import freemarker.template.TemplateDirectiveBody;
import freemarker.template.TemplateDirectiveModel;
import freemarker.template.TemplateException;
import freemarker.template.TemplateModel;

/**
 * 评论
  CommentBeanTag
  *  创建人:中华墨风 
  *  时间：2018年10月09日 22:55:35
 * @version 1.0.0
 *
 */
@Component("commentBean")
public class CommentBeanTag implements TemplateDirectiveModel ,ServletContextAware {
	private ServletContext servletContext;
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public void execute(Environment env, Map params, TemplateModel[] loopVars,
			TemplateDirectiveBody body) throws TemplateException, IOException {
		ApplicationContext applicationContext = WebApplicationContextUtils.getWebApplicationContext(servletContext);
		ICommentService commentService = (ICommentService) applicationContext.getBean(CommentServiceImpl.class);
		String var = TmTemplateDirectiveModelUtil.getString("var", params);
		Integer id = TmTemplateDirectiveModelUtil.getInteger("id", params);
		if(TmStringUtils.isEmpty(var))var="comment";
		Map<String, Object> comment = (Map<String, Object>) commentService.getCommentById(id).getData();
		if (comment != null) {
			env.setVariable(var, new BeansWrapperBuilder(Configuration.VERSION_2_3_28).build().wrap(comment));
		}

		if (body != null) {
			if (comment != null) {
				body.render(env.getOut());
			}
		}
	}
	
	@Override
	public void setServletContext(ServletContext servletContext) {
		this.servletContext = servletContext;
	}
}
