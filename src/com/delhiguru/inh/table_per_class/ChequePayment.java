package com.delhiguru.inh.table_per_class;

public class ChequePayment extends Payment{



	/*private long id;
	private double amount;*/

	private String chequeType;
	 
	/**
	 * @return the chequeType
	 */
	public String getChequeType() {
		return chequeType;
	}

	/**
	 * @param chequeType the chequeType to set
	 */
	public void setChequeType(String chequeType) {
		this.chequeType = chequeType;
	}
	

}
