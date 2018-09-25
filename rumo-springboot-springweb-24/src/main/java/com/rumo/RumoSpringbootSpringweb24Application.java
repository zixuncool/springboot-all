package com.rumo;

import java.util.Locale;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.servlet.LocaleResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.i18n.SessionLocaleResolver;

@SpringBootApplication
@EnableWebMvc //开启外部springmvc的配置
public class RumoSpringbootSpringweb24Application {

	public static void main(String[] args) {
		SpringApplication.run(RumoSpringbootSpringweb24Application.class, args);
	}
	
	
    /**
     * 增加自定义视图变量和方法
     *
     * @return
     */
   /*  @Bean
	    public CommandLineRunner customFreemarker(FreeMarkerViewResolver resolver) {
	        return new CommandLineRunner() {
	            @Override
	            public void run(String... strings) throws Exception {
				    //增加视图
	                resolver.setViewClass(MyFreemarkerView.class);
	                //添加自定义解析器 添加自定义标签的部分
	                Map<String, Object> map = resolver.getAttributesMap();
	                map.put("dateFormat", new DateFormateMethodTag());
	            }
	        };
	    }
	*/
    
   /* @Bean(initMethod="init")
	public MyFreemarkerViewResolver getMyFreemarkerViewResolver() {
		return new MyFreemarkerViewResolver();
	}*/
	
	
}
