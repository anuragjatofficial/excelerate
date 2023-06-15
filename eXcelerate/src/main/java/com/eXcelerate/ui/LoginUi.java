package com.eXcelerate.ui;

import java.util.Scanner;

import com.eXcelerate.exceptions.NoSuchRecordFoundException;
import com.eXcelerate.exceptions.SomethingWentWrongException;
import com.eXcelerate.services.ILoginServices;
import com.eXcelerate.services.LoginServices;

public class LoginUi {
	// Here we are taking input from console so that user login
	public static void instructorLogin(Scanner sc) {
		System.out.print("Enter username : ");
		sc.nextLine();
		String username = sc.nextLine().trim();
		System.out.print("Enter password : ");
		String password = sc.nextLine();
		ILoginServices iLs = new LoginServices();
		try {
			if (iLs.LoginInstructor(username, password)) {
				System.out.println("Login succes .. !");
			} else {
				System.out.println("incorrect username or password ");
			}
		} catch (SomethingWentWrongException | NoSuchRecordFoundException e) {
			System.out.println(e.getMessage());
		}
	}

	public static void studentLogin(Scanner sc) {
		System.out.print("Enter username : ");
		sc.nextLine();
		String username = sc.nextLine().trim();
		System.out.print("Enter password : ");
		String password = sc.nextLine();
		System.out.println(username + password);
		ILoginServices iLs = new LoginServices();
		try {
			if (iLs.LoginStudent(username, password)) {
				System.out.println("Login succes .. !");
			} else {
				System.out.println("incorrect username or password ");
			}
		} catch (SomethingWentWrongException | NoSuchRecordFoundException e) {
			System.out.println(e.getMessage());
		}
	}

	public static void adminLogin(Scanner sc) {
		System.out.print("Enter username : ");
		sc.nextLine();
		String username = sc.nextLine().trim();
		System.out.print("Enter password : ");
		String password = sc.nextLine();
		ILoginServices iLs = new LoginServices();
		if (iLs.LoginAdmin(username, password)) {
			System.out.println("Login success .. !");
		} else {
			System.out.println("wrong username or password");
		}
	}
}
