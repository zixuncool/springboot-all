package com.rumo.config;

import java.util.Arrays;
import java.util.List;

import org.springframework.core.convert.converter.Converter;

public class StringToListConverter implements Converter<String, List<String>> {

	@Override
	public List<String> convert(String source) {
		if (source == null || source.equals(""))
			return null;
		return Arrays.asList(source.split(","));
	}

}