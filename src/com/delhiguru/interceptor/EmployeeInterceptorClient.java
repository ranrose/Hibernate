package com.delhiguru.interceptor;

import java.util.Iterator;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

public class EmployeeInterceptorClient {
	private static SessionFactory factory;

	public static void main(String[] args) {
		
		factory = HibernateUtil.getSessionFactory();
		EmployeeInterceptorClient client = new EmployeeInterceptorClient();
		
		// Create employee object and set properties by using constructor.
		Employee empObj1 = new Employee("Anushka", "Sharma", 1000);
		Employee empObj2 = new Employee("Tanisha", "Kumar", 1000);
		
		// Add few employee records in database 
		Integer empID1 = client.addEmployee(empObj1);
		Integer empID2 = client.addEmployee(empObj2);

		// List down all the employees 
		client.getEmployees();

		// Update employee's records 
		client.updateEmployee(empID1, 5000);

		// Delete an employee from the database 
		client.deleteEmployee(empID2);

		// List down new list of the employees 
		client.getEmployees();
	}

	/**
	 *  This  Method to CREATE an employee in the database.
	 * 
	 * @param fname
	 * @param lname
	 * @param salary
	 * @return
	 */
	public Integer addEmployee(Employee employee) {
		AuditLogInterceptor interceptor = new AuditLogInterceptor();
		Session session = factory.openSession(interceptor);
		interceptor.setSession(session);
		Transaction tx = null;
		Integer empId = null;
		try {
			tx = session.beginTransaction();
			empId = (Integer) session.save(employee);
			tx.commit();
		} catch (HibernateException e) {
			if (tx != null)
				tx.rollback();
			e.printStackTrace();
		} finally {
			session.close();
		}
		return empId;
	}

	/**
	 * This method is used to get all employees from the records.
	 */
	public void getEmployees() {
		AuditLogInterceptor interceptor = new AuditLogInterceptor();
		Session session = factory.openSession(interceptor);
		interceptor.setSession(session);
		Transaction tx = null;
		try {
			tx = session.beginTransaction();
			List employees = session.createQuery("FROM Employee").list();
			for (Iterator iterator = employees.iterator(); iterator.hasNext();) {
				Employee employee = (Employee) iterator.next();
				System.out.print("First Name: " + employee.getFirstName());
				System.out.print("Last Name: " + employee.getLastName());
				System.out.println("Salary: " + employee.getSalary());
			}
			tx.commit();
		} catch (HibernateException e) {
			if (tx != null)
				tx.rollback();
			e.printStackTrace();
		} finally {
			session.close();
		}
	}

	/**
	 * @param employeeId
	 * @param salary
	 */
	public void updateEmployee(Integer employeeId, int salary) {
		AuditLogInterceptor interceptor = new AuditLogInterceptor();
		Session session = factory.openSession(interceptor);
		interceptor.setSession(session);

		Transaction tx = null;
		try {
			tx = session.beginTransaction();
			Employee employee = (Employee) session.get(Employee.class, employeeId);
			employee.setSalary(salary);
			session.update(employee);
			tx.commit();
		} catch (HibernateException e) {
			if (tx != null)
				tx.rollback();
			e.printStackTrace();
		} finally {
			session.close();
		}
	}

	/**
	 * This method is used to delete from the records.
	 * 
	 * @param employeeId
	 */
	public void deleteEmployee(Integer employeeId) {
		AuditLogInterceptor interceptor = new AuditLogInterceptor();
		Session session = factory.openSession(interceptor);
		interceptor.setSession(session);
		Transaction tx = null;
		try {
			tx = session.beginTransaction();
			Employee employee = (Employee) session.get(Employee.class, employeeId);
			session.delete(employee);
			tx.commit();
		} catch (HibernateException e) {
			if (tx != null)
				tx.rollback();
			e.printStackTrace();
		} finally {
			session.close();
		}
	}

}
