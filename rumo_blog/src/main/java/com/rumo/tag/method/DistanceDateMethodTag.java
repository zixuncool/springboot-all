package com.rumo.tag.method;

import java.util.Date;
import java.util.List;

import org.springframework.stereotype.Component;

import com.rumo.util.date.TmDateUtil;

import freemarker.template.SimpleDate;
import freemarker.template.TemplateMethodModelEx;
import freemarker.template.TemplateModelException;

/**
 * Created by shiqm on 2017-05-03.
 */
@Component("distanct")
public class DistanceDateMethodTag implements TemplateMethodModelEx {
	@Override
	public Object exec(List arguments) throws TemplateModelException {
		if (null != arguments && 1 == arguments.size()) {
			SimpleDate date = (SimpleDate) arguments.get(0);
			long days = TmDateUtil.getDistanceDays(date.getAsDate(), new Date());
			return days;
		} else {
			return arguments.get(0);
		}
	}
}