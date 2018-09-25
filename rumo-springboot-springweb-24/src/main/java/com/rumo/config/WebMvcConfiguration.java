package com.rumo.config;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

import org.springframework.boot.SpringBootConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.format.FormatterRegistry;
import org.springframework.http.MediaType;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.web.method.support.HandlerMethodArgumentResolver;
import org.springframework.web.servlet.LocaleResolver;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.i18n.LocaleChangeInterceptor;
import org.springframework.web.servlet.i18n.SessionLocaleResolver;

import com.alibaba.fastjson.serializer.SerializerFeature;
import com.alibaba.fastjson.support.config.FastJsonConfig;
import com.alibaba.fastjson.support.spring.FastJsonHttpMessageConverter;

/**
 * 
 * @author Administrator
 * 
 * WebMvcConfiguration 相当于 springmvc 的 spring-servlet.xml文件
 *
 */
@SpringBootConfiguration
public class WebMvcConfiguration implements WebMvcConfigurer {

	/**
     * 	该选项允许静态资源请求按照特定的URL pattern，由ResourceHttpRequestHandler来服务 -- 从Resource locations列表中的任意一个。
     *   	这提供了一种便捷的方式来服务静态资源，不只是web app root的位置，还包括classpath （牛掰大了）。其cache-period property可以被用来设置失效headers （对于Page Speed and YSlow等工具来说，推荐设为1年），这样它们会被client更有效的使用。handler还会正确的evaluate Last-Modified header
     *  (如果有) -- 并在恰当的时候返回 304 status code，这样会避免不必要的重复资源获取。例如，想要使用 /resources/** 形式的URL pattern来请求 web root 下public-resources 文件夹中内容，你可以这样做：
     * registry.addResourceHandler("/resources/**").addResourceLocations("/public-resources/");
     * 
     * <mvc:resources mapping="/resources/**" location="/public-resources/"/>
     *  registry.addResourceHandler("/resources/**") .addResourceLocations("/", "classpath:/META-INF/public-web-resources/");
     */
	@Override
	public void addResourceHandlers(ResourceHandlerRegistry registry) {
	  	//registry.addResourceHandler("/**").addResourceLocations("classpath:/static/").setCacheControl(CacheControl.maxAge(1, TimeUnit.HOURS).cachePublic());;
    	registry.addResourceHandler("/resources/**").addResourceLocations("classpath:/static/","classpath:/public/");
    	//开发完毕上线的时候在加上
    	//.setCachePeriod(31556926);
  
	}

	/**
	 * 处理数据类型转换的方法
	 */
	@Override
	public void addFormatters(FormatterRegistry registry) {
		//注册string--date
		registry.addConverter(new StringToDateConverter());
		//注册string--string[]
		registry.addConverter(new StringToArrayConverter());
		//注册string-list
		registry.addConverter(new StringToListConverter());
	}

	

	
	/**
	 * 消息转换，一般用于处理关于数据返回的时候输出格式指明。
	 */
	@Override
	public void configureMessageConverters(List<HttpMessageConverter<?>> messageConverters) {
		//public byte/short/int/long/float/double/boolean/char/String
		/*StringHttpMessageConverter stringHttpMessageConverter = new StringHttpMessageConverter(Charset.forName("UTF-8"));
		messageConverters.add(stringHttpMessageConverter);
		
		messageConverters.add(new ByteArrayHttpMessageConverter());
		messageConverters.add(new ResourceHttpMessageConverter());
		messageConverters.add(new ResourceRegionHttpMessageConverter());
		messageConverters.add(new SourceHttpMessageConverter<>());
		messageConverters.add(new AllEncompassingFormHttpMessageConverter());
		
		//只有对象类型才会进入次json转换
		Jackson2ObjectMapperBuilder builder = Jackson2ObjectMapperBuilder.json();
		//日志类型转换
		builder.dateFormat(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss"));
		MappingJackson2HttpMessageConverter jsConverter =  new MappingJackson2HttpMessageConverter(builder.build());
		//美化输出
		jsConverter.setDefaultCharset(Charset.forName("UTF-8"));
		jsConverter.setPrefixJson(true);
		jsConverter.setPrettyPrint(true);
		messageConverters.add(jsConverter);*/
		
		
		
		//创建fastjson转换器
		FastJsonHttpMessageConverter converter = new FastJsonHttpMessageConverter();
		//创建fastjson配置对象
		FastJsonConfig config = new FastJsonConfig();
		config.setSerializerFeatures(SerializerFeature.PrettyFormat);
		config.setDateFormat("yyyy-MM-dd HH:mm:ss");
		
		// 中文乱码解决方案
        List<MediaType> mediaTypes = new ArrayList<>();
        mediaTypes.add(MediaType.APPLICATION_JSON_UTF8);//设定json格式且编码为UTF-8
        converter.setSupportedMediaTypes(mediaTypes);
        
        //config.setFeatures(Feature.AllowUnQuotedFieldNames);;
        
		converter.setFastJsonConfig(config);
		//添加到转换器中
		messageConverters.add(converter);
	}
	
	
	/**
	 * <mvc:interceptors>
	 *
	 *    <mvc:interceptor>
	 *        <mvc:filter path="/**"></mvc:filter>
	 *        <mvc:filter excludePath="/reg"></mvc:filter>
	 *        <mvc:filter excludePath="/login"></mvc:filter>
	 *        <bean class="com.rumo.config.LoginInterceptor/> == registry.addInterceptor(new LoginInterceptor())
	 *    </mvc:interceptor>
	 *
	 * </mvc:interceptors>
	 * @param registry
	 */

	public void addInterceptors(InterceptorRegistry registry) {
		registry.addInterceptor(new LoginInterceptor()).addPathPatterns("/admin/**").excludePathPatterns("/admin/course");
		 registry.addInterceptor(localeChangeInterceptor());
		//registry.addInterceptor(new LoginInterceptor()).addPathPatterns("/**").excludePathPatterns("/login/**","/static/**");
		//.excludePathPatterns("/login/**","/resources/**");
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

	
}
