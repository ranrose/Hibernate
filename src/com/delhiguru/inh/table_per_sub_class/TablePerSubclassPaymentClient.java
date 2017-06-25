/**
 * 
 */
package com.delhiguru.inh.table_per_sub_class;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

/**
 * In the mapping file,  <key –> element is because,  once we save the derived class object,
 * then hibernate will first save the baseclass object then derived class object right ..!, 
 * so at the time of saving the derived class object hibernate will copy the primary key value 
 * of the base class into the corresponding derived class, see in the above output 10 copied 
 * into dummy1 column of CreditCard table and 11 copied into Dummy2 column of the cheque table
 * @author Ranjeet.Jha
 *
 */
public class TablePerSubclassPaymentClient {
	
	public static void main(String[] args) {
		
		Configuration cfg = new Configuration();
        cfg.configure("hibernate.cfg.xml");
 
        SessionFactory factory = cfg.buildSessionFactory();
        Session session = factory.openSession();
		 
        // Create CreditCardPayment Object set values to persist into database
        CreditCardPayment c = new CreditCardPayment();
        c.setId(10);
        c.setAmount(2500);
        c.setCreditCardType("Visa");
 
        // Create ChequePayment Object set values to persist into database
        ChequePayment c1=new ChequePayment();
        c1.setId(11);
        c1.setAmount(2600);
        c1.setChequeType("ICICI");
 
        Transaction tx = session.beginTransaction();
        session.save(c);
        session.save(c1);
        System.out.println("Payment Object saved successfully.....!!");
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
