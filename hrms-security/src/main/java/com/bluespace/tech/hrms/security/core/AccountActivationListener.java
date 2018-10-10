package com.bluespace.tech.hrms.security.core;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

import com.bluespace.tech.hrms.security.domain.AccountCreationEmail;
import com.bluespace.tech.hrms.security.domain.UserAccount;
import com.bluespace.tech.hrms.security.service.UserAccountService;
import com.bluespace.tech.hrms.security.util.EmailHandler;

@Component
public class AccountActivationListener implements ApplicationListener<OnRegistrationCompletionEvent> {

	//@Autowired
	private UserAccountService service;
	@Autowired
	private EmailHandler emailHandler;
	private static final Logger logger = LogManager.getLogger(AccountActivationListener.class);

	@Override
	public void onApplicationEvent(OnRegistrationCompletionEvent event) {
		confirmRegistration(event);
	}

	public void confirmRegistration(OnRegistrationCompletionEvent event) {

		UserAccount userAccount = event.getUserAccount();
		logger.debug("Listening to the publish token event...");

		String recipientAddress = userAccount.getEmail();
		String subject = "HRMS User Registration | Account Created";

		AccountCreationEmail mail = new AccountCreationEmail();
		mail.setMailTo(recipientAddress);
		mail.setMailFrom("no-reply@hrms.com");
		mail.setMailSubject(subject);
		if (!event.isAccountCreatedByAdmin()) {
			logger.info("Internal Account creation by Admin. Skipping token creation and verification link");
			String token = UUID.randomUUID().toString();
			this.service.createTokenVerification(userAccount, token);
			String confirmationUrl = event.getAppUrl() + "/new/regitrationConfirm?token=" + token;
			mail.setVerificationUrl(confirmationUrl);
			mail.setUnsubscribeUrl(event.getAppUrl() + "/unsubscribe?email=" + recipientAddress);
		}
		Map<String, Object> model = new HashMap<>();
		model.put("userName", userAccount.getUserName());
		model.put("signature", "www.bluespacemail.com");
		mail.setModel(model);
		try {
			if (event.isAccountCreatedByAdmin()) {
				this.emailHandler.sendAccountCreationEmail(mail, event.getUserAccount().getUserName(),
						event.getUserAccount().getPassword());
			} else if ("APPROVE".equalsIgnoreCase(event.getRequestType())) {
				this.emailHandler.sendVerificationEmail(mail);
			} else if ("HOLD".equalsIgnoreCase(event.getRequestType())) {
				this.emailHandler.sendAccountCreationOnHoldEmail(mail, event.getUserAccount().getUserName(),
						event.getUserAccount().getPassword());
			} else if ("REJECT".equalsIgnoreCase(event.getRequestType())) {
				this.emailHandler.sendAccountCreationRejectedEmail(mail, event.getUserAccount().getUserName(),
						event.getUserAccount().getPassword());
			}
		} catch (IOException e) {
			String message = "Failed to send verification/account creation email";
			logger.error(message + ", reason: " + e.getMessage());
			throw new RuntimeException(message);
		}

	}
}
