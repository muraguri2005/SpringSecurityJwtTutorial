package org.freelesson.SpringSecurityJwtTutorial.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import javax.transaction.Transactional;

import org.freelesson.SpringSecurityJwtTutorial.domain.Role;
import org.freelesson.SpringSecurityJwtTutorial.repository.UserRepository;
import org.freelesson.SpringSecurityJwtTutorial.service.UserService;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserDetailsService, UserService {
	final UserRepository userRepository;
	public UserServiceImpl(UserRepository userRepository) {
		this.userRepository = userRepository;
	}

	@Transactional
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		org.freelesson.SpringSecurityJwtTutorial.domain.User user = userRepository.findByUsername(username).orElseThrow(() -> new UsernameNotFoundException("Wrong username or password"));
		return new User(username,user.password,getAuthorities(user.roles));
	}
	
	List<SimpleGrantedAuthority> getAuthorities(Set<Role> roles) {
		List<SimpleGrantedAuthority> authorities = new ArrayList<>();
		roles.forEach(role -> authorities.add(new SimpleGrantedAuthority(role.name)));
		return authorities;
	}
	
	@Override
	public org.freelesson.SpringSecurityJwtTutorial.domain.User findByUsername(String username) {
		return userRepository.findByUsername(username).orElseThrow(() -> new UsernameNotFoundException("User not found "));
	}
	
}
