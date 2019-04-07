package com.saurabh.auth.apigateway.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Entity
@Table(name = "users", uniqueConstraints = { @UniqueConstraint(columnNames = { "username" }),
		@UniqueConstraint(columnNames = { "email" }) })
public class User {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@NotBlank
	private Long id;

	@NotBlank
	@Size(max = 100)
	private String name;

	@NotBlank
	@Size(max = 100)
	private String username;

	@NotBlank
	@Size(max = 100)
	private String email;

	@NotBlank
	@Size(max = 100)
	private String password;

	@NotBlank
	@Size(max = 100)
	private String roleName;
	
	//private Set<String> roles;

	public User() {
	}

	public User(@NotBlank @Size(max = 100) String name, @NotBlank @Size(max = 100) String username,
			@NotBlank @Size(max = 100) String email, @NotBlank @Size(max = 100) String password,
			@NotBlank @Size(max = 100) @NotBlank @Size(max = 100) String roleName) {
		this.name = name;
		this.username = username;
		this.email = email;
		this.password = password;
		this.roleName = roleName;
	}
	
	/*public User(@NotBlank @Size(max = 100) String name, @NotBlank @Size(max = 100) String username,
			@NotBlank @Size(max = 100) String email, @NotBlank @Size(max = 100) String password,
			@NotBlank @Size(max = 100) @NotBlank @Size(max = 100) Set<String> role) {
		this.name = name;
		this.username = username;
		this.email = email;
		this.password = password;
		this.roles = role;
	}*/

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getRoleName() {
		return roleName;
	}

	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}

	/*
	 * public Set<String> getRoles() { return roles; }
	 * 
	 * public void setRoleName(Set<String> roleName) { this.roles = roleName; }
	 */
	
	
}
