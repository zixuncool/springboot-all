package com.rumo.tag.method;

import java.util.List;

import org.jsoup.Jsoup;
import org.springframework.stereotype.Component;

import com.rumo.util.TmStringUtils;

import freemarker.template.TemplateMethodModelEx;
import freemarker.template.TemplateModelException;

@Component("filterEmpty")
public class TmFilterContentTagMethod implements TemplateMethodModelEx {
	// 这里的长度计算，以汉字为标准，两个字母作为一个字符
	@SuppressWarnings("rawtypes")
	public Object exec(List args) throws TemplateModelException {
		if (args.size() > 2)
			throw new TemplateModelException("Wrong arguments!");
		String content = String.valueOf(args.get(0));
		String len = String.valueOf(args.get(1));
		if (TmStringUtils.isEmpty(len))
			len = "200";
		String result = Jsoup.parse(content).text();
		if (TmStringUtils.isNotEmpty(result) && result.length() > Integer.parseInt(len)) {
			return result.substring(0, Integer.parseInt(len)) + "...";
		} else {
			return result;
		}
	}

}
