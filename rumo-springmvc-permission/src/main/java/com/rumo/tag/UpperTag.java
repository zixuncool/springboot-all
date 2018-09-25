package com.rumo.tag;

import java.io.IOException;
import java.io.StringWriter;

import javax.servlet.jsp.JspContext;
import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.JspFragment;
import javax.servlet.jsp.tagext.SimpleTagSupport;

public class UpperTag extends SimpleTagSupport {
	@Override
	public void doTag() throws JspException, IOException {
		JspFragment jspFragment = this.getJspBody();

		// 创建一个缓冲区，用于存储标签中的内容
		StringWriter writer = new StringWriter();
		jspFragment.invoke(writer);

		// 将缓冲区中的内容进行处理(小写 --> 大写)
		StringBuffer buffer = writer.getBuffer();
		String upString = buffer.toString().toUpperCase();

		// 将转换后的内容输出到浏览器中
		JspContext jspContext = this.getJspContext();
		JspWriter out = jspContext.getOut();
		out.write(upString);
	}
}