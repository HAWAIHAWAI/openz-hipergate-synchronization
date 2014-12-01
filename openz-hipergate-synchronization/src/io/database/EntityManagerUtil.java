package io.database;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 * @author cglaeser
 *
 */
public class EntityManagerUtil {

	/**
	 * @return A new EntityManager instance
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
