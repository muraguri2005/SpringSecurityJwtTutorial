package org.freelesson.SpringSecurityJwtTutorial.controller;

import org.freelesson.SpringSecurityJwtTutorial.domain.User;
import org.freelesson.SpringSecurityJwtTutorial.service.UserService;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path="/account")
public class AccountController {
	
	final UserService userService;

	public AccountController(UserService userService) {
		this.userService = userService;
	}
	@GetMapping
	User getAccountDetails(Authentication authentication) throws Exception {
		return userService.findByUsername(authentication.getName());
	}

}
