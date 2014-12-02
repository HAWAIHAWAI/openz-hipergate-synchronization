package io.database;

import java.util.List;
import java.util.UUID;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import pojo.BusinessPartner;
import pojo.BusinessPartnerGroup;

public class BusinessPartnerGroupUtil {
	public static BusinessPartnerGroup getBusinessPartnerGroup(String id){
		EntityManager em = EntityManagerUtil.getEntityManager();
		TypedQuery<BusinessPartnerGroup> query = em.createNamedQuery(BusinessPartnerGroup.FIND_BUSINESSPARTNERGROUP_BY_ID, BusinessPartnerGroup.class);
		System.out.println("Query" + query);
		query.setParameter(BusinessPartnerGroup.PARAM_ID, id);
		
		return query.getSingleResult();
	}
	
	public static List<BusinessPartnerGroup> getAllBusinessPartnerGroups() {
		EntityManager em = EntityManagerUtil.getEntityManager();
		TypedQuery<BusinessPartnerGroup> query = em.createNamedQuery(BusinessPartnerGroup.FIND_ALL_BUSINESSPARTNERGROUPS, BusinessPartnerGroup.class);
		return query.getResultList();
	}
	
	public static List<BusinessPartnerGroup> getAllBusinessPartnerGroupsByName(
			String string) {
		EntityManager em = EntityManagerUtil.getEntityManager();
		TypedQuery<BusinessPartnerGroup> query = em.createNamedQuery(BusinessPartnerGroup.FIND_ALL_BUSINESSPARTNERGROUPS, BusinessPartnerGroup.class);
		return query.getResultList();
	}
	
	/**
	 * @param bp Persist new or updated BusinessPartnerGroup
	 */
	public static void persistBusinessPartnerGroup(BusinessPartnerGroup bpg){
		EntityManager em = EntityManagerUtil.getEntityManager();
		em.persist(bpg);
		em.getTransaction().commit();
	}

}
