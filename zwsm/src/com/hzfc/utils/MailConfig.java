package com.hzfc.utils;


public class MailConfig {
	
	//SMTP服务器
	public final static String SMTPHOST = Resources.getString("email.smtphost");
	
	//登录SMTP服务器的帐号
	public final static String EMAIL_USERNAME = Resources.getString("email.username");
	
	//登录SMTP服务器的密码
	public final static String EMAIL_PASSWORD = Resources.getString("email.password");
	
	//发件人邮箱
	public final static String EMAIL_FROM = Resources.getString("email.from");
	
	//系统主访问域名地址
	public final static String WEB_DOMAIN_NAME = Resources.getString("doMainUrl");
	
	//指定邮件优先级 1：紧急 3：普通 5：缓慢	
	public final static String SENDTEXT_HEADER = "3";		//发送text类型邮件有限级
	
	public final static String SENDHTML_HEADER = "3";		//发送html类型邮件有限级
	
	public final static String SENDATTACH_HEADER = "3";		//发送带附件类型邮件有限级

}
