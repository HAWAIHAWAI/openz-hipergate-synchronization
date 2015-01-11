package io.xml;

import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.io.xml.DomDriver;

/**
 * Utility class for providing Business Partners as XML strings.
 * 
 * @author HAWAI
 *
 */
public class BusinessPartnerXML {
	
	/**
	 * Retrieves a Business Partner Group as XML string.
	 * 
	 * @param id
	 *            ID of the Business Partner Group, which shall be retrieved as
	 *            XML string.
	 * @return XML string with the Business partner Group.
	 */
	public static String getBusinessPartnerByID(String id){
	XStream xstream = new XStream(new DomDriver());
	//xstream.alias("billNumber", String.class);
	return xstream.toXML(io.database.BusinessPartnerUtil.getBusinessPartner(id));
	}

	/**
	 * Retrieves all Business Partners as XML string.
	 * 
	 * @return XML string with all Business Partners.
	 */
	public static String getAllBusinessPartners() {
		XStream xstream = new XStream(new DomDriver());
		//xstream.alias("billNumber", String.class);
		return xstream.toXML(io.database.BusinessPartnerUtil.getAllBusinessPartners());
	}
}
