package io.database;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import pojo.LogEntry;


public class LogEntryUtil {
	
	public static List<LogEntry> getAllLogEntries() {
		EntityManager em = EntityManagerUtil.getEntityManager();
		TypedQuery<LogEntry> query = em.createNamedQuery(
				LogEntry.FIND_ALL_LOGENTRIES, LogEntry.class);
		List<LogEntry> list = query.getResultList();
		em.close();
		return list;
	}

	public static void persistLogEntry(LogEntry logEntry) {
		EntityManager em = EntityManagerUtil.getEntityManager();
		em.persist(logEntry);
		em.getTransaction().commit();
		em.close();
	}
}
