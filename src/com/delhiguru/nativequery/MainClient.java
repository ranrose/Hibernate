package com.delhiguru.nativequery;

import java.util.Iterator;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.delhiguru.misc.Employee;
import com.delhiguru.util.HibernateUtil;

public class MainClient {

	/**
	 * before run uncomment Employee and Department hbm.xml in hibernate.cfg.xml
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		MainClient client = new MainClient();
		client.getNativeQuery();
		
	}
	
	public void getNativeQuery(){
		Session session=HibernateUtil.getSessionFactory().openSession();
		Transaction transaction=null;
		try{
			transaction=session.beginTransaction();
			String sql = "SELECT * FROM EMPLOYEE WHERE id = :employee_id";
			SQLQuery query = session.createSQLQuery(sql);
			query.addEntity(Employee.class);
			query.setParameter("employee_id", 6);
			List employees = query.list();
			for(Iterator iterator=employees.iterator();iterator.hasNext();){
				Employee employee=(Employee)iterator.next();
				System.out.println("Employee Name--------"+employee.getFirstName());
				System.out.println("  Last Name--------"+employee.getLastName());
				System.out.println("	Salary--------"+employee.getSalary());
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
