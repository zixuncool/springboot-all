package com.rumo.tag.method;

import java.util.List;

import org.springframework.stereotype.Component;

import freemarker.template.TemplateMethodModelEx;
import freemarker.template.TemplateModelException;

@Component("trim")
public class TmTrimMethod implements TemplateMethodModelEx {
	// 这里的长度计算，以汉字为标准，两个字母作为一个字符
	@SuppressWarnings("rawtypes")
	public Object exec(List args) throws TemplateModelException {
		if (args.size() > 1)
			throw new TemplateModelException("Wrong arguments!");
		String music = String.valueOf(args.get(0));
		return music.trim();
	}
}
