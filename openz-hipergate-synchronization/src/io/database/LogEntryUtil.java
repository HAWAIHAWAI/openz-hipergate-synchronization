package io.database;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import pojo.LogEntry;

/**
 * Utility class for the LogEntry class in the package pogo.
 * @author HAWAI
 *
 */
public class LogEntryUtil {
	
	/**
	 * Delivers all LogEntry records from the DB as objects.
	 * @return List of all LogEntry records as LogEntry objects.
	 */
	public static List<LogEntry> getAllLogEntries() {
		EntityManager em = EntityManagerUtil.getEntityManager();
		TypedQuery<LogEntry> query = em.createNamedQuery(
				LogEntry.FIND_ALL_LOGENTRIES, LogEntry.class);
		List<LogEntry> list = query.getResultList();
		em.close();
		return list;
	}

	/**
	 * Method to persist a LogEntry object as a record in the DB.
	 * @param logEntry LogEntry object to persist.
	 */
	public static void persistLogEntry(LogEntry logEntry) {
		EntityManager em = EntityManagerUtil.getEntityManager();
		em.persist(logEntry);
		em.getTransaction().commit();
		em.close();
	}
}
