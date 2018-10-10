package com.bluespace.tech.hrms.security.core;

import java.util.Locale;

import org.springframework.context.ApplicationEvent;

import com.bluespace.tech.hrms.security.domain.UserAccount;

import lombok.Getter;

public class OnRegistrationCompletionEvent extends ApplicationEvent {

	private static final long serialVersionUID = 5900123102307475805L;

	  @Getter private String appUrl;
	  @Getter private Locale locale;
	  @Getter private UserAccount userAccount;
	  @Getter private boolean isAccountCreatedByAdmin;
	  @Getter private String requestType;
	  
	public OnRegistrationCompletionEvent(UserAccount userAccount, Locale locale, String appUrl,
			boolean isAccountCreatedByAdmin, String requestType) {
		super(userAccount);

		this.userAccount = userAccount;
		this.locale = locale;
		this.appUrl = appUrl;
		this.isAccountCreatedByAdmin = isAccountCreatedByAdmin;
		this.requestType = requestType;

	}

	public String toString() {
		return "OnRegistrationCompleteEvent [appUrl=" + this.appUrl + ", locale=" + this.locale + ", user="
				+ this.userAccount + ", isAccountCreatedByAdmin=" + this.isAccountCreatedByAdmin + "]";
	}
}
