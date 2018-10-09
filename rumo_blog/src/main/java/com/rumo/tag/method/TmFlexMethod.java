package com.rumo.tag.method;

import java.util.List;

import org.springframework.stereotype.Component;

import com.rumo.util.SubStringHTML;

import freemarker.template.TemplateMethodModelEx;
import freemarker.template.TemplateModelException;

@Component("flex")
public class TmFlexMethod implements TemplateMethodModelEx {
	// 这里的长度计算，以汉字为标准，两个字母作为一个字符
	@SuppressWarnings("rawtypes")
	public Object exec(List args) throws TemplateModelException {
		if (args.size() > 2)
			throw new TemplateModelException("Wrong arguments!");
		String content = String.valueOf(args.get(0));
		Integer length = Integer.valueOf(String.valueOf(args.get(1)));
		String result = "";
		String message = "";
		if (content.length() > length) {
			result = SubStringHTML.subStringHTML(content, length);
			message = result + "...";
		} else {
			message = content;
		}
		return message;
	}
}
