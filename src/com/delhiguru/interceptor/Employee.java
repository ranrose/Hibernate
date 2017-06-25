package com.delhiguru.interceptor;

import java.io.Serializable;

public class Employee implements Auditable, Serializable {

	private Integer id;
	private String firstName;
	private String lastName;
	private int salary;
	
	public Employee() {
		
	}
	
	public Employee(String fName, String lName, int sal) {
		firstName = fName;
		lastName = lName;
		salary = sal;
	}
	
	@Override
	public String getLogDeatil() {
		StringBuilder sb = new StringBuilder();
		sb.append("id :" ).append(this.id)
		  .append(", firstName : ").append(this.firstName)
		  .append(", lastName :").append(this.lastName)
		  .append(", salary : ").append(this.salary); 
		return sb.toString();
	}

	@Override
	public Long getEntityId() {
		return this.id.longValue();
	}
	
	/**
	 * @return the id
	 */
	public Integer getId() {
		return id;
	}

	/**
	 * @param id
	 *            the id to set
	 */
	public void setId(Integer id) {
		this.id = id;
	}

	/**
	 * @return the firstName
	 */
	public String getFirstName() {
		return firstName;
	}

	/**
	 * @param firstName
	 *            the firstName to set
	 */
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	/**
	 * @return the lastName
	 */
	public String getLastName() {
		return lastName;
	}

	/**
	 * @param lastName
	 *            the lastName to set
	 */
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	/**
	 * @return the salary
	 */
	public int getSalary() {
		return salary;
	}

	/**
	 * @param salary
	 *            the salary to set
	 */
	public void setSalary(int salary) {
		this.salary = salary;
	}

	

	  

}
