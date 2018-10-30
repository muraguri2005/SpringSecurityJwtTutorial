package org.freelesson.SpringSecurityJwtTutorial.domain;

import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Type;


@Entity
@Table(name="role")
public class Role {
	
	@Id
	@GeneratedValue(generator="uuid")
	@GenericGenerator(name="uuid",strategy="uuid2")
	@Column(unique=true, nullable=false)
	@Type(type="uuid-char")
	public UUID id;
	@Column(unique=true, nullable=false)
	public String name;
	
	public static final String ROLE_USER = "ROLE_USER";
	public static final String ROLE_ADMIN = "ROLE_ADMIN";
	
	Role() {
		
	}
	
	public Role(String name) {
		this.name = name;
	}

}
