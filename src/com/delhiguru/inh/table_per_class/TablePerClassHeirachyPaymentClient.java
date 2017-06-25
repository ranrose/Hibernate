/**
 * 
 */
package com.delhiguru.inh.table_per_class;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

/**
 * @author RanjeetJha
 * 
 */
public class TablePerClassHeirachyPaymentClient {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Configuration cfg = new Configuration();
		cfg.configure("hibernate.cfg.xml");
		SessionFactory factory = cfg.buildSessionFactory();
		Session session = factory.openSession();
		
		// Create CreditCardPayment Object set values to persist into database
		CreditCardPayment creditCard = new CreditCardPayment();
		creditCard.setId(10);
		creditCard.setAmount(2500);
		creditCard.setCreditCardType("Visa");

		// Create ChequePayment Object set values to persist into database
		ChequePayment chequePayment = new ChequePayment();
		chequePayment.setId(11);
		chequePayment.setAmount(2600);
		chequePayment.setChequeType("ICICI");

		// Create CashPayment Object set values to persist into database
		CashPayment cashPayment = new CashPayment();
		cashPayment.setId(11);
		cashPayment.setAmount(2600);
		cashPayment.setCashDetails("Paid By Anushka");
		
		Transaction tx = session.beginTransaction();
		session.save(creditCard);
		session.save(chequePayment);
		session.save(cashPayment);
		
		System.out.println("Payment Object saved successfully.....!!");
		tx.commit();
		session.close();
		factory.close();

	}

}
