package com.eXcelerate.ui;

import java.util.Scanner;

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
			case 1 -> ShowCourses(sc);
			}
		} while (choice != 0);
	}

	private static void ShowCourses(Scanner sc) {
		
	}
}
