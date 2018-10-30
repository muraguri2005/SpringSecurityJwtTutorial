package org.freelesson.SpringSecurityJwtTutorial.repository;

import java.util.Optional;
import java.util.UUID;

import org.freelesson.SpringSecurityJwtTutorial.domain.Role;
import org.springframework.data.repository.CrudRepository;

public interface RoleRepository extends CrudRepository<Role, UUID>{
	Optional<Role> findByName(String name);

}
