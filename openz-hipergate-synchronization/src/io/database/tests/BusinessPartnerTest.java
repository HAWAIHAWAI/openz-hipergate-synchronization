package io.database.tests;

import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertEquals;
import io.database.BusinessPartnerGroupUtil;
import io.database.BusinessPartnerUtil;

import java.util.List;

import org.junit.Test;

import pojo.BusinessPartnerGroup;
import pojo.BusinessPartner;

public class BusinessPartnerTest {
	
	@Test
	public void getBusinessPartnerByIDTest(){
		BusinessPartner bp = BusinessPartnerUtil.getBusinessPartner("9BA8035EEBA84F9A8793FF1F76B52EC6");
		System.out.println(bp);
		assertTrue(bp.getName().equals("Lederfabrik Hannes GmbH"));
	}
	
	@Test
	public void getAllBusinessPartners(){
		List<BusinessPartner> bpl = BusinessPartnerUtil.getAllBusinessPartners();
		System.out.println(bpl);
	}
	
	@Test
	public void getAllBusinessPartnersWithNameTest(){
		String name = "Lederfabrik Hannes GmbH";
		List<BusinessPartner> bpl = BusinessPartnerUtil.getAllBusinessPartnersWithName(name);
		System.err.println(bpl);
		assertTrue(bpl.size()==1);
		assertEquals(bpl.get(0).getName(),name);
	}
	
	@Test
	public void addBusinessPartner(){
		BusinessPartner bp = new BusinessPartner();
		bp.setName("TestpartnerDatabase");
		bp.setTaxNumber("somerandomstring");
		bp.setBpGroup(BusinessPartnerGroupUtil.getAllBusinessPartnerGroupsByName("Lieferanten").get(0));
		bp.persist();
		
		BusinessPartner bp2 = BusinessPartnerUtil.getAllBusinessPartnersWithName("TestpartnerDatabase").get(0);
		assertEquals(bp.getName(),bp2.getName());
		
		BusinessPartnerUtil.removeBusinessPartner(bp2);
	}
	
	@Test
	public void removeBusinessPartnerTest(){
		BusinessPartner bp = new BusinessPartner();
		bp.setName("TestpartnerDatabase");
		bp.setTaxNumber("somerandomstring");
		bp.setBpGroup(BusinessPartnerGroupUtil.getAllBusinessPartnerGroupsByName("Lieferanten").get(0));
		bp.persist();
		String id = bp.getID();
		System.out.println("BusinessPartner to be removed: " + bp);
		
		BusinessPartnerUtil.removeBusinessPartner(bp);
		
		System.out.println("BP after removal" + BusinessPartnerUtil.getBusinessPartner(id));
	}

}
