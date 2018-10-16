package com.bluespace.tech.hrms.security.util;

import java.util.Properties;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.JavaMailSenderImpl;

@Configuration
@PropertySource("file:src/main/resources/mail.properties")
public class MailConfiguration {
	@Value("${mail.config.protocol}")
	private String mailProtocol;
	@Value("${mail.config.host}")
	private String mailHost;
	@Value("${mail.config.port}")
	private int mailPort;
	@Value("${mail.config.smtp.auth}")
	private boolean auth;
	@Value("${mail.config.smtp.starttls.enable}")
	private boolean starttls;
	@Value("${mail.config.username}")
	private String mailUsername;
	@Value("${mail.config.password}")
	private String mailPassword;
	@Value("${mail.smtp.ssl.trust}")
	private String sslTrust;
	@Value("${mail.debug}")
	private String mailDebug;
	@Value("${mail.bounce.to}")
	private String bounceAddress;
	private static final Logger logger = LoggerFactory.getLogger(MailConfiguration.class);

	@Bean(name = { "javaMailSender" })
	public JavaMailSender javaMailSender() {
		final JavaMailSenderImpl mailSender = new JavaMailSenderImpl();

		Properties mailProperties = new Properties();
		mailProperties.put("mail.smtp.auth", Boolean.valueOf(this.auth));
		mailProperties.put("mail.smtp.starttls.enable", Boolean.valueOf(this.starttls));
		mailProperties.put("mail.smtp.ssl.trust", this.sslTrust);
		mailProperties.put("mail.smtp.from", this.bounceAddress);
		mailProperties.put("mail.debug", this.mailDebug);

		mailSender.setJavaMailProperties(mailProperties);
		mailSender.setHost(this.mailHost);
		mailSender.setPort(this.mailPort);
		mailSender.setProtocol(this.mailProtocol);

		mailSender.setUsername(this.mailUsername);
		mailSender.setPassword(this.mailPassword);

		logger.info("Email Configuration : " + mailSender.getJavaMailProperties());
		return mailSender;
	}
}
