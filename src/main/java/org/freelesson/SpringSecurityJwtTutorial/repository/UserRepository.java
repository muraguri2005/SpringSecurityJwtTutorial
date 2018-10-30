package org.freelesson.SpringSecurityJwtTutorial.repository;

import java.util.Optional;
import java.util.UUID;

import org.freelesson.SpringSecurityJwtTutorial.domain.User;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<User, UUID>{
	Optional<User> findByUsername(String username);

}
