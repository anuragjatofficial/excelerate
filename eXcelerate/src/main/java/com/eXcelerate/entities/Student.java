package com.eXcelerate.entities;

import javax.persistence.Entity;

@Entity
public class Student extends User {

	public Student() {
		super();
	}

	public Student(String username, String password, String name, State accountStatus) {
		super(username, password, name, accountStatus);
	}

}
