package com.delhiguru.misc;

import java.io.Serializable;
import java.util.Date;

public class Phone implements Serializable{

	private long phoneId;
	private String phoneType;
	private String phoneNumber;
	private Date activatedAt;
	private Date validTill;
	

	public Phone(String phoneType,String phoneNumber){
		this.phoneType=phoneType;
		this.phoneNumber=phoneNumber;
	}

	public long getPhoneId() {
		return phoneId;
	}

	public void setPhoneId(long phoneId) {
		this.phoneId = phoneId;
	}

	public String getPhoneType() {
		return phoneType;
	}

	public void setPhoneType(String phoneType) {
		this.phoneType = phoneType;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	
	/**
	 * @return the activatedAt
	 */
	public Date getActivatedAt() {
		return activatedAt;
	}

	/**
	 * @param activatedAt the activatedAt to set
	 */
	public void setActivatedAt(Date activatedAt) {
		this.activatedAt = activatedAt;
	}

	/**
	 * @return the validTill
	 */
	public Date getValidTill() {
		return validTill;
	}

	/**
	 * @param validTill the validTill to set
	 */
	public void setValidTill(Date validTill) {
		this.validTill = validTill;
	}
}
