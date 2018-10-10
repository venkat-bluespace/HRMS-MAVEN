package com.bluespace.tech.hrms.security.service;

import com.bluespace.tech.hrms.security.domain.TokenVerification;
import com.bluespace.tech.hrms.security.domain.UserAccount;

public interface UserAccountService {

	public abstract UserAccount findUserAccountByUserName(String paramString);

	public abstract UserAccount save(UserAccount paramUserAccount);

	public abstract UserAccount getUser(String paramString);

	public abstract void createTokenVerification(UserAccount paramUserAccount, String paramString);

	public abstract TokenVerification getTokenVerification(String paramString);

	public abstract String getEncodedPassword(String paramString);

}