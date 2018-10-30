package org.freelesson.SpringSecurityJwtTutorial;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

import org.freelesson.SpringSecurityJwtTutorial.domain.Role;
import org.freelesson.SpringSecurityJwtTutorial.domain.User;
import org.freelesson.SpringSecurityJwtTutorial.repository.RoleRepository;
import org.freelesson.SpringSecurityJwtTutorial.repository.UserRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@SpringBootApplication
public class SpringSecurityJwtTutorialApplication {
	
	

	public static void main(String[] args) {
		SpringApplication.run(SpringSecurityJwtTutorialApplication.class, args);
	}
	
	@Bean
	CommandLineRunner init(UserRepository userRepository, RoleRepository roleRepository) {
		return (evt) -> {
			createAdminAccount(userRepository,roleRepository);
		};
	}
	
	public void createAdminAccount(UserRepository userRepository, RoleRepository roleRepository) {
		Optional<User> accountOptional = userRepository.findByUsername("admin@freelessons.org");
		if (!accountOptional.isPresent()) {
			BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();
			User user = new User("admin@freelessons.org", bCryptPasswordEncoder.encode("Tutori@lL"));
			Set<Role> roles = new HashSet<>();
			roles.add(getRole(roleRepository,Role.ROLE_ADMIN));
			roles.add(getRole(roleRepository,Role.ROLE_USER));
			user.roles = roles;
			userRepository.save(user);
		}
	}
	
	private Role getRole(RoleRepository roleRepository, String name) {
		Optional<Role> roleOptional = roleRepository.findByName(name);
		return roleOptional.orElseGet(() -> roleRepository.save(new Role(name)));
	}
}
