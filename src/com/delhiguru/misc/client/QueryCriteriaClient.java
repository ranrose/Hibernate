package com.delhiguru.misc.client;

import java.util.Date;
import java.util.Iterator;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;

import com.delhiguru.misc.Employee;
import com.delhiguru.util.HibernateUtil;

public class QueryCriteriaClient {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		QueryCriteriaClient client = new QueryCriteriaClient();
		Integer totalSal = client.totalSalary();
		System.out.println("total sal of all employee : " + totalSal);
		
		client.addEmployee("tanvi", "kanchan", 2000, new Date());
		
		Integer count = client.countEmployee();
		System.out.println("total count : " + count);
		
		client.listEmployees();
		
	}

	 public Integer totalSalary(){
		 Session session=HibernateUtil.getSessionFactory().openSession();
		Transaction transaction=null;
		Integer totalSal = null;
	      try{
	    	  transaction = session.beginTransaction();
	         Criteria cr = session.createCriteria(Employee.class);

	         // To get total salary.
	         cr.setProjection(Projections.sum("salary"));
	         List totalSalary = cr.list();
	         totalSal = (Integer)totalSalary.get(0);
	         System.out.println("Total Salary: " + totalSal );
	         transaction.commit();
	      }catch (HibernateException e) {
	         if (transaction!=null) transaction.rollback();
	         e.printStackTrace(); 
	      }finally {
	         session.close(); 
	      }
	      return totalSal;
	   }
	
	
	public Integer countEmployee(){
		Session session=HibernateUtil.getSessionFactory().openSession();
		Transaction transaction=null;
		Integer count = null;
		try{
			transaction=session.beginTransaction();
			Criteria criteria=session.createCriteria(Employee.class);
			criteria.setProjection(Projections.rowCount());
			List rowcount=criteria.list();
			count = (Integer)rowcount.get(0);
			System.out.println("Total Coint: "+rowcount.get(0));
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
		return count;
	}
	
	
	public void listEmployees(){
		Session session=HibernateUtil.getSessionFactory().openSession();
		Transaction transaction=null;
		try{
			transaction=session.beginTransaction();
			Criteria criteria=session.createCriteria(Employee.class);
			// Add restriction.
			criteria.add(Restrictions.gt("salary", 2000));
			
			List employees=criteria.list();
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
	
	public Integer addEmployee(String fname,String lname,int salary, Date dob){
		Session session=HibernateUtil.getSessionFactory().openSession();
		Transaction transaction=null;
		Integer employeeID=null;
		try{
			transaction=session.beginTransaction();
			Employee employee=new Employee(fname, lname, salary, dob);
			employeeID=(Integer)session.save(employee);
			transaction.commit();
		}
		catch(HibernateException e){
			if(transaction!=null){
				transaction.rollback();
			}
			e.printStackTrace();
		}
		finally{
			session.close();
		}
		return employeeID;
	}
}
