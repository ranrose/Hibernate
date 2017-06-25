package com.delhiguru.inh.table_per_concrete_class;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

/**
 * Table per concrete class.
 * 
 * @author Ranjeet.Jha
 *
 */
public class TablePerConcreteclassPaymentClient {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		// TODO Auto-generated method stub
		Configuration cfg = new Configuration();
        cfg.configure("hibernate.cfg.xml");
 
        SessionFactory factory = cfg.buildSessionFactory();
        Session session = factory.openSession();
		 
        CreditCardPayment c = new CreditCardPayment();
        c.setId(10);
        c.setAmount(2500);
        c.setCreditCardType("Visa");
 
        ChequePayment c1=new ChequePayment();
        c1.setId(11);
        c1.setAmount(2600);
        c1.setChequeType("ICICI");
 
        Transaction tx = session.beginTransaction();
        session.save(c);
        session.save(c1);
        System.out.println("Object saved successfully.....!!");
        tx.commit();
        session.close();
        factory.close();

        /* console output
         Hibernate: insert into payments_2 (amount) values (?)
		 Hibernate: insert into payment_creditcard_2 (cctype, cc_payment_id) values (?, ?)
		 Hibernate: insert into payments_2 (amount) values (?)
		 Hibernate: insert into payment_cheque_2 (cheque_type, cheque_payment_id) values (?, ?)
         */
	}

}
