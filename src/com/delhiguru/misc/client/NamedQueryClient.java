package com.delhiguru.misc.client;

import java.util.Iterator;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.delhiguru.misc.Employee;
import com.delhiguru.util.HibernateUtil;

public class NamedQueryClient {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		NamedQueryClient client=new NamedQueryClient();
		client.getEmployeeByFirstNameViaHQL();//using HQL
		client.getEmployeeByFirstNameViaSQL();//using SQL
		
	}
	public void getEmployeeByFirstNameViaHQL(){
		Session session=HibernateUtil.getSessionFactory().openSession();
		Transaction transaction=null;
		try{
			transaction=session.beginTransaction();
			Query query=session.getNamedQuery("findEmployeeByFirstNameHql").setString("firstName", "Anila");
			List employees = query.list();
			for(Iterator iterator=employees.iterator();iterator.hasNext();){
				Employee employee=(Employee)iterator.next();
				System.out.println("Employee Name--------"+employee.getFirstName());
				System.out.println("Last Name--------"+employee.getLastName());
				System.out.println("Salary--------"+employee.getSalary());
			}
			transaction.commit();
		}
		catch(HibernateException e){
			if(transaction!=null){
				transaction.commit();
			}
		}
		finally{
			session.close();
		}
	}
	public void getEmployeeByFirstNameViaSQL(){
		Session session=HibernateUtil.getSessionFactory().openSession();
		Transaction transaction=null;
		try{
			transaction=session.beginTransaction();
			Query query=session.getNamedQuery("findEmployeeByFirstNameSql").setString("firstname", "Anila");
			List employees = query.list();
			for(Iterator iterator=employees.iterator();iterator.hasNext();){
				Employee employee=(Employee)iterator.next();
				System.out.println("Employee Name--------"+employee.getFirstName());
				System.out.println("Last Name--------"+employee.getLastName());
				System.out.println("Salary--------"+employee.getSalary());
			}
			transaction.commit();
		}
		catch(HibernateException e){
			if(transaction!=null){
				transaction.commit();
			}
		}
		finally{
			session.close();
		}
	}
}
