package com.rumo.tag;

import java.io.IOException;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.SimpleTagSupport;

public class OtherWiseTag extends SimpleTagSupport {
	@Override
	public void doTag() throws JspException, IOException {
		// 得到父类标签对象，获取到Done的状态，进行相应的处理
		ChooseTag chooseTag = (ChooseTag) this.getParent();
		boolean done = chooseTag.isDone();
		if (!done) {
			this.getJspBody().invoke(null);
			chooseTag.setDone(true);
		}
	}
}