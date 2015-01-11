package io.database;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 * Utility-class to get Entitiy Managers for persistence purposes.
 * 
 * @author Christian Gläser
 *
 */
public class EntityManagerUtil {

	/**
	 * Provides an Entity Manager for persistence context.
	 * 
	 * @return Entity Manager for perstistence context.
	 */
	public static EntityManager getEntityManager() {
		System.out.println("/**Entity Manager creation started**/");
		try{
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("openz-hipergate-synchronization");
		EntityManager em = emf.createEntityManager();
		System.out.println("em.getProperties(): " + em.getProperties());
		em.getTransaction().begin();
		System.out.println("Entity Manager Transaction started");
		System.out.println("/**Entity Manager creation finished**/");
		return em;
		}
		catch(javax.persistence.PersistenceException ex){
			System.err.println("Error thrown in EntityManagerUtil, reason:" + ex);
			throw ex;
		}
		
	}
}
