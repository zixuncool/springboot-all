package com.rumo.service;

import java.io.File;

public interface EmailService {

	//简单邮件发送
	/**
	 * 
	 * @param email 接受者
	 * @param title 发送标题
	 * @param content 发送内容
	 */
	public void sendEmail(String email,String title,String content);
	
	//带附件的邮件发送
	public void sendAttachmentEmail(String email,String title,String content,File file);
	
	//带附件的邮件发送
	public void sendTemplateEmail(String email,String title,String templateName);
}