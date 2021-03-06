package io.database.tests;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import io.database.BusinessPartnerGroupUtil;
import io.database.BusinessPartnerUtil;

import java.util.List;

import org.junit.Test;

import pojo.BusinessPartner;

/**
 * Class for testing methods of the class BusinessPartnerUtil.
 * 
 * @author HAWAI
 *
 */
public class BusinessPartnerTest {

	/**
	 * Test for retrieving a single BusinessPartner via ID.
	 */
	@Test
	public void getBusinessPartnerByIDTest() {
		BusinessPartner bp = BusinessPartnerUtil
				.getBusinessPartner("9BA8035EEBA84F9A8793FF1F76B52EC6");
		System.out.println(bp);
		assertTrue(bp.getName().equals("Lederfabrik Hannes GmbH"));
	}

	/**
	 * Test for retrieving all BusinessPartners.
	 */
	@Test
	public void getAllBusinessPartners() {
		List<BusinessPartner> bpl = BusinessPartnerUtil
				.getAllBusinessPartners();
		System.out.println(bpl);
	}

	/**
	 * Test for retrieving BusinessPartners where the name is
	 * like the given String ("name").
	 */
	@Test
	public void getAllBusinessPartnersWithNameTest() {
		String name = "Lederfabrik Hannes GmbH";
		List<BusinessPartner> bpl = BusinessPartnerUtil
				.getAllBusinessPartnersWithName(name);
		System.err.println(bpl);
		assertTrue(bpl.size() == 1);
		assertEquals(bpl.get(0).getName(), name);
	}

	/**
	 * Test for adding a single BusinessPartner.
	 * May fail due DB-specific restrictions ( persist / merge
	 * behavior is different or not implemented (especially merge in Postgre) ).
	 * It might be possible to do an "UPSERT" instead of merge or persist.
	 */
	@Test
	public void addBusinessPartner() {
		BusinessPartner bp = new BusinessPartner();
		bp.setName("TestpartnerDatabase");
		bp.setTaxid("somerandomstring");
		bp.setBpGroup(BusinessPartnerGroupUtil
				.getAllBusinessPartnerGroupsByName("Lieferanten").get(0));
		bp.persist();

		BusinessPartner bp2 = BusinessPartnerUtil
				.getAllBusinessPartnersWithName("TestpartnerDatabase").get(0);
		assertEquals(bp.getName(), bp2.getName());

		BusinessPartnerUtil.removeBusinessPartner(bp2);
	}

	/**
	 * Test for removing a single BusinessParter.
	 * May fail due DB-specific restrictions ( persist / merge
	 * behavior is different or not implemented (especially merge in Postgre) ).
	 * It might be possible to do an "UPSERT" instead of merge or persist.
	 */
	@Test
	public void removeBusinessPartnerTest() {
		System.err.println("remove business partner started");
		BusinessPartner bp = new BusinessPartner();
		bp.setName("TestpartnerDatabase");
		bp.setTaxid("somerandomstring");
		bp.setBpGroup(BusinessPartnerGroupUtil
				.getAllBusinessPartnerGroupsByName("Lieferanten").get(0));
		bp.persist();
		System.err.println("BP after persisting: " + bp);
		String id = bp.getID();
		System.err.println("BusinessPartner to be removed: " + bp);

		BusinessPartnerUtil.removeBusinessPartner(bp);
		assertFalse(BusinessPartnerUtil.BusinessPartnerExists(id));
	}

}
