package com.eXcelerate.ui;

import java.util.Scanner;

import com.eXcelerate.entities.Instructor;
import com.eXcelerate.entities.State;
import com.eXcelerate.entities.Student;
import com.eXcelerate.entities.User;
import com.eXcelerate.exceptions.SomethingWentWrongException;
import com.eXcelerate.services.IRegisterServices;
import com.eXcelerate.services.RegisterServices;

public class RegisterUi {

	public static void registerInstrucor(Scanner sc) {
		User instructor = new Instructor();
		System.out.print("Enter name : ");
		sc.nextLine();
		instructor.setName(sc.nextLine().trim());
		System.out.print("Enter username : ");
		instructor.setUsername(sc.nextLine());
		System.out.print("Enter password : ");
		instructor.setPassword(sc.next());
		instructor.setAccountStatus(State.ACTIVE);
		System.out.println(instructor);
		IRegisterServices iLs = new RegisterServices();
		try {
			System.out.println(iLs.registerInstructor((Instructor) instructor));
		} catch (SomethingWentWrongException e) {
			System.out.println(e.getMessage());
		}
	}

	public static void registerStudent(Scanner sc) {
		User student = new Student();
		System.out.print("Enter name : ");
		sc.nextLine();
		student.setName(sc.nextLine().trim());
		System.out.print("Enter username : ");
		student.setUsername(sc.nextLine());
		System.out.print("Enter password : ");
		student.setPassword(sc.next());
		student.setAccountStatus(State.ACTIVE);
		IRegisterServices iLs = new RegisterServices();
		try {
			System.out.println(iLs.registerStudent((Student) student));
		} catch (SomethingWentWrongException e) {
			System.out.println(e.getMessage());
		}
	}
}
