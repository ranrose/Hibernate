package com.delhiguru.misc;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

public class Employee implements Serializable {
	private int id;
	private String firstName;
	private String lastName;
	private int salary;
	private Date dateOfBirth;

	private BigDecimal basicComponent;

	public BigDecimal getBasicComponent() {
		return basicComponent;
	}

	public void setBasicComponent(BigDecimal basicComponent) {
		this.basicComponent = basicComponent;
	}

	public Employee() {
	}

	public Employee(String fname, String lname, int salary, Date dob) {
		this.firstName = fname;
		this.lastName = lname;
		this.salary = salary;
		this.dateOfBirth = dob;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String first_name) {
		this.firstName = first_name;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String last_name) {
		this.lastName = last_name;
	}

	public int getSalary() {
		return salary;
	}

	public void setSalary(int salary) {
		this.salary = salary;
	}
	
	/**
	 * @return the dateOfBirth
	 */
	public Date getDateOfBirth() {
		return dateOfBirth;
	}

	/**
	 * @param dateOfBirth
	 *            the dateOfBirth to set
	 */
	public void setDateOfBirth(Date dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}
}