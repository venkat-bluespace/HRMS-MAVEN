package com.bluespace.tech.hrms.security.core;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.SimpleUrlAuthenticationSuccessHandler;
import org.springframework.stereotype.Component;

@Component
public class AuthenticationSuccess extends SimpleUrlAuthenticationSuccessHandler {

	  private static final Logger LOGGER = LogManager.getLogger(AuthenticationSuccess.class);
	  
	  public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response, Authentication authentication)
	    throws IOException, ServletException
	  {
	    LOGGER.info("Authentication Successful");
	    response.setStatus(200);
	  }
}
