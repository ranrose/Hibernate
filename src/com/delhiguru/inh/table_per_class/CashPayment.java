package com.delhiguru.inh.table_per_class;

/**
 * @author ranjeet.jha@gmail.com
 *
 */
public class CashPayment extends Payment {

		
	// property for cachPayment only
	private String cashDetails;

	/**
	 * @return the cashDetails
	 */
	public String getCashDetails() {
		return cashDetails;
	}

	/**
	 * @param cashDetails the cashDetails to set
	 */
	public void setCashDetails(String cashDetails) {
		this.cashDetails = cashDetails;
	}
	
}
