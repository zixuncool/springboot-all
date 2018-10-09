package com.rumo.tag.method;

import java.util.List;

import org.springframework.stereotype.Component;

import com.rumo.util.RelativeDateFormat;

import freemarker.ext.beans.DateModel;
import freemarker.template.TemplateMethodModelEx;
import freemarker.template.TemplateModelException;


@Component("relative")
public class RelativeDateFormatTag implements TemplateMethodModelEx {
	@Override
	public Object exec(List arguments) throws TemplateModelException {
		if (null != arguments && 1 == arguments.size()) {
			DateModel date = (DateModel) arguments.get(0);
			return RelativeDateFormat.format(date.getAsDate());
		} else {
			return arguments.get(0);
		}
	}
}