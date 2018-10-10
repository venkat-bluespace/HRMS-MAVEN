package com.bluespace.tech.hrms.security.core;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.SimpleUrlAuthenticationFailureHandler;
import org.springframework.stereotype.Component;

@Component
public class AuthenticationFailure extends SimpleUrlAuthenticationFailureHandler {
	private static final Logger LOGGER = LogManager.getLogger(AuthenticationFailure.class);

	public void onAuthenticationFailure(HttpServletRequest request, HttpServletResponse response,
			AuthenticationException exception) throws IOException, ServletException {
		response.setStatus(401);
		LOGGER.error("Authentication failed : " + exception.getMessage());
		response.getOutputStream().println("{ \"error\": \"" + exception.getMessage() + "\" }");
	}
}
