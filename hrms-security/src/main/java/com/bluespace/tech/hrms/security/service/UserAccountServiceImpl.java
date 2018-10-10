package com.bluespace.tech.hrms.security.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.bluespace.tech.hrms.security.domain.BaseResponse;
import com.bluespace.tech.hrms.security.domain.TokenVerification;
import com.bluespace.tech.hrms.security.domain.UserAccount;
import com.bluespace.tech.hrms.security.repositories.TokenVerificationRepository;
import com.bluespace.tech.hrms.security.repositories.UserAccountRepository;

@Service
//@Transactional
public class UserAccountServiceImpl implements UserAccountService {

	//@Autowired
	private UserAccountRepository userAccountRepository;

	@Autowired
	private PasswordEncoder passwordEncoder;

	//@Autowired
	private TokenVerificationRepository tokenRepository;

	@Transactional
	public UserAccount findUserAccountByUserName(String userName) {
		return this.userAccountRepository.findUserAccountByUserName(userName);
	}

	@Override
	public UserAccount save(UserAccount userAccount) {
		BaseResponse response = null;
		UserAccount user = (UserAccount) this.userAccountRepository.save(userAccount);
		if (user != null) {
			response = new BaseResponse();
			response.setResponseCode(200L);
			response.setResponseMessage("User " + user.getCreatedUser() + " created/updated successfully");
		}
		return this.userAccountRepository.findUserAccountByUserName(user.getUserName());
	}

	@Override
	public UserAccount getUser(String userName) {
		return this.userAccountRepository.findUserAccountByUserName(userName);
	}

	@Override
	public void createTokenVerification(UserAccount user, String token) {
		TokenVerification myToken = new TokenVerification(token, user);
		this.tokenRepository.save(myToken);
	}

	@Override
	public TokenVerification getTokenVerification(String TokenVerification) {
		return this.tokenRepository.findByToken(TokenVerification);
	}

	@Override
	public String getEncodedPassword(String rawPassword) {
		return this.passwordEncoder.encode(rawPassword);
	}

}
