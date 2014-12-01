package io.database;

import java.util.List;
import java.util.UUID;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import pojo.BusinessPartnerGroup;

public class BusinessPartnerGroupUtil {
	public static BusinessPartnerGroup getBusinessPartnerGroup(String id){
		EntityManager em = EntityManagerUtil.getEntityManager();
		TypedQuery<BusinessPartnerGroup> query = em.createNamedQuery(BusinessPartnerGroup.FIND_BRANCHE_BY_ID, BusinessPartnerGroup.class);
		System.out.println("Query" + query);
		query.setParameter(BusinessPartnerGroup.PARAM_ID, id);
		
		return query.getSingleResult();
	}
	
	public static List<BusinessPartnerGroup> getAllBusinessPartnerGroups() {
		EntityManager em = EntityManagerUtil.getEntityManager();
		TypedQuery<BusinessPartnerGroup> query = em.createNamedQuery(BusinessPartnerGroup.FIND_ALL_BRANCHEN, BusinessPartnerGroup.class);
		return query.getResultList();
	}

}
