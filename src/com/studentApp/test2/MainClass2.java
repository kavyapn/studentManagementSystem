package com.studentApp.test2;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class MainClass2 {
	private static List<Student> studentList;

	public static void main(String[] args) {

		System.out.println("*************Student Management System*************");
		System.out.println("************* Welcome *************");

		studentList = new ArrayList<Student>();

		Student s1 = new Student("Kajal", 22, "S-1");

		s1.enrollCourse("Maths");
		s1.enrollCourse("DSA");
		s1.enrollCourse("Java");
		s1.enrollCourse("DEVOPS");
		s1.enrollCourse("DSA");

		System.out.println(s1);
		// s1.printStudentInfo();

		Student s2 = new Student("Uday", 24, "S-2");
		s2.enrollCourse("DSA");
		System.out.println(s2);

		Student s3 = new Student("Ritu", 27, "S-3");
		s3.enrollCourse("Java");
		System.out.println(s3);

		studentList.add(s1);
		studentList.add(s2);
		studentList.add(s3);

		Student result = findStudentbyId("S-11");
		System.out.println("result --> "+result);
		
		sortByName();

	}

	private static void sortByName() {
		Comparator<Student> studentNameComparator = (o1,o2) -> o1.getName().compareTo(o2.getName());
		
		/*= new Comparator<Student>() {
			
			@Override
			public int compare(Student o1, Student o2) {
				
				return o1.getName().compareTo(o2.getName());
			}
		};*/
		
		Collections.sort(studentList,studentNameComparator);
		System.out.println(studentList);
		
	}

	public static Student findStudentbyId(String studentId) {
		
		
		Student result = null;
		try {
		result = studentList.stream().filter(x -> x.getStudentId().equalsIgnoreCase(studentId)).findFirst()
				.orElseThrow(() -> new RuntimeException("No data found !!!"));
		}
		catch (RuntimeException e){
			System.err.println("Student with ID "+studentId+" is not found! ");
		}
		return result;

	}

}
