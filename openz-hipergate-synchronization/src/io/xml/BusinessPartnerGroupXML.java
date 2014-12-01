package io.xml;

import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.io.xml.DomDriver;

public class BusinessPartnerGroupXML {

	public static String getAllBusinessPartnerGroups() {
		XStream xstream = new XStream(new DomDriver());
		//xstream.alias("billNumber", String.class);
		return xstream.toXML(io.database.BusinessPartnerGroupUtil.getAllBusinessPartnerGroups());
	}

	public static String getBusinessPartnerGroupByID(String id) {
		XStream xstream = new XStream(new DomDriver());
		//xstream.alias("billNumber", String.class);
		return xstream.toXML(io.database.BusinessPartnerGroupUtil.getBusinessPartnerGroup(id));
	}

}
