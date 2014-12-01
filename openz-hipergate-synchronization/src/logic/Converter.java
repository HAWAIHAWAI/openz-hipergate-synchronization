package logic;

import pojo.BusinessPartner;
import pojo.OpenZGeschaeftspartner;

public class Converter {
	
	private Converter(){}
	
	public static BusinessPartner convertToBusinessPartner(OpenZGeschaeftspartner obp){
		
		BusinessPartner bp = new BusinessPartner();
		bp.setID(obp.getId());
		//bp.addBpGroup();
		bp.setName(obp.getUnternehmensName());
		bp.setDescription(obp.getBeschreibung());
		bp.setTaxNumber(obp.getSteuernummer());
		return bp;
	}
	
	public static OpenZGeschaeftspartner convertToOpenZGeschaftspartner(BusinessPartner bp){
		OpenZGeschaeftspartner obp = new OpenZGeschaeftspartner();
		obp.setId(bp.getID());
		obp.setUnternehmensName(bp.getName());
		return obp;
	}

}
