package pojo;

/**
 * 
 * The minified version of c_bp
 * @author cglaeser
 *
 */
public class BusinessPartner {
	
	private String businessPartnerKey;
	private String name;
	private String name2;
	private String taxNumber;
	private String description;
	private String Branche;
	
	public String getBusinessPartnerKey() {
		return businessPartnerKey;
	}
	public void setBusinessPartnerKey(String businessPartnerKey) {
		this.businessPartnerKey = businessPartnerKey;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getTaxNumber() {
		return taxNumber;
	}
	public void setTaxNumber(String taxNumber) {
		this.taxNumber = taxNumber;
	}
	public String getName2() {
		return name2;
	}
	public void setName2(String name2) {
		this.name2 = name2;
	}
	public String getBranche() {
		return Branche;
	}
	public void setBranche(String branche) {
		Branche = branche;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}

}
