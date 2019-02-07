package com.cts.signup.rest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.cts.signup.bean.AuthenticationStatus;
import com.cts.signup.bean.User;
import com.cts.signup.service.LoginService;

@RestController
public class LoginRestController extends ExceptionController {
	private static final Logger LOGGER = LoggerFactory.getLogger(LoginRestController.class);
	private LoginService loginService;

	@Autowired
	public void setLoginService(LoginService loginService) {
		this.loginService = loginService;
	}

	@PostMapping("/authenticate")
	private AuthenticationStatus authenticate(@RequestBody User user) {
		LOGGER.info("Start");
		LOGGER.debug("User :{}", user);
		AuthenticationStatus status = new AuthenticationStatus();
		status.setAuthenticated(false);
		status.setAdmin(false);
		LOGGER.debug("status :{}", status);
		String email = user.getEmail();
		String password = user.getPassword();
		User actualUser = loginService.getUserByEmail(email);
		LOGGER.debug("actualUser :{}", actualUser);
		if (actualUser != null) {
			String actualPassword = actualUser.getPassword();
	
			LOGGER.debug("actualPassword :{}", actualPassword);
			if (email.equals("admin") && password.equals(actualPassword)) {	
			status.setUser(actualUser);
				status.setAdmin(true);
				status.setAuthenticated(true);
			} else {
				status.setUser(actualUser);
				String actualEmail = user.getEmail();
				status.setAuthenticated(email.equals(actualEmail));
				status.setAuthenticated(password.equals(actualPassword));
			}

		}

		LOGGER.info("End");

		return status;

	}
}
