package com.eXcelerate.ui;

import java.util.Scanner;

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
			System.out.println("");
			System.out.println("Enter your choice : ");
			choice = sc.nextInt();
			switch (choice) {
			case 1 -> showCourses(sc);
			case 2 -> showAssignemnts(sc);
			}
		} while (choice != 0);
	}

	public static void showCourses(Scanner sc) {
		ICourseServices iCs = new CourseServices();
		try {
			if (iCs.showCourses() != null) {
				iCs.showCourses().stream().forEach(System.out::println);
			}
		} catch (NoSuchRecordFoundException | SomethingWentWrongException e) {
			System.out.println(e.getMessage());
		}
	}

	public static void showAssignemnts(Scanner sc) {
		ICourseServices iCs = new CourseServices();
		try {
			iCs.showAssignments().stream().forEach(System.out::println);
		} catch (NoSuchRecordFoundException | SomethingWentWrongException e) {
			// TODO Auto-generated catch block
			System.out.println(e.getMessage());
		}
	}
}
