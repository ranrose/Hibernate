package com.delhiguru.relationship.many2one;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

public class Student implements Serializable {

	private long studentId;
	private String StudentName;
	private Address  studentAddress;
	
	
	public Student(){}
	public Student(String StudentName,Address  studentAddress){
		this.StudentName=StudentName;
		this.studentAddress=studentAddress;
	}
	
	public long getStudentId() {
		return studentId;
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
	public Address  getStudentAddress() {
		return studentAddress;
	}
	public void setStudentAddress(Address  studentAddress) {
		this.studentAddress = studentAddress;
	}
	
}
