package com.delhiguru.interceptor;

import java.sql.Connection;
import java.util.Date;

import org.hibernate.Session;

/**
 * This is helper class to log into database.
 * 
 * @author ranjeet
 *
 */
public class AuditLogUtil {

	public static void LogIt(String action,	Auditable entity, Connection conn ){
			
			Session tempSession = HibernateUtil.getSessionFactory().openSession(conn);
				
			try {
				AuditLog auditRecord = new AuditLog(action, entity.getLogDeatil()
						, new Date(), entity.getEntityId(), entity.getClass().toString());
				tempSession.save(auditRecord);
				tempSession.flush();
				
			} finally {	
				tempSession.close();
				
			}
				
		}
}
