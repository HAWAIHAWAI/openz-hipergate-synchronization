package database.tests;

import static org.junit.Assert.assertTrue;

import java.util.List;

import org.junit.Test;

import pojo.BusinessPartnerGroup;
import pojo.BusinessPartner;
import database.BusinessPartnerGroupUtil;
import database.BusinessPartnerUtil;

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

}
