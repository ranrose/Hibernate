package com.delhiguru.inh.table_per_sub_class;

import java.io.Serializable;

/**
 * This class is used as Domain model for Payment entity. 
 * This is the base class for the payment inheritance for table per sub class.
 * 
 * @author ranjeet
 *
 */
public class Payment implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -7607495213848618782L;
	
	private long id;
	private double amount;

	/**
	 * @return the id
	 */
	public long getId() {
		return id;
	}

	/**
	 * @param id
	 *            the id to set
	 */
	public void setId(long id) {
		this.id = id;
	}

	/**
	 * @return the amount
	 */
	public double getAmount() {
		return amount;
	}

	/**
	 * @param amount
	 *            the amount to set
	 */
	public void setAmount(double amount) {
		this.amount = amount;
	}

}
