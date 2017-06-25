package com.delhiguru.inh.tpcc;

import org.hibernate.*;
import org.hibernate.cfg.*;

public class EmployeeClient {
	public static void main(String[] args) {
		Session session = new Configuration().configure("hibernate.cfg.xml").buildSessionFactory().openSession();

		Transaction t = session.beginTransaction();

		Employee e1 = new Employee();
		e1.setName("Rakeshs Jha");

		RegularEmployee e2 = new RegularEmployee();
		e2.setName("Ranjeet");
		e2.setSalary(50000);
		e2.setBonus(5);

		ContractEmployee e3 = new ContractEmployee();
		e3.setName("Mukesh Kumar");
		e3.setPay_per_hour(1000);
		e3.setContract_duration("11 hours");

		session.persist(e1);
		session.persist(e2);
		session.persist(e3);

		t.commit();
		session.close();
		System.out.println("Employee Object successfully saved!!!");
	}
}
