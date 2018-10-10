package com.bluespace.tech.hrms.security.domain;

import java.util.List;
import java.util.Map;

import lombok.Data;

@Data
public class AccountCreationEmail {

	private String mailFrom;
	private String mailTo;
	private String mailCc;
	private String mailBcc;
	private String mailSubject;
	private String mailContent;
	private String contentType;
	private String verificationUrl;
	private String unsubscribeUrl;
	private List<Object> attachments;
	private Map<String, Object> model;

}
