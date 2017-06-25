package com.delhiguru.inh.table_per_sub_class;

/**
 * This class is used as domain model class for Cheque Payment.
 * 
 * @author ranjeetJha
 *
 */
public class ChequePayment extends Payment{

	private String chequeType;
	
	/* id and amount properties in the base class so no need to generate their setter and getter over here. 
	 * Generate setter and getter of chequeType properties only. */
	
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
