package com.delhiguru.inh.table_per_class;

/**
 * @author ranjeetJha
 *
 */
public class CreditCardPayment extends Payment {

	
	private String creditCardType;
	
	//private String cardLastFourDigit;
	

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
