package com.rumo.config;

import org.springframework.core.convert.converter.Converter;

//http://localhost:8080/saveuser?id=1&username=mofeng&age=32&birthday=1986-02-07%2012:12:12&names=keke,mofeng,zhagnsan&courses=java,php,net
public class StringToArrayConverter implements Converter<String, String[]> {

	@Override
	public String[] convert(String source) {
		if(source==null || source.equals(""))return null;
		return source.split(",");
	}
   
}