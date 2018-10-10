package com.bluespace.tech.hrms.security.controller;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.bluespace.tech.hrms.security.domain.Credentials;

@RestController
public class LoginController extends AbstractBaseController {

	private static Logger logger = LogManager.getLogger(LoginController.class);

	@PostMapping(value = { "/authenticate" }, consumes = { "application/json" })
	public void login(@RequestBody Credentials credentials) {
		logger.info("Inside LoginController class to authenticate.");
	}
}
