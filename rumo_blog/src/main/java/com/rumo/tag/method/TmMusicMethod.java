package com.rumo.tag.method;

import java.util.List;

import org.springframework.stereotype.Component;

import com.rumo.util.TmStringUtils;

import freemarker.template.TemplateMethodModelEx;
import freemarker.template.TemplateModelException;

@Component("musicScoret")
public class TmMusicMethod implements TemplateMethodModelEx {
	// 这里的长度计算，以汉字为标准，两个字母作为一个字符
	@SuppressWarnings("rawtypes")
	public Object exec(List args) throws TemplateModelException {
		if (args.size() > 1)
			throw new TemplateModelException("Wrong arguments!");
		String music = String.valueOf(args.get(0));
		return TmStringUtils.encryption(music, 9);
	}
}
