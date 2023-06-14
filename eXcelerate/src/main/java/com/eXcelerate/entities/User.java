package com.eXcelerate.entities;

import javax.persistence.Id;
import javax.persistence.MappedSuperclass;

/**
 * User mappedSuperclass is created in order to situate is-a relationship for
 * user , student & instructor
 */
@MappedSuperclass
public class User {
	@Id
	private String username;
	private String password;
	private String name;
	private Boolean isDeleted;

	public User() {
		super();
	}

	public User(String username, String password, String name, Boolean isDeleted) {
		super();
		this.username = username;
		this.password = password;
		this.name = name;
		this.isDeleted = isDeleted;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Boolean getIsDeleted() {
		return isDeleted;
	}

	public void setIsDeleted(Boolean isDeleted) {
		this.isDeleted = isDeleted;
	}
}
