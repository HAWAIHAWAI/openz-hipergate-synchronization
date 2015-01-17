package io.database.tests;

import static org.junit.Assert.assertTrue;
import io.database.BusinessPartnerGroupUtil;

import java.util.List;

import org.junit.Test;

import pojo.BusinessPartnerGroup;

/**
 * Testing methods of the class BusinessParterGroup.
 * 
 * @author HAWAI
 *
 */
public class BusinessPartnerGroupTest {
	
	/**
	 * Test for retrieving a single BusinessPartnerGroup via ID and checking its sector.
	 */
	@Test
	public void getBrancheByIDTest(){
		BusinessPartnerGroup branche = BusinessPartnerGroupUtil.getBusinessPartnerGroup("79271736C3474B3AB0F21668B7828A00");
		System.out.println(branche);
		assertTrue(branche.getName().equals("Mitarbeiter"));
	}
	
	/**
	 * Test for getting all sectors in the DB.
	 * May fail due the possibility of more than three sectors.
	 */
	@Test
	public void getAllBranchen(){
		List<BusinessPartnerGroup> branchen = BusinessPartnerGroupUtil.getAllBusinessPartnerGroups();
		System.out.println(branchen);
		assertTrue(branchen.size() == 3);
	}

}
