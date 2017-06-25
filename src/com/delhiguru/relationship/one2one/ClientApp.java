package com.delhiguru.relationship.one2one;

import java.util.Date;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class ClientApp {
	
	public static void main(String[] args) {
		System.out.println("Hibernate one to one (XML mapping) Example  ");
		Configuration cfg = new Configuration();
		cfg.configure("hibernate.cfg.xml");

		SessionFactory factory = cfg.buildSessionFactory();
		Session session = factory.openSession();
		session.beginTransaction();

		Stock stock = new Stock();

		stock.setStockCode("123");
		stock.setStockName("INF");

		StockDetail stockDetail = new StockDetail();
		stockDetail.setCompName("Infosys");
		stockDetail.setCompDesc("Leading Software Compmany In India");
		stockDetail.setRemark("Leading name");
		stockDetail.setListedDate(new Date());

		stock.setStockDetail(stockDetail);
		stockDetail.setStock(stock);

		session.save(stock);
		session.getTransaction().commit();

		System.out.println("Stock and StockDetail Object Saved succesfully...");

	}
}
