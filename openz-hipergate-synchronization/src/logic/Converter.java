package logic;

import io.database.BusinessPartnerGroupUtil;

import java.util.HashMap;
import java.util.Map;

import logic.exceptions.UnknownGroupException;

import org.apache.commons.collections4.BidiMap;
import org.apache.commons.collections4.bidimap.DualHashBidiMap;

import pojo.BusinessPartner;
import pojo.BusinessPartnerGroup;

import com.knowgate.hipergate.InformationsKomponente.OpenZGeschaeftspartner;

/**
 * Utility class providing methods for converting BusinessPartner to OpenZGeschaeftspartner and vice versa,
 * converting Hipergate Group to BusinessPartnerGroup and converting BusinessPartnerGroup to OpenZBusinessPartnerGroup.
 * @author HAWAI
 *
 */
public class Converter {
	
	/**
	 * private - no instantiation.
	 */
	private Converter(){}
	
	/**
	 * Method to convert an OpenZGeschaeftspartner to BusinessPartner.
	 * @param obp OpenZGeschaeftspartner which shall be converted to BusinessPartner
	 * @return BusinessPartner object with the details of the OpenZGeschaeftspartner.
	 * @throws UnknownGroupException If group specified is unknown.
	 */
	public static BusinessPartner convertToBusinessPartner(OpenZGeschaeftspartner obp) throws UnknownGroupException{
		
		BusinessPartner bp = new BusinessPartner();
		bp.setID(obp.getId());
		bp.setBpGroup(convertToBusinessPartnerGroup(obp.kategorie));
		bp.setName(obp.getUnternehmensName());
		bp.setValue(obp.getUnternehmensName());
		bp.setDescription(obp.getBeschreibung());
		bp.setTaxid(obp.getSteuernummer());
		return bp;
	}
	
	/**
	 * Method to convert an BusinessPartner to OpenZGeschaeftspartner.
	 * @param bp BusinessPartner which shall be converted to OpenZGeschaeftspartner.
	 * @return OpenZGeschaeftspartner object with the details of the BusinessPartner.
	 */
	public static OpenZGeschaeftspartner convertToOpenZGeschaftspartner(BusinessPartner bp){
		OpenZGeschaeftspartner obp = new OpenZGeschaeftspartner();
		obp.setId(bp.getID());
		obp.setKategorie(convertToOpenZBusinessPartnerGroup(bp.getBpGroup()));
		obp.setUnternehmensName(bp.getName());
		obp.setBeschreibung(bp.getDescription());
		obp.setSteuernummer(bp.getTaxid());
		return obp;
	}
	
	/**
	 * Converts the Hipergate Group to BusinessPartnerGroup.
	 * @param hipergateGroup The Hipergate Group which shall be converted to BusinessPartnerGroup.
	 * @return Business Partner Group object
	 * @throws UnknownGroupException If group specified is unknown
	 */
	/*
	 * CLIENTE = Kunde,CLIENTE POTENCIAL = Potenzieller Kunde,COMPETENCIA = Wettbewerber,PARTNER = Befreundetes Unternehmen, PROVEEDOR = Lieferant
	 * */
	public static BusinessPartnerGroup convertToBusinessPartnerGroup(String hipergateGroup) throws UnknownGroupException{
		String groupID = getBusinessParterMap().get(hipergateGroup);
//				businessPartnerMapping().get(hipergateGroup);
		System.out.println("hipergateGroup: " + hipergateGroup);
		System.out.println("groupID: " + groupID);
		System.out.println("****");
		if(groupID != null){
		return BusinessPartnerGroupUtil.getBusinessPartnerGroup(groupID);
		}
		else throw new UnknownGroupException();
	}
	
	/**
	 * Converts the BusinessPartnerGroup to OpenZBusinessPartnerGroup.
	 * @param bpg BusinessPartnerGroup which shall be converted.
	 * @return OpenzBusinessPartnerGroup object.
	 */
	public static String convertToOpenZBusinessPartnerGroup(BusinessPartnerGroup bpg) {
		String groupID = businessPartnerMapping().getKey(bpg.getID());
	
		return groupID;
	}
	
	/**
	 * Retrieves the mapping for BusinessPartner in Hipergate.
	 * @return Mapping of the BusinessPartner from Hipergate.
	 */
	private static BidiMap<String,String> businessPartnerMapping(){
		BidiMap<String,String> groupMap = new DualHashBidiMap<String, String>();
		groupMap.put("CLIENTE","01E84103D6AA4B5A84FFFE5787099DB9");
		groupMap.put("CLIENTE POTENCIAL", "186B201A1642451DAB37B11EAEFCC1E8");
		groupMap.put("COMPETENCIA", "6F20D1C3640D458CABEF94DAD1BB9903");
		groupMap.put("PARTNER", "94EEF738862945AE850CA1FF48906927");
		groupMap.put("PROVEEDOR","01E84103D6AA4B5A84FFFE5787099DB9");
		
		for(String key : groupMap.keySet()){
			System.out.println(key + " " + groupMap.get(key));
		}
		
		return groupMap;
	}
	
	private static Map<String, String> getBusinessParterMap(){
		Map<String, String> groupMap = new HashMap<String, String>();
		groupMap.put("CLIENTE","01E84103D6AA4B5A84FFFE5787099DB9");
		groupMap.put("CLIENTE POTENCIAL", "186B201A1642451DAB37B11EAEFCC1E8");
		groupMap.put("COMPETENCIA", "6F20D1C3640D458CABEF94DAD1BB9903");
		groupMap.put("PARTNER", "94EEF738862945AE850CA1FF48906927");
		groupMap.put("PROVEEDOR","01E84103D6AA4B5A84FFFE5787099DB9");
		
		for(String key : groupMap.keySet()){
			System.out.println(key + " " + groupMap.get(key));
		}
		
		return groupMap;
	}

}
