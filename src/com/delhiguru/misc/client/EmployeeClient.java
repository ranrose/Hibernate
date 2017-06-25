package com.delhiguru.misc.client;

import java.util.Date;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.delhiguru.misc.Employee;
import com.delhiguru.util.HibernateUtil;

public class EmployeeClient {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Employee employee = new Employee("Rakesh", "Mishra", 50000, new Date());
		Employee employee2 = new Employee("Anila", "jha", 10000, new Date());
		Employee employee3 = new Employee("Mansi", "jain", 20000, new Date());
		
		EmployeeClient client = new EmployeeClient();
		int empId1 = client.saveEmployee(employee);
		System.out.println("saved: empId: " + empId1);
		empId1 = client.saveEmployee(employee2);
		System.out.println("saved: empId: " + empId1);
		empId1 = client.saveEmployee(employee3);
		System.out.println("saved: empId: " + empId1);
		
	}

	public int saveEmployee(Employee employee) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction transaction = null;
		int empId = 0;
		try {
			transaction = session.beginTransaction();
			empId = (Integer) session.save(employee);
			transaction.commit();
		} catch (HibernateException e) {
			transaction.rollback();
			e.printStackTrace();
		} finally {
			session.close();
		}
		return empId;
	}
}
