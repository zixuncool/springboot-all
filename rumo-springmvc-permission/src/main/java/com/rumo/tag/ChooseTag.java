package com.rumo.tag;

import java.io.IOException;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.JspFragment;
import javax.servlet.jsp.tagext.SimpleTagSupport;

//1, <sky:choose> content </sky:choose>
public class ChooseTag extends SimpleTagSupport {
	private boolean done = false;

	public boolean isDone() {
		return done;
	}

	public void setDone(boolean done) {
		this.done = done;
	}

	@Override
	public void doTag() throws JspException, IOException {
		JspFragment jspFragment = this.getJspBody();
		jspFragment.invoke(null);
	}

}