package com.rumo.service;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.mail.internet.MimeMessage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.FileSystemResource;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;
import org.springframework.ui.freemarker.FreeMarkerTemplateUtils;
import org.springframework.web.servlet.view.freemarker.FreeMarkerConfigurer;

import com.rumo.config.EmailConfig;

import freemarker.template.Template;
import freemarker.template.TemplateException;

/*import freemarker.template.Template;
import freemarker.template.TemplateException;*/

@Service
public class EmailServiceImpl implements EmailService {

	
	@Autowired
	private EmailConfig emailConfig;
	
	@Autowired
	private JavaMailSender mailSender;

	@Autowired
	private FreeMarkerConfigurer freeMarkerConfigurer;
	
	public void sendEmail(String email,String title,String content) {
		//简单邮件发送
		SimpleMailMessage message = new SimpleMailMessage();
		//发送者
		message.setFrom(emailConfig.getEmailFrom());
		//邮件接受者
		message.setTo(email);
		//发送主题
		message.setSubject(title);
		//发送的的内容
		message.setText(content);
		//发送邮件
		mailSender.send(message);
	}

	@Override
	public void sendAttachmentEmail(String email, String title, String content, File file) {
		try {
			MimeMessage message = mailSender.createMimeMessage();
			MimeMessageHelper messageHelper = new MimeMessageHelper(message,true);
			messageHelper.setFrom(emailConfig.getEmailFrom());
			messageHelper.setTo(email);
			messageHelper.setSubject(title);
			messageHelper.setText(content);
			//设置附件
			FileSystemResource resource = new FileSystemResource(file);
			messageHelper.addAttachment("附件", resource);
			mailSender.send(message);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
	}
	

	@Override
	public void sendTemplateEmail(String email, String title, String templateName) {
		try {
			MimeMessage message = mailSender.createMimeMessage();
			MimeMessageHelper messageHelper = new MimeMessageHelper(message,true);
			messageHelper.setFrom(emailConfig.getEmailFrom());
			messageHelper.setTo(email);
			messageHelper.setSubject(title);
			
			//设置附件
			//封装模板使用的数据
			Map<String, Object> root = new HashMap<>();
			root.put("email", email);
			root.put("code", "123456");
			
			//List contents = null;
			//root.put("contents", contents);
			//在模板中用<#list contents as content>${content.title}</#list>
			
			//得到模板
			 try {
				 //读取模板
                Template template = freeMarkerConfigurer.getConfiguration().getTemplate(templateName);
                try {
                	//将数据和模板中要动态替换的内容进行融合渲染，返回渲染以后的网页内容
                    String text = FreeMarkerTemplateUtils.processTemplateIntoString(template, root);
                    //写静态页面到服务器
                    //修改数据量，静态字段
                    messageHelper.setText(text, true);
                    mailSender.send(message);
                } catch (TemplateException e) {
                    e.printStackTrace();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
			 
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}