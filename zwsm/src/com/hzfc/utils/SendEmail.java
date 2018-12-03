package com.hzfc.utils;

import java.util.Date;
import java.util.Properties;

import javax.activation.DataHandler;
import javax.activation.FileDataSource;
import javax.mail.Authenticator;
import javax.mail.BodyPart;
import javax.mail.Message;
import javax.mail.Multipart;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;


public class SendEmail {
	
	private String to; //收件人邮箱
	
	private String subject; //邮件标题
	
	private String content; //邮件内容
	
	private String filename; //附件文件名
	
	//无参数构造方法
	public SendEmail() {}

	public String getTo() {
		return to;
	}

	public void setTo(String to) {
		this.to = to;
	}

	public String getSubject() {
		return subject;
	}

	public void setSubject(String subject) {
		this.subject = subject;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getFilename() {
		return filename;
	}

	public void setFilename(String filename) {
		//将文件路径中的'\'替换成'/'
		filename = filename.replaceAll("\\\\","/");
		this.filename = filename;
	}
	
	//发送text类型email
	public boolean sendText() {
		//创建一个属性对象
		Properties props = new Properties();
		//指定SMTP服务器
		props.put("mail.smtp.host", MailConfig.SMTPHOST);
		//指定是否需要SMTP验证		
		props.put("mail.smtp.auth", "true");
		try{
			//创建一个授权验证对象
			SmtpAuth auth = new SmtpAuth();
			auth.setAccount(MailConfig.EMAIL_USERNAME,MailConfig.EMAIL_PASSWORD);
			
			//创建一个Session对象
			Session mailSession = Session.getDefaultInstance(props,auth);
			mailSession.setDebug(true);
			
			//创建一个Message对象
			Message message=new MimeMessage(mailSession);

			//指定发件人邮箱
			message.setFrom(new InternetAddress(MailConfig.EMAIL_FROM));
			//指定收件人邮箱
			message.addRecipient(Message.RecipientType.TO,new InternetAddress(to));
			//指定邮件主题
			message.setSubject(subject);
			//指定邮件内容
			message.setText(content);
			//指定邮件发送日期
			message.setSentDate(new Date());
			//指定邮件优先级 1：紧急 3：普通 5：缓慢
			message.setHeader("X-Priority",MailConfig.SENDTEXT_HEADER);
			message.saveChanges();
						
			//创建一个Transport对象
			Transport transport = mailSession.getTransport("smtp");
			//连接SMTP服务器
			transport.connect(MailConfig.SMTPHOST, MailConfig.EMAIL_USERNAME, MailConfig.EMAIL_PASSWORD);
			//发送邮件
			transport.sendMessage(message, message.getAllRecipients());
			transport.close();
			return true;
		}catch(Exception ex){
			ex.printStackTrace();
			return false;
		}
	}
	
	//发送Html类型email
	public boolean sendHtml(){
		//创建一个属性对象
		Properties props = new Properties();
		//指定SMTP服务器
		props.put("mail.smtp.host", MailConfig.SMTPHOST);
		//指定是否需要SMTP验证		
		props.put("mail.smtp.auth", "true");
		try{
			//创建一个授权验证对象
			SmtpAuth auth = new SmtpAuth();
			auth.setAccount(MailConfig.EMAIL_USERNAME, MailConfig.EMAIL_PASSWORD);
			
			//创建一个Session对象
			Session mailSession = Session.getDefaultInstance(props,auth);
			mailSession.setDebug(true);
			
			//创建一个MimeMessage 对象
			MimeMessage message=new MimeMessage(mailSession);

			//指定发件人邮箱
			message.setFrom(new InternetAddress(MailConfig.EMAIL_FROM));
			//指定收件人邮箱
			message.addRecipient(Message.RecipientType.TO,new InternetAddress(to));
			//指定邮件主题
			message.setSubject(subject);
			//指定邮件内容、ContentType及编码方式
			message.setContent(content,"text/html;charset=gb2312");
			//指定邮件发送日期
			message.setSentDate(new Date());
			//指定邮件优先级 1：紧急 3：普通 5：缓慢
			message.setHeader("X-Priority", MailConfig.SENDHTML_HEADER);
			message.saveChanges();
			
			//创建一个Transport对象
			Transport transport = mailSession.getTransport("smtp");
			//连接SMTP服务器
			transport.connect(MailConfig.SMTPHOST, MailConfig.EMAIL_USERNAME, MailConfig.EMAIL_PASSWORD);
			//发送邮件
			transport.sendMessage(message, message.getAllRecipients());
			transport.close();
			return true;
		}catch(Exception ex){
			ex.printStackTrace();
			return false;
		}
	}
	
	//发送邮件 带附件，预留接口
	public boolean sendAttach(){
		//创建一个属性对象
		Properties props = new Properties();
		//指定SMTP服务器
		props.put("mail.smtp.host", MailConfig.SMTPHOST);
		//指定是否需要SMTP验证		
		props.put("mail.smtp.auth", "true");
		try{
			//创建一个授权验证对象
			SmtpAuth auth = new SmtpAuth();
			auth.setAccount(MailConfig.EMAIL_USERNAME, MailConfig.EMAIL_PASSWORD);
			
			//创建一个Session对象
			Session mailSession = Session.getDefaultInstance(props,auth);
			mailSession.setDebug(true);
			
			//创建一个MimeMessage 对象
			MimeMessage message=new MimeMessage(mailSession);

			//指定发件人邮箱
			message.setFrom(new InternetAddress(MailConfig.EMAIL_FROM));
			//指定收件人邮箱
			message.addRecipient(Message.RecipientType.TO,new InternetAddress(to));
			//指定邮件主题
			message.setSubject(subject);
			//指定邮件发送日期
			message.setSentDate(new Date());
			//指定邮件优先级 1：紧急 3：普通 5：缓慢
			message.setHeader("X-Priority", MailConfig.SENDATTACH_HEADER);
			message.saveChanges();
			
			//新建一个MimeMultipart对象用来存放多个BodyPart对象
			Multipart container=new MimeMultipart();
			//新建一个存放信件内容的BodyPart对象
			BodyPart textBodyPart=new MimeBodyPart();
			//给BodyPart对象设置内容和格式/编码方式
			textBodyPart.setContent(content,"text/html;charset=gb2312");
			//将含有信件内容的BodyPart加入到MimeMultipart对象中
			container.addBodyPart(textBodyPart);
			
			//新建一个存放信件附件的BodyPart对象
			BodyPart fileBodyPart=new MimeBodyPart();
			//将本地文件作为附件
			FileDataSource fds=new FileDataSource(filename);
			fileBodyPart.setDataHandler(new DataHandler(fds));
			//处理邮件中附件文件名的中文问题
			String attachName = fds.getName();
			attachName = new String(attachName.getBytes("gb2312"),"ISO8859-1");
			//设定附件文件名
			fileBodyPart.setFileName(attachName);
			//将附件的BodyPart对象加入到container中
			container.addBodyPart(fileBodyPart);
			
			//将container作为消息对象的内容
			message.setContent(container);
			
			//创建一个Transport对象
			Transport transport = mailSession.getTransport("smtp");
			//连接SMTP服务器
			transport.connect(MailConfig.SMTPHOST, MailConfig.EMAIL_USERNAME, MailConfig.EMAIL_PASSWORD);
			//发送邮件
			transport.send(message, message.getAllRecipients());
			transport.close();
			return true;
		}catch(Exception ex){
			ex.printStackTrace();
			return false;
		}
	}
	
	//定义一个SMTP授权验证类
	static class SmtpAuth extends Authenticator{
		String user,password;
		//设置帐号信息
		void setAccount(String user,String password){
			this.user = user;
			this.password = password;
		}
		//取得PasswordAuthentication对象
		protected PasswordAuthentication getPasswordAuthentication(){
			return new PasswordAuthentication(user,password);
		}
	}
}
