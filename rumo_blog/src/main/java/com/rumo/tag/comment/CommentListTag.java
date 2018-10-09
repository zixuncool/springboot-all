package com.rumo.tag.comment;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletContext;

import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;
import org.springframework.web.context.ServletContextAware;
import org.springframework.web.context.support.WebApplicationContextUtils;

import com.github.pagehelper.PageInfo;
import com.rumo.pojo.Comment;
import com.rumo.vo.CommentVo;
import com.rumo.service.comment.CommentServiceImpl;
import com.rumo.service.comment.ICommentService;
import com.rumo.tag.TmTemplateDirectiveModelUtil;
import com.rumo.util.TmStringUtils;
import com.rumo.vo.ServerResponse;

import freemarker.core.Environment;
import freemarker.ext.beans.BeansWrapper;
import freemarker.ext.beans.BeansWrapperBuilder;
import freemarker.template.Configuration;
import freemarker.template.TemplateDirectiveBody;
import freemarker.template.TemplateDirectiveModel;
import freemarker.template.TemplateException;
import freemarker.template.TemplateModel;

/**
 *评论
 *CommentListTag
  *  创建人:中华墨风
  *  时间：2018年10月09日 22:55:35
 * @version 1.0.0
 *
 */
@Component("commentList")
public class CommentListTag implements TemplateDirectiveModel, ServletContextAware {
	private ServletContext servletContext;

	@SuppressWarnings({ "rawtypes", "unchecked" })
	public void execute(Environment env, Map params, TemplateModel[] loopVars, TemplateDirectiveBody body)
			throws TemplateException, IOException {
		ApplicationContext applicationContext = WebApplicationContextUtils.getWebApplicationContext(servletContext);
		ICommentService commentService = (ICommentService) applicationContext.getBean(CommentServiceImpl.class);
		String var = TmTemplateDirectiveModelUtil.getString("var", params);
		Integer pageNo = TmTemplateDirectiveModelUtil.getInteger("pageNo", params);
		Integer pageSize = TmTemplateDirectiveModelUtil.getInteger("pageSize", params);
		String orderby = TmTemplateDirectiveModelUtil.getString("sort", params);

		if (TmStringUtils.isEmpty(var))
			var = "comment";
		if (pageNo == null)
			pageNo = 0;
		if (pageSize == null)
			pageSize = 20;
		if (orderby == null)
			orderby = " create_time desc ";

		CommentVo commentVo = new CommentVo();
		commentVo.setOrderBy(orderby);
		commentVo.setPageNo(pageNo);
		commentVo.setPageSize(pageSize);

		BeansWrapper beansWrapper =  new BeansWrapperBuilder(Configuration.VERSION_2_3_28).build();
		ServerResponse serverResponse = commentService.queryCommentAll(commentVo);
		PageInfo<Comment> pageInfo = (PageInfo<Comment>) serverResponse.getData();
		List<Comment> comments = pageInfo.getList();
		env.setVariable(var+"_page", beansWrapper.wrap(pageInfo));
		if (body != null) {
			int i = 0;
			env.setVariable(var + "_size", beansWrapper.wrap(comments.size()));
			for (Comment comment : comments) {
				env.setVariable(var,beansWrapper.wrap(comment));
				env.setVariable(var + "_index", beansWrapper.wrap(i));
				body.render(env.getOut());
				i++;
			}
		} else {
		}
	}

	@Override
	public void setServletContext(ServletContext servletContext) {
		this.servletContext = servletContext;
	}
}