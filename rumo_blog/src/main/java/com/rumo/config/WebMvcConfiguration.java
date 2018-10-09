package com.rumo.config;

import java.util.List;
import java.util.Locale;

import org.springframework.boot.SpringBootConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.format.FormatterRegistry;
import org.springframework.web.method.support.HandlerMethodArgumentResolver;
import org.springframework.web.servlet.LocaleResolver;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.i18n.LocaleChangeInterceptor;
import org.springframework.web.servlet.i18n.SessionLocaleResolver;

/**
 * 
 * @author Administrator
 * 
 *         WebMvcConfiguration 相当于 springmvc 的 spring-servlet.xml文件
 *
 */
@SpringBootConfiguration
public class WebMvcConfiguration implements WebMvcConfigurer {

	/**
	 * 处理数据类型转换的方法
	 */
	@Override
	public void addFormatters(FormatterRegistry registry) {
		// 注册string--date
		registry.addConverter(new StringToDateConverter());
		// 注册string--string[]
		//registry.addConverter(new StringToArrayConverter());
		// 注册string-list
		//registry.addConverter(new StringToListConverter());
	}

	/**
	 * 消息转换，一般用于处理关于数据返回的时候输出格式指明。
	 */
	/*@Override
	public void configureMessageConverters(List<HttpMessageConverter<?>> messageConverters) {
		// 创建fastjson转换器
		FastJsonHttpMessageConverter converter = new FastJsonHttpMessageConverter();
		// 创建fastjson配置对象
		FastJsonConfig config = new FastJsonConfig();
		config.setSerializerFeatures(SerializerFeature.PrettyFormat);
		config.setDateFormat("yyyy-MM-dd HH:mm:ss");

		// 中文乱码解决方案
		List<MediaType> mediaTypes = new ArrayList<>();
		mediaTypes.add(MediaType.APPLICATION_JSON_UTF8);// 设定json格式且编码为UTF-8
		converter.setSupportedMediaTypes(mediaTypes);

		// config.setFeatures(Feature.AllowUnQuotedFieldNames);;

		converter.setFastJsonConfig(config);
		// 添加到转换器中
		messageConverters.add(converter);
	}*/

	public void addInterceptors(InterceptorRegistry registry) {
		registry.addInterceptor(new LoginInterceptor())
		.addPathPatterns("/admin/**","/user/**");
		registry.addInterceptor(localeChangeInterceptor());
	}

	/**
	 * 注册参数类型转换
	 */
	@Override
	public void addArgumentResolvers(List<HandlerMethodArgumentResolver> resolvers) {
		resolvers.add(new UserArgumentResolver());
	}

	@Bean
	public LocaleResolver localeResolver() {
		SessionLocaleResolver slr = new SessionLocaleResolver();
		// 默认语言
		slr.setDefaultLocale(Locale.CHINA);
		return slr;
	}

	@Bean
	public LocaleChangeInterceptor localeChangeInterceptor() {
		LocaleChangeInterceptor lci = new LocaleChangeInterceptor();
		// 参数名
		lci.setParamName("lang");
		return lci;
	}
	
	
	/* public void addResourceHandlers(ResourceHandlerRegistry registry) {
         registry.addResourceHandler("swagger-ui.html")
         .addResourceLocations("classpath:/META-INF/resources/");
         registry.addResourceHandler("/webjars*")
         .addResourceLocations("classpath:/META-INF/resources/webjars/");
     }*/

	 
}
