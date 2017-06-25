package com.delhiguru.interceptor;

import java.util.Date;

public class AuditLog {

	private Long auditLogId;
	private String action;
	private String detail;
	private Date createdDate;
	private long entityId;
	private String entityName;

	public AuditLog() {
	}
	
	public AuditLog(String action, String logDetails,  Date createdAt, long entityId, String entityName) {
		this.action = action;
		this.detail = logDetails;
		this.createdDate = createdAt;
		this.entityId = entityId;
		this.entityName = entityName;
	}
	
	/**
	 * @return the auditLogId
	 */
	public Long getAuditLogId() {
		return auditLogId;
	}

	/**
	 * @param auditLogId
	 *            the auditLogId to set
	 */
	public void setAuditLogId(Long auditLogId) {
		this.auditLogId = auditLogId;
	}

	/**
	 * @return the action
	 */
	public String getAction() {
		return action;
	}

	/**
	 * @param action
	 *            the action to set
	 */
	public void setAction(String action) {
		this.action = action;
	}

	/**
	 * @return the detail
	 */
	public String getDetail() {
		return detail;
	}

	/**
	 * @param detail
	 *            the detail to set
	 */
	public void setDetail(String detail) {
		this.detail = detail;
	}

	/**
	 * @return the createdDate
	 */
	public Date getCreatedDate() {
		return createdDate;
	}

	/**
	 * @param createdDate
	 *            the createdDate to set
	 */
	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}

	/**
	 * @return the entityId
	 */
	public long getEntityId() {
		return entityId;
	}

	/**
	 * @param entityId
	 *            the entityId to set
	 */
	public void setEntityId(long entityId) {
		this.entityId = entityId;
	}

	/**
	 * @return the entityName
	 */
	public String getEntityName() {
		return entityName;
	}

	/**
	 * @param entityName
	 *            the entityName to set
	 */
	public void setEntityName(String entityName) {
		this.entityName = entityName;
	}

}
