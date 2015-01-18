package io.database;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import pojo.BusinessPartnerGroup;

/**
 * Utility class for some interactions with Business Partner Groups from OpenZ.
 * 
 * @author HAWAI
 *
 */
public class BusinessPartnerGroupUtil {

	/**
	 * Retrieves the Business Partner Group by ID.
	 * 
	 * @param id
	 *            The ID of the Business Partner Group, which shall be
	 *            retrieved.
	 * @return Business Partner Group with the specified ID.
	 */
	public static BusinessPartnerGroup getBusinessPartnerGroup(String id) {
		EntityManager em = EntityManagerUtil.getEntityManager();
		TypedQuery<BusinessPartnerGroup> query = em.createNamedQuery(
				BusinessPartnerGroup.FIND_BUSINESSPARTNERGROUP_BY_ID,
				BusinessPartnerGroup.class);
		System.out.println("Query" + query);
		query.setParameter(BusinessPartnerGroup.PARAM_ID, id);
		BusinessPartnerGroup bpg = query.getSingleResult();
		em.close();
		return bpg;
	}

	/**
	 * Retrieves a list with all Business Partner Groups.
	 * 
	 * @return List with all Business Partner Groups.
	 */
	public static List<BusinessPartnerGroup> getAllBusinessPartnerGroups() {
		EntityManager em = EntityManagerUtil.getEntityManager();
		TypedQuery<BusinessPartnerGroup> query = em.createNamedQuery(
				BusinessPartnerGroup.FIND_ALL_BUSINESSPARTNERGROUPS,
				BusinessPartnerGroup.class);
		List<BusinessPartnerGroup> listBpg = query.getResultList();
		em.close();
		return listBpg;
	}

	/**
	 * Retrieves a list with all Business Partner Group where the name is like /
	 * contains the specified string.
	 * 
	 * @param name
	 *            Name to search for.
	 * @return List with Business Partner Groups with that specified name.
	 */
	public static List<BusinessPartnerGroup> getAllBusinessPartnerGroupsByName(
			String name) {
		EntityManager em = EntityManagerUtil.getEntityManager();
		TypedQuery<BusinessPartnerGroup> query = em.createNamedQuery(
				BusinessPartnerGroup.FIND_ALL_BUSINESSPARTNERGROUPS,
				BusinessPartnerGroup.class);
		List<BusinessPartnerGroup> listBpg = query.getResultList();
		em.close();
		return listBpg;
	}

	/**
	 * Method to persist a BusinessPartnerGroup. Persists new or updated
	 * BusinessPartnerGroup.
	 * 
	 * @param bpg
	 *            BusinessPartnerGroup which shall be persisted.
	 */
	public static void persistBusinessPartnerGroup(BusinessPartnerGroup bpg) {
		EntityManager em = EntityManagerUtil.getEntityManager();
		em.persist(bpg);
		em.getTransaction().commit();
		em.close();
	}

}
