package com.backend.projeto.entity;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;

import lombok.Getter;
import lombok.Setter;

@Entity
@Setter
@Getter
public class User {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	private String name;
	
	@Column(unique=true)
	private String email;
	
	private String password;
	
	@ManyToMany(fetch=FetchType.EAGER)
	@JoinTable(name = "user_role",
		joinColumns = @JoinColumn(name="user_id"),
		inverseJoinColumns = @JoinColumn(name="role_id"))
	private List<Role> roles;
	
	public User() {}
	
	public User(String name, String email, String password, List<Role> roles) {
		this.name = name;
		this.email = email;
		this.password = password;
		this.roles = roles;
	}

	public User(User user) {
		super();
		this.name = user.getName();
		this.email = user.getEmail();
		this.password = user.getPassword();
		this.roles = user.getRoles();
	}
	
	
	
	
}
