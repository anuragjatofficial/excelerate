package com.eXcelerate.ui;

import java.util.Scanner;

import com.eXcelerate.exceptions.AlreadyUpdatedException;
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
			case 4 -> showLectures(sc);
			case 5 -> updateAssignmentStatus(sc);
			case 6 -> updateQuizStatus(sc);
			case 7 -> updateLectureStatus(sc);
			case 0 -> choice = 0;
			}
		} while (choice != 0);
	}

	private static void updateLectureStatus(Scanner sc) {
		System.out.print("Enter course Id : ");
		int courseID = sc.nextInt();
		System.out.print("Enter Lecture ID : ");
		int lectureID = sc.nextInt();
		ICourseServices iCs = new CourseServices();
		try {
			iCs.updateLectureStatus(courseID, lectureID);
			System.out.println("Lecture status updated successfully .. !");
		} catch (NoSuchRecordFoundException | SomethingWentWrongException | NoAccountLoggedInException | AlreadyUpdatedException e) {
			System.out.println(e.getMessage());
		}
	}

	private static void updateQuizStatus(Scanner sc) {
		System.out.print("Enter course Id : ");
		int courseID = sc.nextInt();
		System.out.print("Enter Quiz ID : ");
		int quizID = sc.nextInt();
		System.out.print("1. Mark as pending , 2. Mark as completed (1/2) : ");
		int status = sc.nextInt();
		ICourseServices iCs = new CourseServices();
		try {
			iCs.updateQuizStatus(courseID, quizID, status);
			System.out.println("Quiz status updated successfully .. !");
		} catch (NoSuchRecordFoundException | SomethingWentWrongException | NoAccountLoggedInException | AlreadyUpdatedException e) {
			System.out.println(e.getMessage());
		}
	}

	private static void updateAssignmentStatus(Scanner sc) {
		System.out.print("Enter Course Id : ");
		int courseID = sc.nextInt();
		System.out.print("Enter Assignment ID : ");
		int assignmentID = sc.nextInt();
		System.out.print("1. Mark as pending , 2. Mark as completed (1/2) : ");
		int status = sc.nextInt();
		ICourseServices iCs = new CourseServices();
		try {
			iCs.updateAssignmentStatus(courseID, assignmentID, status);
			System.out.println("Assignment status updated successfully .. !");
		} catch (NoSuchRecordFoundException | SomethingWentWrongException | NoAccountLoggedInException | AlreadyUpdatedException e) {
			System.out.println(e.getMessage());
		}
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

	public static void showLectures(Scanner sc) {
		ICourseServices iCs = new CourseServices();
		try {
			iCs.showLectures().stream().forEach(System.out::println);
		} catch (NoSuchRecordFoundException | SomethingWentWrongException | NoAccountLoggedInException e) {
			System.out.println(e.getMessage());
		}
	}

//	public static void main(String[] args) {
//		showCourses(Scanner sc);
//	}
}
