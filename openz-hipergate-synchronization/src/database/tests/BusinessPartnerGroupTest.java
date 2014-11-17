package database.tests;

import static org.junit.Assert.assertTrue;

import java.util.List;
import java.util.UUID;

import org.junit.Test;

import pojo.BusinessPartnerGroup;
import database.BusinessPartnerGroupUtil;

public class BusinessPartnerGroupTest {
	
	@Test
	public void getBrancheByIDTest(){
		BusinessPartnerGroup branche = BusinessPartnerGroupUtil.getGroup("79271736C3474B3AB0F21668B7828A00");
		System.out.println(branche);
		assertTrue(branche.getName().equals("Mitarbeiter"));
	}
	
	@Test
	public void getAllBranchen(){
		List<BusinessPartnerGroup> branchen = BusinessPartnerGroupUtil.getAllGroups();
		System.out.println(branchen);
		assertTrue(branchen.size() == 3);
	}

}
