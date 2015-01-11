package io.xml;

import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.io.xml.DomDriver;

/**
 * Utility class for providing Business Partner Groups as XML strings.
 * 
 * @author HAWAI
 *
 */
public class BusinessPartnerGroupXML {

	/**
	 * Retrieves all Business Partner Groups as XML string.
	 * 
	 * @return XML string with all Business Partner Groups.
	 */
	public static String getAllBusinessPartnerGroups() {
		XStream xstream = new XStream(new DomDriver());
		// xstream.alias("billNumber", String.class);
		return xstream.toXML(io.database.BusinessPartnerGroupUtil
				.getAllBusinessPartnerGroups());
	}

	/**
	 * Retrieves a Business Partner Group as XML string.
	 * 
	 * @param id
	 *            ID of the Business Partner Group, which shall be retrieved as
	 *            XML string.
	 * @return XML string with the Business partner Group.
	 */
	public static String getBusinessPartnerGroupByID(String id) {
		XStream xstream = new XStream(new DomDriver());
		// xstream.alias("billNumber", String.class);
		return xstream.toXML(io.database.BusinessPartnerGroupUtil
				.getBusinessPartnerGroup(id));
	}

}
