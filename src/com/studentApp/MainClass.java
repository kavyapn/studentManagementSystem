package com.studentApp;

public class MainClass {

	public static void main(String[] args) {
		
		System.out.println("*************Student Management System*************");
		System.out.println("************* Welcome *************");
		
		Student s1 = new Student("Kajal", 22, "S-1");
		
		s1.enrollCourse("Maths");
		s1.enrollCourse("DSA");
		s1.enrollCourse("Java");
		s1.enrollCourse("DEVOPS");
		s1.enrollCourse("DSA");
		
		System.out.println(s1);
		//s1.printStudentInfo();
		
		Student s2 = new Student("Uday", 24, "S-11");
		s2.enrollCourse("DSA");
		System.out.println(s2);
		
		
		Student s3 = new Student("Ritu", 27, "S-11");
		s3.enrollCourse("Java");
		System.out.println(s3);
		
		
	}

}
