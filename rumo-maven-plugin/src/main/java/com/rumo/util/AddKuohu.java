package com.rumo.util;

import java.util.List;

import freemarker.template.TemplateMethodModelEx;
import freemarker.template.TemplateModelException;

public class AddKuohu implements TemplateMethodModelEx {
	// 这里的长度计算，以汉字为标准，两个字母作为一个字�?
	@SuppressWarnings("rawtypes")
	public Object exec(List args) throws TemplateModelException {
		if (args.size() > 1)
			throw new TemplateModelException("Wrong arguments!");

		String numstr = String.valueOf(args.get(0));
		return  "#{"+numstr+"}";
	}

}
