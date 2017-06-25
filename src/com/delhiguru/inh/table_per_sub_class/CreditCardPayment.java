package com.delhiguru.inh.table_per_sub_class;

public class CreditCardPayment extends Payment {
	
	private String creditCardType;
	
	/* id and amount properties in the base class so no need to generate their setter and getter over here. 
	 * Generate setter and getter of chequeType properties only. */
	

	/**
	 * @return the creditCardType
	 */
	public String getCreditCardType() {
		return creditCardType;
	}

	/**
	 * @param creditCardType the creditCardType to set
	 */
	public void setCreditCardType(String creditCardType) {
		this.creditCardType = creditCardType;
	}

	
}
