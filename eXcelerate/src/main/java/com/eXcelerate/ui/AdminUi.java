
package com.eXcelerate.ui;

import java.util.Scanner;

import com.eXcelerate.entities.Course;
import com.eXcelerate.entities.State;
import com.eXcelerate.exceptions.SomethingWentWrongException;
import com.eXcelerate.services.AdminServices;
import com.eXcelerate.services.IAdminServices;

public class AdminUi {
	/**
	 * Main UI for Admin side
	 */
	public static void showAdminUi(Scanner sc) {
		int choice = 0;
		do {
			System.out.println("Press 1. Add course");
			System.out.println("");
			System.out.print("Enter your choice : ");
			choice = sc.nextInt();
			switch(choice) {
			case 1 -> addCourse(sc);
			}
		}while(choice!=0);
	}

	private static void addCourse(Scanner sc) {
		System.out.print("Enter course Name :");
		String courseName = sc.nextLine();
		Course course = new Course(courseName);
		course.setCourseStatus(State.ACTIVE);
		IAdminServices iAs = new AdminServices();
		try {
			iAs.addCourses(course);
			System.out.println("Course added succesfully .. !");
		} catch (SomethingWentWrongException e) {
			System.out.println(e.getMessage());;
		}
	}
//	public static void main(String[] args) {
//		Scanner sc = new Scanner(System.in);
//		addCourse(sc);
//	}
}
