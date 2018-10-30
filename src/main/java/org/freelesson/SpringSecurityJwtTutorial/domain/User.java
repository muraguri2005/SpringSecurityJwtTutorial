package org.freelesson.SpringSecurityJwtTutorial.domain;



import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Type;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name="users")
public class User {
	@Id
	@GeneratedValue(generator="uuid")
	@GenericGenerator(name="uuid",strategy="uuid2")
	@Column(unique=true,nullable=false)
	@Type(type="uuid-char")
	public UUID id;
	
	@Column(unique=true,nullable=false)
	public String username;
	@Column(nullable=false)
	@JsonIgnore
	public String password;
	
	@ManyToMany
	@JoinTable(name="user_role", joinColumns= @JoinColumn(name="user_id", referencedColumnName="id"), inverseJoinColumns=@JoinColumn(name="role_id", referencedColumnName="id"))
	@JsonIgnore
	public Set<Role> roles=new HashSet<>();
	
	User(){
		
	}
	
	public User(String username, String password) {
		this.username = username;
		this.password = password;
	}
}
