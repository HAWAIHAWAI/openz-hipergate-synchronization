package io.xml;

import java.util.ArrayList;
import java.util.List;



import pojo.BusinessPartner;

import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.io.xml.DomDriver;

public class BusinessPartnerXML {
	
	public static String getBusinessPartnerByID(String id){
	XStream xstream = new XStream(new DomDriver());
	//xstream.alias("billNumber", String.class);
	return xstream.toXML(io.database.BusinessPartnerUtil.getBusinessPartner(id));
	}

	public static String getAllBusinessPartners() {
		XStream xstream = new XStream(new DomDriver());
		//xstream.alias("billNumber", String.class);
		return xstream.toXML(io.database.BusinessPartnerUtil.getAllBusinessPartners());
	}
}
