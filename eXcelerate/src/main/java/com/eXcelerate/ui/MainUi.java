package com.eXcelerate.ui;

import java.util.Scanner;

public class MainUi {

	/**
	 * These color codes are used to give good color to plain text in console
	 */
	public static final String ANSI_RESET = "\u001B[0m";
	public static final String ANSI_BLACK = "\u001B[30m";
	public static final String ANSI_RED = "\u001B[31m";
	public static final String ANSI_GREEN = "\u001B[32m";
	public static final String ANSI_YELLOW = "\u001B[33m";
	public static final String ANSI_BLUE = "\u001B[34m";
	public static final String ANSI_PURPLE = "\u001B[35m";
	public static final String ANSI_CYAN = "\u001B[36m";
	public static final String ANSI_WHITE = "\u001B[37m";
	/**
	 * 
	 * These color codes are just written in order to give background color to UI /
	 * console so that console will not look boring
	 *
	 */
	public static final String ANSI_BLACK_BACKGROUND = "\u001B[40m";
	public static final String ANSI_RED_BACKGROUND = "\u001B[41m";
	public static final String ANSI_GREEN_BACKGROUND = "\u001B[42m";
	public static final String ANSI_YELLOW_BACKGROUND = "\u001B[43m";
	public static final String ANSI_BLUE_BACKGROUND = "\u001B[44m";
	public static final String ANSI_PURPLE_BACKGROUND = "\u001B[45m";
	public static final String ANSI_CYAN_BACKGROUND = "\u001B[46m";
	public static final String ANSI_WHITE_BACKGROUND = "\u001B[47m";

	public static void mainUi(Scanner sc) {
		int choice = 0;
		do {
			System.out.println("");
			System.out.println(ANSI_GREEN + "Press 1." + ANSI_RESET + " Login as Instructor");
			System.out.println(ANSI_GREEN + "Press 2." + ANSI_RESET + " Login as Student");
			System.out.println(ANSI_GREEN + "Press 3." + ANSI_RESET + " Login as Admin");
			System.out.println(ANSI_GREEN + "Press 2." + ANSI_RESET + " Exit app");
			System.out.println("");
			System.out.print(ANSI_GREEN_BACKGROUND + "Enter your choice :" + ANSI_RESET + "\t");
			choice = sc.nextInt();
			System.out.println("");
			switch (choice) {
//			case 1 -> instructorLogin();
//			case 2 -> studentLogin();
//			case 3 -> adminLogin();
			case 4 -> {System.out.println("Thanks for using our services .. !"); choice = 0;}
			default ->
				System.out.println("unexpected choice " + choice);
			}
		}while(choice!=0);

	}
}
