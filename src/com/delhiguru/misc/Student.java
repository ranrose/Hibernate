package com.delhiguru.misc;


import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

public class Student implements Serializable {
	private long studentId;
	private String StudentName;
	private Address studentAddress;
	private Set<Course> courses = new HashSet<Course>(0);

	public Set<Course> getCourses() {
		return courses;
	}

	public void setCourses(Set<Course> courses) {
		this.courses = courses;
	}

	private Set<Phone> studentPhoneNumbers = new HashSet<Phone>(0);

	public Student() {
	}

	public Student(String StudentName, Set<Phone> studentPhoneNumbers,
			Address studentAddress) {
		this.StudentName = StudentName;
		this.studentPhoneNumbers = studentPhoneNumbers;
		this.studentAddress = studentAddress;
	}

	public Student(String StudentName, Set<Course> courses,
			Address studentAddress, String str) {
		this.StudentName = StudentName;
		this.courses = courses;
		this.studentAddress = studentAddress;
	}

	public long getStudentId() {
		return studentId;
	}

	public Set<Phone> getStudentPhoneNumbers() {
		return studentPhoneNumbers;
	}

	public void setStudentPhoneNumbers(Set<Phone> studentPhoneNumbers) {
		this.studentPhoneNumbers = studentPhoneNumbers;
	}

	public void setStudentId(long studentId) {
		this.studentId = studentId;
	}

	public String getStudentName() {
		return StudentName;
	}

	public void setStudentName(String studentName) {
		StudentName = studentName;
	}

	public Address getStudentAddress() {
		return studentAddress;
	}

	public void setStudentAddress(Address studentAddress) {
		this.studentAddress = studentAddress;
	}

	public Student(String StudentName, Address studentAddress) {
		this.StudentName = StudentName;
		this.studentAddress = studentAddress;
	}
}
