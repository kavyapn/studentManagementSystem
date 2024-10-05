package com.studentApp.test;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Student2 {

	private String name;
	private int age;
	private String studentId;
	private List<String> courses;
	private static Set<String> studentIds = new HashSet<>();

	public Student2(String name, int age, String studentId) {// throws IllegalArgumentException {
		super();
		if (validateAge(age) && validateName(name) && valideStudentId(studentId)) {
			this.name = name;
			this.age = age;
			this.studentId = studentId;
			courses = new ArrayList<String>(); // Initialization of courses!
			// Add the studentId to the static Set
			studentIds.add(studentId);
		} else {
			// Set the object state to null if validation fails
			this.name = null;
			this.age = 0;
			this.studentId = null;
			this.courses = null; // This prevents enrollCourse() from being used on an invalid object
			System.err.println("Failed to create the student object due to invalid data.");
			// throw new IllegalArgumentException("Invalid data for student creation.");
		}
	}

	public void enrollCourse(String course) {
		if (courses != null && validCourseName(course)) {
			if (!courses.contains(course)) {
				courses.add(course);
				System.out.println("Student is enrolled to the " + course + " successfully");
			} else {
				System.err.println("Student is already enrolled to the course " + course);
			}
		} else {
			System.err.println("Cannot enroll in a course, studentId is invalid.");
		}

	}
	// Array List is non-idempotent in nature -->can have duplicate elements

	public boolean validCourseName(String course) {
		if (course.equalsIgnoreCase("Java") || course.equalsIgnoreCase("DSA") || course.equalsIgnoreCase("Devops")) {
			return true;
		} else {
			System.out.println("Invalid Course Name !! Choose among : [Java , DSA, Devops]");
			return false;
		}
	}

	public void printStudentInfo() {
		System.out.println("==================== Student Info ==================== ");
		System.out.println("Student name :" + name);
		System.out.println("Student Age :" + age);
		System.out.println("Student Id :" + studentId);
		System.out.println("Enrolled for :" + courses);
	}

	// One line information to know the state of the instance variable
	@Override
	public String toString() {
		return "Student [name=" + name + ", age=" + age + ", studentId=" + studentId + ", courses=" + courses + "]";
		// + ", getClass()=" + getClass() + ", hashCode()=" + hashCode() + ",
		// toString()=" + super.toString()
		// + "]";
	}

	public boolean validateAge(int age) {
		if (age >= 19 && age <= 35) {
			return true;
		} else {
			System.err.println("Invalid Age! Student age should be between 19 and 35");
			return false;
		}
	}

	public boolean validateName(String name) {
		String nameRegex = "^[a-zA-Z\\s]+$";
		Pattern namePattern = Pattern.compile(nameRegex);
		// System.out.println(namePattern);
		Matcher nameMatcher = namePattern.matcher(name);
		// System.out.println(nameMatcher);

		if (nameMatcher.matches()) {
			return true;
		} else {
			System.err.println("Invalid name!! Please enter the alphabets only!");
			return false;
		}
	}

	private boolean valideStudentId(String studentId) {
		String studentIdRegex = "S-\\d+$";// "S-[0-9]+$"
		Pattern StudendIdPattern = Pattern.compile(studentIdRegex);
		Matcher studentMatcher = StudendIdPattern.matcher(studentId);

		if (studentMatcher.matches()) {
			if (!studentIds.contains(studentId)) {
				return true;
			} else {
				System.err.println("Invalid StudentId! The ID " + studentId + " is already in use.");
				return false;
			}
		} else {
			System.err.println("Invalid StudentId !! Please begin with S-");
			return false;
		}
	}

	// @SuppressWarnings("unlikely-arg-type")
	public Student2 findStudentById(List<Student2> studentList, String studentId)
			throws StudentNotFoundException {
		/*
		 * System.out.println("StudentId --> out ---> " + studentId);
		 * System.out.println("studentList -->" + studentList);
		 */
		for (Student2 student_human : studentList) {
			/*
			 * System.out.println("Student_human : " + student_human);
			 * System.out.println("studentId : " + studentId);
			 * System.out.println("Student2.getStudentIds() : " + Student2.getStudentIds());
			 */
			if (student_human.getStudentId().equals(studentId)) {
				return student_human; // Return the student if ID matches
			}
		}
		// If no student is found, throw the custom exception
		throw new StudentNotFoundException("Student with ID: " + studentId + " not found.");
	}

	public String getName() {
		return name;
	}

	public int getAge() {
		return age;
	}

	public String getStudentId() {
		return studentId;
	}

	public List<String> getCourses() {
		return courses;
	}

	public static Set<String> getStudentIds() {
		return studentIds;
	}

	// getters

}
