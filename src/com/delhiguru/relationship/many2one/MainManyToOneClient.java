package com.delhiguru.relationship.many2one;

import org.hibernate.HibernateException;
import org.hibernate.Transaction;
import org.hibernate.classic.Session;

import com.delhiguru.util.HibernateUtil;

public class MainManyToOneClient {

	/**
	 * @param args
	 */
	/*Hibernate Mapping Many-to-One

	In this example you will learn how to map many-to-one relationship using Hibernate. Consider the following relationship
	between Student and Address entity.
	According to the relationship many students can have the same address.

	To create this relationship you need to have a STUDENT and ADDRESS table. The relational model is shown below. 
	
	The many-to-one element is used to create the many-to-one relationship between the Student and Address entities. 
	The cascade option is used to cascade the required operations to the associated entity. 
	If the cascade option is set to all then all the operations will be cascaded. For instance when you save a Student object,
	the associated Address object will also be saved automatically.*/
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Session session=HibernateUtil.getSessionFactory().openSession();
		Transaction transaction=null;
		try{
			transaction=session.beginTransaction();
			Address address=new Address("Dwarka", "New Delhi", "ND", "110045");
			//By using cascade=all option the address need not be saved explicitly when the student object is persisted the address
			//will be automatically saved.
			//session.save(address);
			Student student1=new Student("Ashish", address);
			Student student2=new Student("Ranjeet", address);
			session.save(student1);
			session.save(student2);
			transaction.commit();
		}
		catch(HibernateException e){
			transaction.rollback();
			e.printStackTrace();
		}
		finally{
			session.close();
		}
		
	}

}
