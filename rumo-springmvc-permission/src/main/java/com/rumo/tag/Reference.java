package com.rumo.tag;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.jsp.JspException;
import javax.servlet.jsp.PageContext;
import javax.servlet.jsp.tagext.JspFragment;
import javax.servlet.jsp.tagext.SimpleTagSupport;

public class Reference extends SimpleTagSupport {
	private String url;
	private String error;

	public void setUrl(String url) {
		this.url = url;
	}

	public void setError(String error) {
		this.error = error;
	}

	@Override
	public void doTag() throws JspException, IOException {
		// 得到页面内置对象
		PageContext pageContext = (PageContext) this.getJspContext();
		HttpServletRequest request = (HttpServletRequest) pageContext.getRequest();
		HttpServletResponse response = (HttpServletResponse) pageContext.getResponse();

		// 获取标签体中的内容并进行处理
		JspFragment jspFragment = this.getJspBody();
		String refer = request.getHeader("referer");
		System.out.println(refer);
		if (this.url.equals(refer)) { // referer头表明来自于哪里
			jspFragment.invoke(null);
		} else {
			try {
				request.getRequestDispatcher(this.error).forward(request, response);
			} catch (ServletException e) {
				e.printStackTrace();
			}
		}

	}
}
