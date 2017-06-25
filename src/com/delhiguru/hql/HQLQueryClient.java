package com.delhiguru.hql;

import java.util.Iterator;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.delhiguru.misc.Employee;
import com.delhiguru.relationship.one2many.Department;
import com.delhiguru.util.HibernateUtil;


/**
 * This package referes com.delhiguru.one2many package classes.
 * 
 * @author ranjeet
 *
 */
public class HQLQueryClient {

	public static void main(String[] args) {
		getEmployeeByFirstName("Anila");
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
	
	public static Employee getEmployeeByDepartmentName(String firstName) {
		Employee emp = null;
		
		try {
			SessionFactory sf = HibernateUtil.getSessionFactory();
	        Session session = sf.openSession();
	        session.beginTransaction();
	        Query query = session.createQuery("from Employee as e where e.department.departmentName=:dpttName");
	        query.setString("dpttName", firstName);
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
	public static int getHQLUpdateQuery(){
		int result=-1;
		Session session=HibernateUtil.getSessionFactory().openSession();
		try{
			session.beginTransaction();
			Query query=session.createQuery("update Address set street=:streetName"+ " where addressId=:addressId");
			query.setParameter("streetName", "R K puram Gwalior");
			query.setParameter("addressId",(long) 1);
			result=query.executeUpdate();
			session.getTransaction().commit();
		}
		catch(HibernateException e){
			e.printStackTrace();
			return result;
		}
		finally{
			session.close();
		}
		return result;
	}
	public static int getHQLDeleteQuery(){
		int result=-1;
		Session session=HibernateUtil.getSessionFactory().openSession();
		try{
			session.beginTransaction();
			Query query=session.createQuery("Delete from Address where addressId=:addressID");
			query.setParameter("addressID", (long)4);
			result=query.executeUpdate();
			session.getTransaction().commit();
		}
		catch(HibernateException e){
			e.printStackTrace();
			return result;
		}
		finally{
			session.close();
		}
		return result;
	}
	public static int getHQLInsertQuery(){
		int result=-1;
		Session session=HibernateUtil.getSessionFactory().openSession();
		try{
			session.beginTransaction();
			Query query=session.createQuery("insert into Address(street, city, state, zipcode) values ('Rajendar Nagar','Allabhad','UP',775756)");
			result=query.executeUpdate();
			session.getTransaction().commit();
		}
		catch(HibernateException e){
			e.printStackTrace();
			return result;
		}
		finally{
			session.close();
		}
		return result;
	}
	public static void getHQLSelectQuery(){
		Session session=HibernateUtil.getSessionFactory().openSession();
		try{
			session.beginTransaction();
			Query query= session.createQuery("from Department where departmentId=:id");
			query.setParameter("id", (long)2);
			//List list = session.createQuery("from Student where studentId=2").list() ;
			for (Iterator it = query.iterate(); it.hasNext();) {  
				  
				Department dept = (Department) it.next();  
				System.out.println("Name: " + dept.getDepartmentName());  
				} 
			
			//List list=query.list();
			//System.out.println(list.size());
		}
		catch(HibernateException e){
			e.printStackTrace();
		}
		finally{
			session.close();
		}
		
	}
	
}
