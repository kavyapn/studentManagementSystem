package com.studentApp.test;

import java.util.ArrayList;
import java.util.List;

public class MainClass3 {
	

	public static void main(String[] args) {

		System.out.println("*************Student Management System*************");
		System.out.println("************* Welcome *************");

		List<Student2> studentList = new ArrayList<>();

		Student2 s1 = new Student2("Kajal", 22, "S-1");

		s1.enrollCourse("Maths");
		s1.enrollCourse("DSA");
		s1.enrollCourse("Java");
		s1.enrollCourse("DEVOPS");
		s1.enrollCourse("DSA");

		System.out.println(s1);
		// s1.printStudentInfo();

		Student2 s2 = new Student2("Uday", 24, "S-2");
		s2.enrollCourse("DSA");
		System.out.println(s2);

		Student2 s3 = new Student2("Ritu", 27, "S-3");
		s3.enrollCourse("Java");
		System.out.println(s3);

		studentList.add(s1);
		studentList.add(s2);
		studentList.add(s3);
		
		System.out.println("StudentList --> "+studentList);
		System.out.println("StudentList --> "+studentList.getClass());

		
		 try {
	            // Search for a student by ID
	            Student2 foundStudent = s1.findStudentById(studentList, "S-2");
	            System.out.println("Found student: " + foundStudent);
	        } catch (StudentNotFoundException e) {
	            // Handle the exception and display the custom message
	            System.err.println(e.getMessage());
	        }

	        try {
	            // This will throw the custom exception because student ID "S-5" doesn't exist
	            Student2 foundStudent = s1.findStudentById(studentList, "S-5");
	            System.out.println("Found student: " + foundStudent);
	        } catch (StudentNotFoundException e) {
	            // Handle the exception and display the custom message
	            System.err.println(e.getMessage());
	        }

	}

	

}
