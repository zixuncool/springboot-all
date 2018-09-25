package com.rumo.tag;

import java.io.IOException;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.SimpleTagSupport;

public class WhileTag extends SimpleTagSupport {

	private boolean test;

	public void setTest(boolean test) {
		this.test = test;
	}

	@Override
	public void doTag() throws JspException, IOException {
		// 得到父标签后获取是否已经做过了
		ChooseTag chooseTag = (ChooseTag) this.getParent();
		boolean done = chooseTag.isDone();

		// 如果没有做过,并且表达式成立
		if (!done && test) {
			this.getJspBody().invoke(null);
			chooseTag.setDone(true);
		}
	}
}