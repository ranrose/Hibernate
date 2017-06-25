package com.delhiguru.misc.client;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.delhiguru.misc.Employee;
import com.delhiguru.util.HibernateUtil;

public class EmployeeClientHQL {

	public static void main(String[] args) {
		
		
	}
	
	public static Employee getEmployeeByFirstName(String firstName) {
		Employee emp = null;
		
		try {
			SessionFactory sf = HibernateUtil.getSessionFactory();
	        Session session = sf.openSession();
	        session.beginTransaction();
	        Query query = session.createQuery("from Employee as e where e=:fName");
	        query.setString("fName", firstName);
	        List list = query.list();
	        if (list != null && list.size() > 0) {
	        	emp = (Employee) list.get(0);
	        }
	 
	        session.getTransaction().commit();
	        session.close();
		} catch (Exception e2) {
			// TODO: handle exception
		}
		 
		return emp;
        
	} 
}
