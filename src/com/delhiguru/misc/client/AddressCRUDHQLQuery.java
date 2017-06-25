package com.delhiguru.misc.client;

import java.util.Iterator;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.delhiguru.misc.Address;
import com.delhiguru.misc.Student;
import com.delhiguru.util.HibernateUtil;

public class AddressCRUDHQLQuery {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		AddressCRUDHQLQuery client = new AddressCRUDHQLQuery();
		long addressId = 1;
		
		// Get Select Query Sample
		client.getAddressByHQLSelectQuery(addressId);

				
		// Get Update Query Sample
		/*int updateCount = client.updateAddressByHQLUpdateQuery(addressId);
		if(updateCount != -1) {
			System.out.println("record updated  count : " + updateCount);
		}*/
		
		// Insert HQL Query Sample
		/*int insertCount = client.addAddressByHQLInsertQuery();
		System.out.println("insert address Count : " + insertCount);*/
		
		// Get Delete Query Sample
		/*int deleteCount = client.deleteAddressByHQLDeleteQuery(addressId);
		System.out.println("delete count : " + deleteCount);*/

	}

	public int updateAddressByHQLUpdateQuery(long addressId){
		int result=-1;
		Session session=HibernateUtil.getSessionFactory().openSession();
		Transaction transaction=null;
		try{
			transaction=session.beginTransaction();
			Query query=session.createQuery("update Address set street=:streetName"+ " where addressId=:addressId");
			query.setParameter("streetName", "R K puram Gwalior");
			query.setParameter("addressId", addressId);
			result=query.executeUpdate();
			transaction.commit();
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
	public int deleteAddressByHQLDeleteQuery(long addressId){
		int result=-1;
		Session session=HibernateUtil.getSessionFactory().openSession();
		Transaction transaction=null;
		try{
			transaction=session.beginTransaction();
			Query query=session.createQuery("Delete from Address where addressId=:addressID");
			query.setParameter("addressID", addressId);
			result=query.executeUpdate();
			transaction.commit();
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
	public int addAddressByHQLInsertQuery(){
		int result=-1;
		Session session=HibernateUtil.getSessionFactory().openSession();
		Transaction transaction=null;
		try{
			transaction=session.beginTransaction();
			Query query=session.createQuery("insert into Address(street, city, state, zipcode) values('Bindapur Dwarka','New Delhi','Delhi',110059)");
			result=query.executeUpdate();
			transaction.commit();
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
	
	public void getAddressByHQLSelectQuery(long addressId) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		try {
			session.beginTransaction();
			Query query = session.createQuery("from Address as a where a.addressId=:id");
			query.setLong("id", addressId);
			List<Address> addresses = query.list();
			for (Address address : addresses) {
				System.out.println("city  : " + address.getCity());
			}

		} catch (HibernateException e) {
			e.printStackTrace();
		} finally {
			session.close();
		}

	}
	
	public void getStudentByHQLSelectQuery(long studentId){
		Session session=HibernateUtil.getSessionFactory().openSession();
		Transaction transaction=null;
		try{
			transaction=session.beginTransaction();
			Query query= session.createQuery("from Student where studentId=:id");
			query.setParameter("id", studentId);
			//List list = session.createQuery("from Student where studentId=2").list() ;
			for (Iterator it = query.iterate(); it.hasNext();) {  
				Student stud = (Student) it.next();  
				System.out.println("Name: " + stud.getStudentName());  
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
