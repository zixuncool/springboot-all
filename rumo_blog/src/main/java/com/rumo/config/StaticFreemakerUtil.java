/*package com.rumo.config;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.io.FileUtils;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;
import org.springframework.ui.freemarker.FreeMarkerTemplateUtils;
import org.springframework.util.ResourceUtils;
import org.springframework.web.servlet.view.freemarker.FreeMarkerConfigurer;
import org.springframework.web.servlet.view.freemarker.FreeMarkerViewResolver;

import com.github.pagehelper.PageInfo;
import com.rumo.pojo.Course;
import com.rumo.service.blog.IBlogService;
import com.rumo.service.course.ICourseService;
import com.rumo.util.TmStringUtils;
import com.rumo.vo.BlogVo;
import com.rumo.vo.CourseVo;
import com.rumo.vo.ServerResponse;

import freemarker.template.Configuration;
import freemarker.template.DefaultObjectWrapper;
import freemarker.template.Template;
import freemarker.template.TemplateException;
import freemarker.template.TemplateModel;

@Component
public class StaticFreemakerUtil  implements ApplicationContextAware{

	@Autowired
	private FreeMarkerConfigurer freeMarkerConfigurer;
	@Autowired
	private FreeMarkerViewResolver resolver;
	
	private ApplicationContext context;
	
	@Autowired
	private IBlogService blogService;
	@Autowired
	private ICourseService courseService;
	
	public  String blogid(HttpServletRequest request) {
		try {
			Map<String, Object> root = new HashMap<>();
			root.put("request", request);
			root.put("basePath", RequestUtil.getBasePath(request));
			root.put("adminPath", RequestUtil.getBasePath(request)+"/admin");
			resolver.setViewClass(FreemarkerView.class);
			Map<String, TemplateModel> beans = (Map<String, TemplateModel>) context.getBeansOfType(TemplateModel.class);
			for (Entry<String, TemplateModel> entry : beans.entrySet()) {
				root.put(entry.getKey(), entry.getValue());
			}
			
			File templatePath = ResourceUtils.getFile("classpath:templates");
			String rootPath = request.getServletContext().getRealPath("/blogs");
			
			//查询所有的博客
			Integer blogId = Integer.parseInt(request.getParameter("blogId"));
			Map<String, Object> blog = (Map<String, Object>) blogService.getBlogMapById(blogId).getData();
			root.put("id", blogId);
			String filename = blog.get("staticLink")==null?null:String.valueOf(blog.get("staticLink"));
			if(TmStringUtils.isEmpty(filename)) {
				filename = TmStringUtils.getRandomString(10)+blog.get("id")+TmStringUtils.getRandomString(10)+".html";
			}else {
				filename = filename.replaceAll("blogs\\/","");
			}
			Configuration configuration = freeMarkerConfigurer.getConfiguration();
			// 得到模板
			// 如果你分父目录不存在，递归创建
			File parentPath = new File(rootPath);
			if (!parentPath.exists())
				parentPath.mkdirs();
			// 组合最终的文件路径
			File targetFile = new File(parentPath, filename);
			//不需要设定模板的路径了，因为springboot会自动去装配模板路径了
			configuration.setDirectoryForTemplateLoading(templatePath);
			configuration.setObjectWrapper(new DefaultObjectWrapper(Configuration.VERSION_2_3_28));
			// 读取模板
			Template template = configuration.getTemplate("blog/detail.html","UTF-8");
			try {
				// 将数据和模板中要动态替换的内容进行融合渲染，返回渲染以后的网页内容
				String text = FreeMarkerTemplateUtils.processTemplateIntoString(template, root);
				FileUtils.write(targetFile, text, "UTF-8");
				
				//修改
				String staticLink = "blogs/"+filename;
				BlogVo blogVo = new BlogVo();
				blogVo.setId(Integer.parseInt(String.valueOf(blog.get("id"))));
				blogVo.setStaticLink(staticLink);
				blogService.updateBlog(blogVo);
				
			} catch (TemplateException e) {
				e.printStackTrace();
				return null;
			}
			return "success";
		} catch (IOException e) {
			e.printStackTrace();
			return null;
		}
	}
	
	public  String blog(HttpServletRequest request) {
		try {
			Map<String, Object> root = new HashMap<>();
			root.put("request", request);
			root.put("basePath", RequestUtil.getBasePath(request));
			root.put("adminPath", RequestUtil.getBasePath(request)+"/admin");
			resolver.setViewClass(FreemarkerView.class);
			Map<String, TemplateModel> beans = (Map<String, TemplateModel>) context.getBeansOfType(TemplateModel.class);
			for (Entry<String, TemplateModel> entry : beans.entrySet()) {
				root.put(entry.getKey(), entry.getValue());
			}
			
			File templatePath = ResourceUtils.getFile("classpath:templates");
			String rootPath = request.getServletContext().getRealPath("/blogs");
			
			
			//查询所有的博客
			BlogVo blogVo = new BlogVo();
			blogVo.setPageSize(5000);
			ServerResponse response = blogService.queryBlogAll(blogVo);
			PageInfo<Map<String, Object>> pageInfo = (PageInfo<Map<String, Object>>) response.getData();
			List<Map<String, Object>> blogs = pageInfo.getList();
			for (Map<String, Object> blog : blogs) {
				root.put("id", blog.get("id"));
				String filename = blog.get("staticLink")==null?null:String.valueOf(blog.get("staticLink"));
				if(TmStringUtils.isEmpty(filename)) {
					filename = TmStringUtils.getRandomString(10)+blog.get("id")+TmStringUtils.getRandomString(10)+".html";
				}else {
					filename = filename.replaceAll("blogs\\/","");
				}
				Configuration configuration = freeMarkerConfigurer.getConfiguration();
				// 得到模板
				// 如果你分父目录不存在，递归创建
				File parentPath = new File(rootPath);
				if (!parentPath.exists())
					parentPath.mkdirs();
				// 组合最终的文件路径
				File targetFile = new File(parentPath, filename);
				//不需要设定模板的路径了，因为springboot会自动去装配模板路径了
				configuration.setDirectoryForTemplateLoading(templatePath);
				configuration.setObjectWrapper(new DefaultObjectWrapper(Configuration.VERSION_2_3_28));
				// 读取模板
				Template template = configuration.getTemplate("blog/detail.html","UTF-8");
				try {
					// 将数据和模板中要动态替换的内容进行融合渲染，返回渲染以后的网页内容
					String text = FreeMarkerTemplateUtils.processTemplateIntoString(template, root);
					FileUtils.write(targetFile, text, "UTF-8");
					
					//修改
					String staticLink = "blogs/"+filename;
					blogVo.setId(Integer.parseInt(String.valueOf(blog.get("id"))));
					blogVo.setStaticLink(staticLink);
					blogService.updateBlog(blogVo);
					
				} catch (TemplateException e) {
					e.printStackTrace();
					return null;
				}
			}
			return "success";
		} catch (IOException e) {
			e.printStackTrace();
			return null;
		}
	}
	
	public  String courseid(HttpServletRequest request) {
		try {
			Map<String, Object> root = new HashMap<>();
			root.put("request", request);
			root.put("basePath", RequestUtil.getBasePath(request));
			root.put("adminPath", RequestUtil.getBasePath(request)+"/admin");
			resolver.setViewClass(FreemarkerView.class);
			Map<String, TemplateModel> beans = (Map<String, TemplateModel>) context.getBeansOfType(TemplateModel.class);
			for (Entry<String, TemplateModel> entry : beans.entrySet()) {
				root.put(entry.getKey(), entry.getValue());
			}
			
			File templatePath = ResourceUtils.getFile("classpath:templates");
			String rootPath = request.getServletContext().getRealPath("/courses");
			
			
			//查询所有的博客
			CourseVo courseVo = new CourseVo();
			Integer courseId = Integer.parseInt(request.getParameter("courseId"));
			Course course = (Course) courseService.getCourseById(courseId).getData();
			root.put("id", course.getId());
			String filename = course.getStaticLink()==null?null:course.getStaticLink();
			if(TmStringUtils.isEmpty(filename)) {
				filename = TmStringUtils.getRandomString(10)+course.getId()+TmStringUtils.getRandomString(10)+".html";
			}else {
				filename = filename.replaceAll("courses\\/","");
			}
			Configuration configuration = freeMarkerConfigurer.getConfiguration();
			// 得到模板
			// 如果你分父目录不存在，递归创建
			File parentPath = new File(rootPath);
			if (!parentPath.exists())
				parentPath.mkdirs();
			// 组合最终的文件路径
			File targetFile = new File(parentPath, filename);
			//不需要设定模板的路径了，因为springboot会自动去装配模板路径了
			configuration.setDirectoryForTemplateLoading(templatePath);
			configuration.setObjectWrapper(new DefaultObjectWrapper(Configuration.VERSION_2_3_28));
			// 读取模板
			Template template = configuration.getTemplate("course/detail.html","UTF-8");
			try {
				// 将数据和模板中要动态替换的内容进行融合渲染，返回渲染以后的网页内容
				String text = FreeMarkerTemplateUtils.processTemplateIntoString(template, root);
				FileUtils.write(targetFile, text, "UTF-8");
				
				//修改
				String staticLink = "courses/"+filename;
				courseVo.setId(course.getId());
				courseVo.setStaticLink(staticLink);
				courseService.updateCourse(courseVo);
				
			} catch (TemplateException e) {
				e.printStackTrace();
				return null;
			}
			return "success";
		} catch (IOException e) {
			e.printStackTrace();
			return null;
		}
	}
	
	public  String playid(HttpServletRequest request) {
		try {
			Map<String, Object> root = new HashMap<>();
			root.put("request", request);
			root.put("basePath", RequestUtil.getBasePath(request));
			root.put("adminPath", RequestUtil.getBasePath(request)+"/admin");
			resolver.setViewClass(FreemarkerView.class);
			Map<String, TemplateModel> beans = (Map<String, TemplateModel>) context.getBeansOfType(TemplateModel.class);
			for (Entry<String, TemplateModel> entry : beans.entrySet()) {
				root.put(entry.getKey(), entry.getValue());
			}
			
			File templatePath = ResourceUtils.getFile("classpath:templates");
			String rootPath = request.getServletContext().getRealPath("/plays");
			
			
			//查询所有的博客
			CourseVo courseVo = new CourseVo();
			Integer courseId = Integer.parseInt(request.getParameter("courseId"));
			Course course = (Course) courseService.getCourseById(courseId).getData();
			root.put("id", course.getId());
			String filename = course.getCourseLink()==null?null:course.getCourseLink();
			if(TmStringUtils.isEmpty(filename)) {
				filename = TmStringUtils.getRandomString(10)+course.getId()+TmStringUtils.getRandomString(10)+".html";
			}else {
				filename = filename.replaceAll("plays\\/","");
			}
			Configuration configuration = freeMarkerConfigurer.getConfiguration();
			// 得到模板
			// 如果你分父目录不存在，递归创建
			File parentPath = new File(rootPath);
			if (!parentPath.exists())
				parentPath.mkdirs();
			// 组合最终的文件路径
			File targetFile = new File(parentPath, filename);
			//不需要设定模板的路径了，因为springboot会自动去装配模板路径了
			configuration.setDirectoryForTemplateLoading(templatePath);
			configuration.setObjectWrapper(new DefaultObjectWrapper(Configuration.VERSION_2_3_28));
			// 读取模板
			Template template = configuration.getTemplate("course/play.html","UTF-8");
			try {
				// 将数据和模板中要动态替换的内容进行融合渲染，返回渲染以后的网页内容
				String text = FreeMarkerTemplateUtils.processTemplateIntoString(template, root);
				FileUtils.write(targetFile, text, "UTF-8");
				
				//修改
				String courseLink = "plays/"+filename;
				courseVo.setId(course.getId());
				courseVo.setCourseLink(courseLink);
				courseService.updateCourse(courseVo);
				
			} catch (TemplateException e) {
				e.printStackTrace();
				return null;
			}
			return "success";
		} catch (IOException e) {
			e.printStackTrace();
			return null;
		}
	}
	
	public  String course(HttpServletRequest request) {
			
		try {
			Map<String, Object> root = new HashMap<>();
			root.put("request", request);
			root.put("basePath", RequestUtil.getBasePath(request));
			root.put("adminPath", RequestUtil.getBasePath(request)+"/admin");
			resolver.setViewClass(FreemarkerView.class);
			Map<String, TemplateModel> beans = (Map<String, TemplateModel>) context.getBeansOfType(TemplateModel.class);
			for (Entry<String, TemplateModel> entry : beans.entrySet()) {
				root.put(entry.getKey(), entry.getValue());
			}
			
			File templatePath = ResourceUtils.getFile("classpath:templates");
			String rootPath = request.getServletContext().getRealPath("/courses");
			
			
			//查询所有的博客
			CourseVo courseVo = new CourseVo();
			courseVo.setPageSize(5000);
			ServerResponse response = courseService.queryCourseAll(courseVo);
			PageInfo<Course> pageInfo = (PageInfo<Course>) response.getData();
			List<Course> courses = pageInfo.getList();
			for (Course course : courses) {
				root.put("id", course.getId());
				String filename = course.getStaticLink()==null?null:course.getStaticLink();
				if(TmStringUtils.isEmpty(filename)) {
					filename = TmStringUtils.getRandomString(10)+course.getId()+TmStringUtils.getRandomString(10)+".html";
				}else {
					filename = filename.replaceAll("courses\\/","");
				}
				Configuration configuration = freeMarkerConfigurer.getConfiguration();
				// 得到模板
				// 如果你分父目录不存在，递归创建
				File parentPath = new File(rootPath);
				if (!parentPath.exists())
					parentPath.mkdirs();
				// 组合最终的文件路径
				File targetFile = new File(parentPath, filename);
				//不需要设定模板的路径了，因为springboot会自动去装配模板路径了
				configuration.setDirectoryForTemplateLoading(templatePath);
				configuration.setObjectWrapper(new DefaultObjectWrapper(Configuration.VERSION_2_3_28));
				// 读取模板
				Template template = configuration.getTemplate("course/detail.html","UTF-8");
				try {
					// 将数据和模板中要动态替换的内容进行融合渲染，返回渲染以后的网页内容
					String text = FreeMarkerTemplateUtils.processTemplateIntoString(template, root);
					FileUtils.write(targetFile, text, "UTF-8");
					
					//修改
					String staticLink = "courses/"+filename;
					courseVo.setId(course.getId());
					courseVo.setStaticLink(staticLink);
					courseService.updateCourse(courseVo);
					
				} catch (TemplateException e) {
					e.printStackTrace();
					return null;
				}
			}
			return "success";
		} catch (IOException e) {
			e.printStackTrace();
			return null;
		}
	}
	
	public  String play(HttpServletRequest request) {
		try {
			Map<String, Object> root = new HashMap<>();
			root.put("request", request);
			root.put("basePath", RequestUtil.getBasePath(request));
			root.put("adminPath", RequestUtil.getBasePath(request)+"/admin");
			resolver.setViewClass(FreemarkerView.class);
			Map<String, TemplateModel> beans = (Map<String, TemplateModel>) context.getBeansOfType(TemplateModel.class);
			for (Entry<String, TemplateModel> entry : beans.entrySet()) {
				root.put(entry.getKey(), entry.getValue());
			}
			
			File templatePath = ResourceUtils.getFile("classpath:templates");
			String rootPath = request.getServletContext().getRealPath("/plays");
			
			
			//查询所有的博客
			CourseVo courseVo = new CourseVo();
			courseVo.setPageSize(5000);
			ServerResponse response = courseService.queryCourseAll(courseVo);
			PageInfo<Course> pageInfo = (PageInfo<Course>) response.getData();
			List<Course> courses = pageInfo.getList();
			for (Course course : courses) {
				root.put("id", course.getId());
				String filename = course.getCourseLink()==null?null:course.getCourseLink();
				if(TmStringUtils.isEmpty(filename)) {
					filename = TmStringUtils.getRandomString(10)+course.getId()+TmStringUtils.getRandomString(10)+".html";
				}else {
					filename = filename.replaceAll("plays\\/","");
				}
				Configuration configuration = freeMarkerConfigurer.getConfiguration();
				// 得到模板
				// 如果你分父目录不存在，递归创建
				File parentPath = new File(rootPath);
				if (!parentPath.exists())
					parentPath.mkdirs();
				// 组合最终的文件路径
				File targetFile = new File(parentPath, filename);
				//不需要设定模板的路径了，因为springboot会自动去装配模板路径了
				configuration.setDirectoryForTemplateLoading(templatePath);
				configuration.setObjectWrapper(new DefaultObjectWrapper(Configuration.VERSION_2_3_28));
				// 读取模板
				Template template = configuration.getTemplate("course/play.html","UTF-8");
				try {
					// 将数据和模板中要动态替换的内容进行融合渲染，返回渲染以后的网页内容
					String text = FreeMarkerTemplateUtils.processTemplateIntoString(template, root);
					FileUtils.write(targetFile, text, "UTF-8");
					
					//修改
					String courseLink = "plays/"+filename;
					courseVo.setId(course.getId());
					courseVo.setCourseLink(courseLink);
					courseService.updateCourse(courseVo);
					
				} catch (TemplateException e) {
					e.printStackTrace();
					return null;
				}
			}
			return "success";
		} catch (IOException e) {
			e.printStackTrace();
			return null;
		}
	}
	
	
	public  String index(HttpServletRequest request) {
		try {
			Map<String, Object> root = new HashMap<>();
			root.put("request", request);
			root.put("basePath", RequestUtil.getBasePath(request));
			root.put("adminPath", RequestUtil.getBasePath(request)+"/admin");
			
			resolver.setViewClass(FreemarkerView.class);
			Map<String, TemplateModel> beans = (Map<String, TemplateModel>) context.getBeansOfType(TemplateModel.class);
			for (Entry<String, TemplateModel> entry : beans.entrySet()) {
				root.put(entry.getKey(), entry.getValue());
			}
			
			File templatePath = ResourceUtils.getFile("classpath:templates");
			String rootPath = request.getServletContext().getRealPath("/");
			String filename = "newindex.html";
			Configuration configuration = freeMarkerConfigurer.getConfiguration();
			// 得到模板
			// 如果你分父目录不存在，递归创建
			File parentPath = new File(rootPath);
			if (!parentPath.exists())
				parentPath.mkdirs();
			// 组合最终的文件路径
			File targetFile = new File(parentPath, filename);
			//不需要设定模板的路径了，因为springboot会自动去装配模板路径了
			configuration.setDirectoryForTemplateLoading(templatePath);
			configuration.setObjectWrapper(new DefaultObjectWrapper(Configuration.VERSION_2_3_28));
			// 读取模板
			Template template = configuration.getTemplate("index.html","UTF-8");
			try {
				// 将数据和模板中要动态替换的内容进行融合渲染，返回渲染以后的网页内容
				String text = FreeMarkerTemplateUtils.processTemplateIntoString(template, root);
				FileUtils.write(targetFile, text, "UTF-8");
				return filename;
			} catch (TemplateException e) {
				e.printStackTrace();
				return null;
			}
		} catch (IOException e) {
			e.printStackTrace();
			return null;
		}
	}

	*//**
		 * 静态化首页方法
		 * 
		 * @param data
		 * @return
		 *//*
	public String staticPage(Object data, String templateName, String targetPath, String filename) {
		// 设置附件
		// 封装模板使用的数据
		Map<String, Object> root = new HashMap<>();
		root.put("data", data);
		// 得到模板
		try {
			// 如果你分父目录不存在，递归创建
			File parentPath = new File(targetPath);
			if (!parentPath.exists())
				parentPath.mkdirs();
			// 组合最终的文件路径
			File targetFile = new File(parentPath, filename);
			// 读取模板
			Template template = freeMarkerConfigurer.getConfiguration().getTemplate(templateName);
			try {
				// 将数据和模板中要动态替换的内容进行融合渲染，返回渲染以后的网页内容
				String text = FreeMarkerTemplateUtils.processTemplateIntoString(template, root);
				FileUtils.write(targetFile, text, "UTF-8");
				return "index.html";
			} catch (TemplateException e) {
				e.printStackTrace();
				return null;
			}
		} catch (IOException e) {
			e.printStackTrace();
			return null;
		}
	}

	@Override
	public void setApplicationContext(ApplicationContext context) throws BeansException {
		this.context = context;
	}
}
*/