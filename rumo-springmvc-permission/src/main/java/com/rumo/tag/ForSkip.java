package com.rumo.tag;

import java.io.IOException;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.SimpleTagSupport;

public class ForSkip extends SimpleTagSupport {
	private String var;
	private int begin;
	private int end;
	private int step = 1; // 增量默认为1

	public void setVar(String var) {
		this.var = var;
	}

	public void setBegin(int begin) {
		this.begin = begin;
	}

	public void setEnd(int end) {
		this.end = end;
	}

	public void setStep(int step) {
		this.step = step;
	}

	@Override
	public void doTag() throws JspException, IOException {
		for (int i = this.begin; i <= this.end; i += this.step) {
			this.getJspContext().setAttribute(this.var, i);
			this.getJspBody().invoke(null);
		}
	}
}