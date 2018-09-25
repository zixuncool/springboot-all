//package com.rumo.util;
//
//import org.apache.commons.lang3.StringUtils;
//import org.apache.commons.mail.EmailException;
//import org.apache.commons.mail.HtmlEmail;
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
//
//import com.rumo.vo.Mail;
//
//public class MailUtil {
//	
//	
//	private static Logger log = LoggerFactory.getLogger(MailUtil.class);
//
//    public static boolean send(Mail mail) {
//        String from = "";
//        int port = 25;
//        String host = "";
//        String pass = "";
//        String nickname = "";
//
//        HtmlEmail email = new HtmlEmail();
//        try {
//            email.setHostName(host);
//            email.setCharset("UTF-8");
//            for (String str : mail.getReceivers()) {
//                email.addTo(str);
//            }
//            email.setFrom(from, nickname);
//            email.setSmtpPort(port);
//            email.setAuthentication(from, pass);
//            email.setSubject(mail.getSubject());
//            email.setMsg(mail.getMessage());
//            email.send();
//            log.info("{} 发送邮件到 {}", from, StringUtils.join(mail.getReceivers(), ","));
//            return true;
//        } catch (EmailException e) {
//            log.error(from + "发送邮件到" + StringUtils.join(mail.getReceivers(), ",") + "失败", e);
//            return false;
//        }
//    }
//
//}