package database;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import pojo.BusinessPartner;

public class BusinessPartnerUtil {
	
	public static BusinessPartner getBusinessPartner(String id){
		EntityManager em = EntityManagerUtil.getEntityManager();
		TypedQuery<BusinessPartner> query = em.createNamedQuery(BusinessPartner.FIND_BP_BY_ID, BusinessPartner.class);
		System.out.println("Query" + query);
		query.setParameter(BusinessPartner.PARAM_ID, id);
		
		return query.getSingleResult();
	}
	
	public static List<BusinessPartner> getAllBusinessPartners(){
		EntityManager em = EntityManagerUtil.getEntityManager();
		TypedQuery<BusinessPartner> query = em.createNamedQuery(BusinessPartner.FIND_ALL_BP, BusinessPartner.class);
		return query.getResultList();
	}
	
	/**
	 * @param bp Persist new or updated BusinessPartner
	 */
	public static void persistBusinessPartner(BusinessPartner bp){
		EntityManager em = EntityManagerUtil.getEntityManager();
		em.persist(bp);
		em.getTransaction().commit();
	}
	
	/**
	 * @param bp Remove businessPartner from persistence context
	 */
	public static void removeBusinessPartner(BusinessPartner bp){
		EntityManager em = EntityManagerUtil.getEntityManager();
		em.remove(bp);
		em.getTransaction().commit();
	}
}
