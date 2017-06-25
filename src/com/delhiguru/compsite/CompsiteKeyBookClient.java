package com.delhiguru.compsite;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.delhiguru.util.HibernateUtil;

public class CompsiteKeyBookClient {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Session session=HibernateUtil.getSessionFactory().openSession();
		Transaction transaction=null;
		try{
			transaction=session.beginTransaction();
			Book book=new Book();
			book.setBookId(1);
			book.setBookName("Hibernate Professional");
			book.setAuthor("wrox");
			book.setCategory("advance");
			book.setPrice(new Double("1234.78"));
			session.save(book);
			transaction.commit();
		}
		catch(HibernateException e){
			e.printStackTrace();
		}
		finally{
			session.close();
		}
		
	}

}
