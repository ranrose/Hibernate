package com.delhiguru.misc.client;

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
		//getEmployeeByFirstName("Anila");
		
		// get entity witout namedParameter
		//getEmployee();
		
		// get info by Group By
		//getInfoGroupBy();
		
		// HQL update example
		//getHQLUpdateQuery();
		
		// Delete HQL example
		//getHQLDeleteQuery(2);
		
		// insert HQL example
		getHQLInsertQuery();
		
	}
	public static Employee getEmployeeByFirstName(String firstName) {
		Employee emp = null;
		
		try {
			SessionFactory sf = HibernateUtil.getSessionFactory();
	        Session session = sf.openSession();
	        session.beginTransaction();
	        Query query = session.createQuery("from com.delhiguru.misc.Employee as e where e.firstName=:fName");
	        query.setString("fName", firstName);
	        List list = query.list();
	        if (list != null && list.size() > 0) {
	        	emp = (Employee) list.get(0);
	        	System.out.println("firstName " + emp.getFirstName() + " ,sal : " + emp.getSalary());
	        }
	 
	        session.getTransaction().commit();
	        session.close();
		} catch (Exception e2) {
			// TODO: handle exception
		}
		 
		return emp;
        
	}
	
	public static Employee getEmployee() {
		Employee emp = null;
		String firstName = "Anila";
		
		try {
			SessionFactory sf = HibernateUtil.getSessionFactory();
	        Session session = sf.openSession();
	        session.beginTransaction();
	        //String hql = "from com.delhiguru.misc.Employee as e where e.firstName=:fName";
	        //String hql = "from com.delhiguru.misc.Employee as e where e.firstName=:fName";
	        //String hql = "SELECT E.firstName FROM com.delhiguru.misc.Employee E";  // select a field of object not object then use select
	        //String hql = "FROM com.delhiguru.misc.Employee e WHERE e.id > 2 ORDER BY e.salary DESC";
	        String hql = "FROM com.delhiguru.misc.Employee e WHERE e.id > 1  ORDER BY e.firstName DESC, e.salary DESC ";

	        Query query = session.createQuery(hql);
	        //query.setString("fName", firstName);
	        //query.setFirstResult(1);
	        //query.setMaxResults(2);

	        List list = query.list();
	        
	        if (list != null && list.size() > 0) {
	        	emp = (Employee) list.get(0);
	        	System.out.println("reuturned Size : " + list.size());
	        	System.out.println("firstName " + emp.getFirstName() +", lastName " + emp.getLastName() + " , sal : " + emp.getSalary());
	        	
	        	System.out.println("----------------------------------------------------------");
	        	for (int i = 0; i < list.size(); i++) {
	        		Employee e = (Employee) list.get(i);
	        		System.out.println("id: " + e.getId() + " , firstName : " + e.getFirstName() + ", sal : " + e.getSalary());
	        		
	        	}
	        	System.out.println("----------------------------------------------------------");
	        }
	        
	 
	        session.getTransaction().commit();
	        session.close();
		} catch (Exception e2) {
			// TODO: handle exception
		}
		 
		return emp;
        
	}
	
	public static void getInfoGroupBy() {
		Employee emp = null;
		
		try {
			SessionFactory sf = HibernateUtil.getSessionFactory();
	        Session session = sf.openSession();
	        //String hql = "SELECT SUM(e.salary), e.firstName FROM com.delhiguru.misc.Employee e GROUP BY e.firstName";
	       // String hql = "SELECT avg(e.salary), e.firstName FROM com.delhiguru.misc.Employee e GROUP BY e.firstName";
	        //String hql = "SELECT Min(e.salary), e.firstName FROM com.delhiguru.misc.Employee e GROUP BY e.firstName";
	        String hql = "SELECT MAX(e.salary), e.firstName FROM com.delhiguru.misc.Employee e GROUP BY e.firstName";
	        // avg return double, sum return long, MIN and MAX return integer 
	        Query query = session.createQuery(hql);
	        List list = query.list();
	        
	        if (list != null && list.size() > 0) {
	        	Object[] objArray = (Object[])list.get(0);
	        	//Long  salSum = (Long)objArray[0];
	        	//Double  salSum = (Double)objArray[0];
	        	Integer  salSum = (Integer)objArray[0];
	        	String firstName = (String)objArray[1];
	        	System.out.println("firstName " + firstName + " , sal : " + salSum);
	        	
	        }
	        session.close();
		} catch (Exception e2) {
			e2.printStackTrace();
		}
        
	}
	
	
	public static Employee getEmployeeByDepartmentName(String deptName) {
		Employee emp = null;
		
		try {
			SessionFactory sf = HibernateUtil.getSessionFactory();
	        Session session = sf.openSession();
	        session.beginTransaction();
	        Query query = session.createQuery("from com.delhiguru.misc.Employee as e where e.department.departmentName=:dpttName");
	        query.setString("dpttName", deptName);
	        List list = query.list();
	        if (list != null && list.size() > 0) {
	        	emp = (Employee) list.get(0);
	        	System.out.println("----------------------------------------------------------");
	        	for (int i = 0; i < list.size(); i++) {
	        		Employee e = (Employee) list.get(i);
	        		System.out.println("id: " + e.getId() + " , firstName : " + e.getFirstName() + ", sal : " + e.getSalary());
	        		
	        	}
	        	System.out.println("----------------------------------------------------------");
	        }
	 
	        session.getTransaction().commit();
	        session.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		 
		return emp;
        
	}
	public static int getHQLUpdateQuery(long addressId){
		int result=-1;
		Session session=HibernateUtil.getSessionFactory().openSession();
		try{
			session.beginTransaction();
			Query query=session.createQuery("update com.delhiguru.misc.Address set street=:streetName"+ " where addressId=:addressId");
			query.setParameter("streetName", "R K puram Gwalior");
			query.setParameter("addressId",(long) addressId);
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
	public static int getHQLDeleteQuery(long addressId){
		int result=-1;
		Session session=HibernateUtil.getSessionFactory().openSession();
		try{
			session.beginTransaction();
			Query query=session.createQuery("Delete from com.delhiguru.misc.Address where addressId=:addressID");
			query.setParameter("addressID", (long)addressId);
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
			Query query=session.createQuery("insert into com.delhiguru.misc.Address (street, city, state, zipcode) VALUES('Rajendar Nagar', 'Allabhad', 'UP', 775756)");
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
