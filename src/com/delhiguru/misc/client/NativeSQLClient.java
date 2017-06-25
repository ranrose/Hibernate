package com.delhiguru.misc.client;

import java.util.Iterator;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.delhiguru.nativequery.MainClient;
import com.delhiguru.misc.Employee;
import com.delhiguru.util.HibernateUtil;

public class NativeSQLClient {

	/**
	 * before run uncomment Employee and Department hbm.xml in hibernate.cfg.xml
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		NativeSQLClient client = new NativeSQLClient();
		int empid = 1;
		client.getEmployeeByNativeQuery(empid);
	}
	
	public Employee getEmployeeByNativeQuery(int empId) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction transaction = null;
		Employee employee = null;
		try {
			transaction = session.beginTransaction();
			String sql = "SELECT * FROM EMPLOYEE_misc WHERE id = :employee_id";
			SQLQuery query = session.createSQLQuery(sql);
			query.addEntity(Employee.class);
			query.setParameter("employee_id", empId);
			List employees = query.list();
			for (Iterator iterator = employees.iterator(); iterator.hasNext();) {
				employee = (Employee) iterator.next();
				System.out.println("Employee Name--------"+ employee.getFirstName());
				System.out.println("Last Name--------"+ employee.getLastName());
				System.out.println("salary--------" + employee.getSalary());
				break;
			}
			transaction.commit();
		} catch (HibernateException e) {
			if (transaction != null) {
				transaction.commit();
			}
		} finally {
			session.close();
		}
		return employee;

	}
	
	public Employee updateEmployeeByNativeQuery(int empId) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction transaction = null;
		Employee employee = null;
		try {
			transaction = session.beginTransaction();
			String sql = "SELECT * FROM EMPLOYEE_misc WHERE id = :employee_id";
			SQLQuery query = session.createSQLQuery(sql);
			query.addEntity(Employee.class);
			query.setParameter("employee_id", empId);
			List employees = query.list();
			for (Iterator iterator = employees.iterator(); iterator.hasNext();) {
				employee = (Employee) iterator.next();
				System.out.println("Employee Name--------"+ employee.getFirstName());
				System.out.println("  Last Name--------"+ employee.getLastName());
				System.out.println("	Salary--------" + employee.getSalary());
				break;
			}
			transaction.commit();
		} catch (HibernateException e) {
			if (transaction != null) {
				transaction.commit();
			}
		} finally {
			session.close();
		}
		return employee;

	}
	
	public Employee insetEmployeeByNativeQuery() {
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction transaction = null;
		Employee employee = null;
		try {
			transaction = session.beginTransaction();
			String sql = "SELECT * FROM EMPLOYEE_misc WHERE id = :employee_id";
			SQLQuery query = session.createSQLQuery(sql);
			
			// as query.addEntity(Employee.class); is the optional parameter, if addEntity will not provided then it return Object arrays
			query.addEntity(Employee.class);
			//query.setParameter("employee_id", empId);
			List employees = query.list();
			for (Iterator iterator = employees.iterator(); iterator.hasNext();) {
				employee = (Employee) iterator.next();
				System.out.println("Employee Name--------"+ employee.getFirstName());
				System.out.println("  Last Name--------"+ employee.getLastName());
				System.out.println("	Salary--------" + employee.getSalary());
				break;
			}
			transaction.commit();
		} catch (HibernateException e) {
			if (transaction != null) {
				transaction.commit();
			}
		} finally {
			session.close();
		}
		return employee;

	}
}
