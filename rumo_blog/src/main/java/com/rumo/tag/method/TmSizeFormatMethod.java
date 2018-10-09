package com.rumo.tag.method;

import java.util.List;

import org.springframework.stereotype.Component;

import com.rumo.util.TmFileUtil;

import freemarker.template.TemplateMethodModelEx;
import freemarker.template.TemplateModelException;

@Component("sizeFormat")
public class TmSizeFormatMethod implements TemplateMethodModelEx {
	// 这里的长度计算，以汉字为标准，两个字母作为一个字符
	@SuppressWarnings("rawtypes")
	public Object exec(List args) throws TemplateModelException {
		if (args.size() > 1)
			throw new TemplateModelException("Wrong arguments!");
		String size = String.valueOf(args.get(0));
		return TmFileUtil.countFileSize(new Long(size));
	}
}
