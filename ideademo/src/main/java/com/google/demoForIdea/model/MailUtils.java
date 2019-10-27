package com.google.demoForIdea.model;

import com.sun.mail.util.MailSSLSocketFactory;

import java.util.Date;
import java.util.Properties;
import javax.mail.Message;
import javax.mail.Session;
import javax.mail.MessagingException;
import javax.mail.Authenticator;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.mail.PasswordAuthentication;

public class MailUtils {
	// 发件人 账号和密码
	public static final String MY_EMAIL_ACCOUNT = "812568779@qq.com";
	public static final String MY_EMAIL_PASSWORD = "dsryzqtgagjmbbce";// 密码,是你自己的设置的授权码

	// SMTP服务器(这里用的qq SMTP服务器)
	public static final String MEAIL_qq_SMTP_HOST = "smtp.qq.com";
	public static final String SMTP_qq_PORT = "465";// 端口号,这个是163使用到的;QQ的应该是465或者875


	public static final  String email(String RECEIVE_EMAIL_ACCOUNT) throws AddressException, MessagingException {
		Properties p = new Properties();

		p.setProperty("mail.smtp.host", MEAIL_qq_SMTP_HOST);
		p.setProperty("mail.smtp.port", SMTP_qq_PORT);
		p.setProperty("mail.smtp.socketFactory.port", SMTP_qq_PORT);
		p.setProperty("mail.smtp.auth", "true");
		p.setProperty("mail.smtp.socketFactory.class", "SSL_FACTORY");
		p.setProperty("mail.smtp.ssl.enable","true");

		Session session = Session.getInstance(p, new Authenticator() {
			// 设置认证账户信息
			@Override
			protected PasswordAuthentication getPasswordAuthentication() {
				return new PasswordAuthentication(MY_EMAIL_ACCOUNT, MY_EMAIL_PASSWORD);
			}
		});
		session.setDebug(true);
		MimeMessage message = new MimeMessage(session);
		// 发件人
		message.setFrom(new InternetAddress(MY_EMAIL_ACCOUNT));
		// 收件人和抄送人
		message.setRecipients(Message.RecipientType.TO, RECEIVE_EMAIL_ACCOUNT);
		message.setSubject("验证码");

		String  emailcode = (int)((Math.random() * 9 + 1) * 100000)+"";
		message.setContent("<h1>欢迎注册汤彪的新用户，老板您的验证码是:"+emailcode+"</h1>", "text/html;charset=UTF-8");
		message.setSentDate(new Date());
		message.saveChanges();


		Transport.send(message);
		return emailcode;
	}

		public static void main(String[] args)  throws AddressException, MessagingException {
			MailUtils.email("374212560@qq.com");
		}
}
