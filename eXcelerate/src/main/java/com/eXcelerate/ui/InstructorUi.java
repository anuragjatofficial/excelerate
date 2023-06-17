package com.eXcelerate.ui;

import java.time.LocalDate;
import java.util.List;
import java.util.Scanner;

import com.eXcelerate.entities.Assignment;
import com.eXcelerate.entities.Course;
import com.eXcelerate.entities.Lecture;
import com.eXcelerate.entities.Quiz;
import com.eXcelerate.entities.State;
import com.eXcelerate.entities.Status;
import com.eXcelerate.entities.Student;
import com.eXcelerate.exceptions.NoSuchRecordFoundException;
import com.eXcelerate.exceptions.SomethingWentWrongException;
import com.eXcelerate.services.DataServices;
import com.eXcelerate.services.IDataServices;
import com.eXcelerate.utils.IdGeneration;

public class InstructorUi {
	public static void showInstructorUi(Scanner sc) {
		int choice = 0;
		do {
			System.out.println("Press 1. See All courses");
			System.out.println("Press 2. See All students");
			System.out.println("Press 3. Add new Assignment ");
			System.out.println("Press 4. Add new Quiz ");
			System.out.println("Press 5. Post new lecture");
			System.out.print("Enter your choice : ");
			choice = sc.nextInt();
			switch (choice) {
			case 1 -> showCourses();
			case 2 -> showStudents();
			case 3 -> addAssignment(sc);
			case 4 -> addQuiz(sc);
			case 5 -> addLecture(sc);
			}
		} while (choice != 0);
	}

	private static void addLecture(Scanner sc) {
		System.out.print("Enter Couse Id : ");
		int courseId = sc.nextInt();
		
		System.out.print("Enter Lecture Title : ");
		sc.nextLine();
		String title = sc.nextLine();
		
		System.out.print("Enter description of assignment : ");
		String desc = sc.nextLine();
		
		System.out.println("Enter URL of lecture (zoom or meet link) : ");
		String url = sc.nextLine();
		
		Lecture lecture = new Lecture(
					IdGeneration.generateID(),
					title,
					desc,
					Status.PENDING,
					LocalDate.now(),
					url,
					State.ACTIVE
				);
		
		IDataServices iDs = new DataServices();
		try {
			iDs.addLecture(courseId,lecture);
			System.out.println("Lecture posted Successfully..!");
		} catch (SomethingWentWrongException | NoSuchRecordFoundException e) {
			System.out.println(e.getMessage());
		}

	}

	private static void addAssignment(Scanner sc) {
		System.out.print("Enter Couse Id : ");
		int courseId = sc.nextInt();
		
		System.out.print("Enter Assignment Title : ");
		sc.nextLine();
		String title = sc.nextLine();
		
		System.out.print("Enter description of assignment : ");
		String desc = sc.nextLine();
		
		System.out.print("Enter deadLine of assignment (in YYYY-MM-DD format) : ");
		LocalDate deadLine = LocalDate.parse(sc.next());
		
		Assignment assignment = new Assignment(
					IdGeneration.generateID(),
					title,
					desc,
					Status.PENDING,
					LocalDate.now(),
					deadLine,
					State.ACTIVE
				);
		
		IDataServices iDs = new DataServices();
		try {
			iDs.addAssignment(courseId,assignment);
			System.out.println("Assignment added Successfully..!");
		} catch (SomethingWentWrongException | NoSuchRecordFoundException e) {
			System.out.println(e.getMessage());
		}

	}

	private static void showStudents() {
		IDataServices iDs = new DataServices();
		try {
			List<Student> showStudents = iDs.showStudents();
			if (showStudents == null) {
				System.out.println("No student found in DataBase");
				return;
			}
			showStudents.stream().forEach(System.out::println);
		} catch (SomethingWentWrongException | NoSuchRecordFoundException e) {
			System.out.println(e.getMessage());
		}
	}

	private static void showCourses() {
		IDataServices iDs = new DataServices();
		try {
			List<Course> showStudents = iDs.showCourses();
			if (showStudents == null) {
				System.out.println("No Courses found in DataBase");
				return;
			}
			showStudents.stream().forEach(System.out::println);
		} catch (SomethingWentWrongException | NoSuchRecordFoundException e) {
			System.out.println(e.getMessage());
		}
	}
	
	private static void addQuiz(Scanner sc) {
		System.out.print("Enter Couse Id : ");
		int courseId = sc.nextInt();
		
		System.out.print("Enter Quiz Title : ");
		sc.nextLine();
		String title = sc.nextLine();
		
		System.out.print("Enter details of Quiz : ");
		String desc = sc.nextLine();
		
		System.out.print("Enter deadLine of Quiz (in YYYY-MM-DD format) : ");
		LocalDate deadLine = LocalDate.parse(sc.next());
		
		Quiz quiz = new Quiz(
					IdGeneration.generateID(),
					title,
					desc,
					Status.PENDING,
					LocalDate.now(),
					deadLine,
					State.ACTIVE
				);
		
		IDataServices iDs = new DataServices();
		try {
			iDs.addQuiz(courseId,quiz);
			System.out.println("Quiz added Successfully..!");
		} catch (SomethingWentWrongException | NoSuchRecordFoundException e) {
			System.out.println(e.getMessage());
		}

	}

//	public static void main(String[] args) {
//		Scanner sc = new Scanner(System.in);
//		addLecture(sc);
//	}
}
