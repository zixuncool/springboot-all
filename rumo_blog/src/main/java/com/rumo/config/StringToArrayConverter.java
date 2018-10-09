package com.rumo.config;

import org.springframework.core.convert.converter.Converter;

public class StringToArrayConverter implements Converter<String, String[]> {

	@Override
	public String[] convert(String source) {
		if (source == null || source.equals(""))
			return null;
		return source.split(",");
	}

}