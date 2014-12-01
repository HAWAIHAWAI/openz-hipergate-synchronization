package io.database.tests;

import static org.junit.Assert.assertTrue;
import io.database.BusinessPartnerGroupUtil;

import java.util.List;
import java.util.UUID;

import org.junit.Test;

import pojo.BusinessPartnerGroup;

public class BusinessPartnerGroupTest {
	
	@Test
	public void getBrancheByIDTest(){
		BusinessPartnerGroup branche = BusinessPartnerGroupUtil.getBusinessPartnerGroup("79271736C3474B3AB0F21668B7828A00");
		System.out.println(branche);
		assertTrue(branche.getName().equals("Mitarbeiter"));
	}
	
	@Test
	public void getAllBranchen(){
		List<BusinessPartnerGroup> branchen = BusinessPartnerGroupUtil.getAllBusinessPartnerGroups();
		System.out.println(branchen);
		assertTrue(branchen.size() == 3);
	}

}
