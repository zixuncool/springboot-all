package com.rumo.tag;

import java.io.IOException;
import java.io.StringWriter;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.PageContext;
import javax.servlet.jsp.tagext.JspFragment;
import javax.servlet.jsp.tagext.SimpleTagSupport;

//<simple:filter>标签处理类
public class FilterTag extends SimpleTagSupport {
	
	public void doTag() throws JspException, IOException {
		JspFragment jspFragment = this.getJspBody();
		StringWriter writer = new StringWriter();
		jspFragment.invoke(writer);
		String temp = writer.getBuffer().toString();
		// 结果必定是转义后的字符串
		temp = filter(temp);
		PageContext pageContext = (PageContext) this.getJspContext();
		pageContext.getOut().write(temp);
	}

	public String filter(String message) {
		if (message == null)
			return (null);
		char content[] = new char[message.length()];
		message.getChars(0, message.length(), content, 0);
		StringBuffer result = new StringBuffer(content.length + 50);
		for (int i = 0; i < content.length; i++) {
			switch (content[i]) {
			case '<':
				result.append("&lt;");
				break;
			case '>':
				result.append("&gt;");
				break;
			case '&':
				result.append("&amp;");
				break;
			case '"':
				result.append("&quot;");
				break;
			default:
				result.append(content[i]);
			}
		}
		return (result.toString());
	}
}