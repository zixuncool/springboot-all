package com.rumo.config;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.core.convert.converter.Converter;

public class StringToDateConverter implements Converter<String, Date> {

	private static final String dateFormat = "yyyy-MM-dd HH:mm:ss";
	private static final String shortDateFormat = "yyyy-MM-dd";

	@Override
	public Date convert(String source) {
		if (source == null || "".equals(source)) {
			return null;
		}
		source = source.trim();
		try {
			if (source.contains("-")) {
				SimpleDateFormat formatter;
				if (source.contains(":")) {
					formatter = new SimpleDateFormat(dateFormat);
				} else {
					formatter = new SimpleDateFormat(shortDateFormat);
				}
				return formatter.parse(source);
			} else if (source.matches("^\\d+$")) {
				Long lDate = new Long(source);
				return new Date(lDate);
			}
		} catch (Exception e) {
			throw new RuntimeException(String.format("parser %s to Date fail", source));
		}
		throw new RuntimeException(String.format("parser %s to Date fail", source));
	}
}