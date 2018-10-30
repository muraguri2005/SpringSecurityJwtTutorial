package org.freelesson.SpringSecurityJwtTutorial.service;

import org.freelesson.SpringSecurityJwtTutorial.domain.User;

public interface UserService {
	User findByUsername(String username)  throws Exception;

}
