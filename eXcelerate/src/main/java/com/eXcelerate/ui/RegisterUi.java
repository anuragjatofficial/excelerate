package com.eXcelerate.ui;

import java.util.Scanner;

import com.eXcelerate.entities.Student;
import com.eXcelerate.entities.User;

public class RegisterUi {

	public static void registerInstrucor(Scanner sc) {
		User instructor = new Student();
		System.out.print("Enter name : ");
		sc.nextLine();
		instructor.setName(sc.nextLine().trim());
		System.out.print("Enter username : ");
		instructor.setUsername(sc.nextLine());
		System.out.print("Enter password : ");
		instructor.setPassword(sc.next());
		instructor.setIsDeleted(false);
		System.out.println(instructor);
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
		student.setIsDeleted(false);
		System.out.println(student);
	}
}
