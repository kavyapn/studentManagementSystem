package com.studentApp;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class Main {
	private static List<Student> studentList;
	private static Scanner scanner;

	public static void main(String[] args) {

		studentList = new ArrayList<Student>();
		scanner = new Scanner(System.in);

		while (true) {
			System.out.println("============= Student Management System =============");
			System.out.println("************* Welcome *************");
			System.out.println("Selection an Option ...");
			System.out.println("1. Register a student");
			System.out.println("2. Find Student with StudentId");
			System.out.println("3. List all the Student Information");
			System.out.println("4. List Student Information in Sorted order");
			System.out.println("5. Exit");
			System.out.println("\n");
			int option = 0;
			boolean validInput = false;
			
			while(!validInput) {
				try {
					option = scanner.nextInt();
					validInput = true; // if the input is valid ,exit the loop
				}catch (InputMismatchException e) {
					System.out.println("Invalid input! Please enter a number between 1 and 5.");
		            scanner.next();  // Consume the invalid input to avoid infinite loop
				}
			}

			switch (option) {
			case 1:
				enrollStudent(scanner);
				break;
			case 2:
				findStudentbyId(scanner);
				break;
			case 3:
				printAllStudentsData();
				break;
			case 4:
				sortByName();
				break;
			case 5:
				exit();
				break;

			default:
				System.out.println("Invalid option Selected! .. Enter between 1 to 5");
			}
		}
	}

	private static void exit() {
		System.out.println("Good Bye");
		System.exit(0);

	}

	private static void printAllStudentsData() {
		if (studentList.size() > 0) {
			System.out.println(" -------------- Print All Student Data -----------------");
			for (Student student : studentList) {
				student.printStudentInfo();
			}

			System.out.println(" -------------- End -----------------");
			System.out.println("\n");
		} else {
			System.out.println("Student List is Empty !! No Student Record is Found!! ");
		}
	}

	private static void findStudentbyId(Scanner scanner2) {

		Student studentFound = null;
		System.out.println("Enter the StudentId :");
		String studentId = scanner.next();
		
		
		try {
			
			studentFound = studentList.stream().filter(x -> x.getStudentId().equalsIgnoreCase(studentId)).findFirst()
					.orElseThrow(() -> new RuntimeException("No data found !!!"));

		} catch (RuntimeException e) {
			System.err.println("Student with ID " + studentId + " is not found! ");
		}
		
		if(studentFound != null) {
			studentFound.printStudentInfo();
		}else {
			System.out.println("First register the Student with Option-1 and then find the StudentId !");
		}
		

		System.out.println(" -------------- End -----------------");
		System.out.println("\n");

	}

	private static void enrollStudent(Scanner scanner2) {

		System.out.println("Enter the Student name");
		String studentName = scanner2.next();
		

		System.out.println("Enter the Student Age");
		int studentage = scanner2.nextInt();
		

		System.out.println("Enter the Student Id");
		String studentId = scanner2.next();
		

		Student newStudent = new Student(studentName, studentage, studentId);
		
		System.out.println(newStudent);
		
		
		//check if the student creation was successful
		
		
		if(newStudent.getName() == null || newStudent.getStudentId() == null ) {
			//student creation failed. Do not proceed further!
			
			System.out.println("Student Creation Failed due to invalid input. No courses will be enrolled");
			
			return; // Exit the method if the student is invalid
		}
		
		studentList.add(newStudent);
		// System.out.println("Student added successfully into the LMS");

		boolean done = true;
		while (done) {
			System.out.println("Enter the course to be enrolled... type 'Done' to exit !!!");
			String coursename = scanner2.next();
			if (coursename.equalsIgnoreCase("done")) {
				break;
			}
			newStudent.enrollCourse(coursename);

		}
		// Print student information only if the student is valid
		newStudent.printStudentInfo();
	}

	private static void sortByName() {
		
		Comparator<Student> studentNameComparator = (o1,o2) -> {
			if(o1 == null || o2 == null || o1.getName() == null || o2.getName() == null) {
				return 0; //handle null values gracefully
			}
			return o1.getName().compareToIgnoreCase(o2.getName());
		};
		
		System.out.println("before null data --> "+studentList);
		studentList.removeIf(x -> x == null || x.getName() == null );// Make sure no null students are included in the list
		
		
		//Comparator<Student> studentNameComparator = (o1, o2) -> o1.getName().compareTo(o2.getName());

		/*
		 * = new Comparator<Student>() {
		 * 
		 * @Override public int compare(Student o1, Student o2) {
		 * 
		 * return o1.getName().compareTo(o2.getName()); } };
		 */

		Collections.sort(studentList, studentNameComparator);
		System.out.println(studentList);

	}

}
