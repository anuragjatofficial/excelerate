
package com.eXcelerate.ui;

import java.util.Arrays;
import java.util.Scanner;

import com.eXcelerate.entities.Course;
import com.eXcelerate.entities.State;
import com.eXcelerate.exceptions.NoSuchRecordFoundException;
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
			System.out.println("Press 2. Assign courses to student ");
			System.out.println("Press 3. Delete courses ");
			System.out.println("");
			System.out.print("Enter your choice : ");
			choice = sc.nextInt();
			switch(choice) {
			case 1 -> addCourse(sc);
			case 2 -> assignCoureToStudent(sc);
//			case 3 -> deleteCourseById(sc);
			}
		}while(choice!=0);
	}

//	private static Object deleteCourseById(Scanner sc) {
//		System.out.print("Enter course ID :");
//	}

	private static void assignCoureToStudent(Scanner sc) {
		System.out.println("Enter student id : ");
		int StudentId = sc.nextInt();
		System.out.println("Enter course id's (space seperated vaues only) : ");
		sc.nextLine();
		int[] courseIDs =Arrays.stream(sc.nextLine().trim().split(" ")).mapToInt(Integer::parseInt).toArray();		
		IAdminServices iAs = new AdminServices();
		try {
			iAs.assignCoureToStudent(courseIDs,StudentId);
			System.out.println("courses assinged to student ");
		} catch (SomethingWentWrongException | NoSuchRecordFoundException e) {
			System.out.println(e.getMessage());
		}
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
//		assignCoureToStudent(sc);
//	}
}
