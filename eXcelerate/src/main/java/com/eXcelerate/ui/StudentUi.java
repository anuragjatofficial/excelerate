package com.eXcelerate.ui;

import java.util.Scanner;

import com.eXcelerate.exceptions.NoAccountLoggedInException;
import com.eXcelerate.exceptions.NoSuchRecordFoundException;
import com.eXcelerate.exceptions.SomethingWentWrongException;
import com.eXcelerate.services.CourseServices;
import com.eXcelerate.services.ICourseServices;

public class StudentUi {
	public static void showStudentUi(Scanner sc) {
		int choice = 0;
		do {
			System.out.println("Press 1. Show Current Courses");
			System.out.println("Press 2. Show assignments ");
			System.out.println("Press 3. Show quizzes ");
			System.out.println("Press 4. Show Lectures ");
			System.out.println("Press 5. Update assignment status");
			System.out.println("Press 6. Update Quiz status");
			System.out.println("Press 7. Update Lecture as watched");
			System.out.println("Press 0. Exit");
			System.out.println("");
			System.out.println("Enter your choice : ");
			choice = sc.nextInt();
			switch (choice) {
			case 1 -> showCourses(sc);
			case 2 -> showAssignemnts(sc);
			case 3 -> showQuizzes(sc);
			case 0 -> choice = 0;
			}
		} while (choice != 0);
	}

	public static void showCourses(Scanner sc) {
		ICourseServices iCs = new CourseServices();
		try {
			if (!iCs.showCourses().isEmpty()) {
				iCs.showCourses().stream().forEach(System.out::println);
			}
		} catch (NoSuchRecordFoundException | SomethingWentWrongException | NoAccountLoggedInException e) {
			System.out.println(e.getMessage());
		}
	}

	public static void showAssignemnts(Scanner sc) {
		ICourseServices iCs = new CourseServices();
		try {
			iCs.showAssignments().stream().forEach(System.out::println);
		} catch (NoSuchRecordFoundException | SomethingWentWrongException | NoAccountLoggedInException e) {
			System.out.println(e.getMessage());
		}
	}
	
	public static void showQuizzes(Scanner sc) {
		ICourseServices iCs = new CourseServices();
		try {
			iCs.showQuizzes().stream().forEach(System.out::println);
		} catch (NoSuchRecordFoundException | SomethingWentWrongException | NoAccountLoggedInException e) {
			System.out.println(e.getMessage());
		}
	}
//	public static void main(String[] args) {
//		showCourses(Scanner sc);
//	}
}
