package io.database;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import pojo.BusinessPartner;

/**
 * Utility class for interactions with Business Partners from OpenZ.
 * 
 * @author HAWAI
 *
 */
public class BusinessPartnerUtil {

	/**
	 * Retrieves a Business Partner object by ID.
	 * @param id ID of the Business Partner
	 * @return Business Partner Object
	 */
	public static BusinessPartner getBusinessPartner(String id) {
		EntityManager em = EntityManagerUtil.getEntityManager();
		TypedQuery<BusinessPartner> query = em.createNamedQuery(
				BusinessPartner.FIND_BP_BY_ID, BusinessPartner.class);
		System.out.println("Query" + query);
		query.setParameter(BusinessPartner.PARAM_ID, id);

		return query.getSingleResult();
	}

	/**
	 * Retrieves a list with all Business Partners from OpenZ
	 * @return List with all Business Partners.
	 */
	public static List<BusinessPartner> getAllBusinessPartners() {
		EntityManager em = EntityManagerUtil.getEntityManager();
		TypedQuery<BusinessPartner> query = em.createNamedQuery(
				BusinessPartner.FIND_ALL_BP, BusinessPartner.class);
		return query.getResultList();
	}

	/**
	 * Method to persist a BusinessPartner. 
	 * Persists new or updated BusinessPartner.
	 * @param bp The Business Partner which shall be persisted.
	 *            
	 */
	public static void persistBusinessPartner(BusinessPartner bp) {
		EntityManager em = EntityManagerUtil.getEntityManager();
		em.persist(bp);
		em.getTransaction().commit();
	}

	/**
	 * Removes a Business Partner from persistence context.
	 * @param bp Business Partner to remove from persistence context.
	 */
	public static void removeBusinessPartner(BusinessPartner bp) {
		System.out
				.println("removeBusinessPartner in BusinessPartnerUtil started");
		EntityManager em = EntityManagerUtil.getEntityManager();
		TypedQuery<BusinessPartner> query = em.createNamedQuery(
				BusinessPartner.FIND_BP_BY_ID, BusinessPartner.class);
		query.setParameter(BusinessPartner.PARAM_ID, bp.getID());
		BusinessPartner removeBP = query.getSingleResult();
		System.err.println("Entity found: " + removeBP);
		em.remove(removeBP);
		em.getTransaction().commit();
		System.out
				.println("removeBusinessPartner in BusinessPartnerUtil ended");
	}

	/**
	 * Retrieves a list of all Business Partners where the name is like / contains the specified string.
	 * @param name Name to search for.
	 * @return List of Business Partners
	 */
	public static List<BusinessPartner> getAllBusinessPartnersWithName(
			String name) {
		EntityManager em = EntityManagerUtil.getEntityManager();
		TypedQuery<BusinessPartner> query = em.createNamedQuery(
				BusinessPartner.FIND_BP_BY_NAME, BusinessPartner.class);
		query.setParameter(BusinessPartner.PARAM_NAME, name);
		return query.getResultList();
	}

	/**
	 * Method to check if a Business Partner exists.
	 * @param id ID of the Business Partner. Required to check if a Business Partner with given ID exists.
	 * @return <cod>true</code> if Businesspartner with given id exists once, else false.
	 */
	public static boolean BusinessPartnerExists(String id) {
		EntityManager em = EntityManagerUtil.getEntityManager();
		TypedQuery<BusinessPartner> query = em.createNamedQuery(
				BusinessPartner.FIND_BP_BY_ID, BusinessPartner.class);
		System.out.println("Query" + query);
		query.setParameter(BusinessPartner.PARAM_ID, id);
		return (query.getResultList().size() == 1);
	}
}
