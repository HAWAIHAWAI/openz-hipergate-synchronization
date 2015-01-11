package pojo;

import io.database.BusinessPartnerUtil;

import java.io.Serializable;
import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

/**
 * 
 * The minified version of c_bpartner
 * @author cglaeser
 *
 */
@Entity
@Table(name="c_bpartner")
@NamedQueries({
	//NamedQuery zur Auflistung aller Branchen
	@NamedQuery(name = BusinessPartner.FIND_BP_BY_ID,
            query = "SELECT b " +
		            "FROM BusinessPartner b " +
            		"WHERE b.ID = :" + BusinessPartner.PARAM_ID ),
   @NamedQuery(name = BusinessPartner.FIND_ALL_BP,
                    query = "SELECT b " +
        		            "FROM BusinessPartner b "),
   @NamedQuery(name = BusinessPartner.FIND_BP_BY_NAME,
                            query = "SELECT b " +
                		            "FROM BusinessPartner b " + 
                            		"WHERE b.name = :" + BusinessPartner.PARAM_NAME),     		            
})
public class BusinessPartner implements Serializable {
	
	/**
	 * Constructor with default values.
	 */
	public BusinessPartner(){
		id = null;
		//fullfilling dependency requirements in database table
		setADClientId("C726FEC915A54A0995C568555DA5BB3C");
		setADOrgId("5F1A818D54EF4182A30C9235FF8658E5");
		setCreatedBy("DDAA21D11CB04D4D8EC59E39934B27FB");
		setUpdatedBy("DDAA21D11CB04D4D8EC59E39934B27FB");
		value = null;
	}
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -483133666998315194L;
	
	private String id;
	private String value;
	private String name;
	private String name2;
	private String taxNumber;
	private String description;
	private BusinessPartnerGroup bpGroup;
	private String ADClientId;
	private String ADOrgId;
	private String createdBy;
	private String updatedBy;
	
	public static final String FIND_BP_BY_ID = "findBusinessPartnerByID";
	public static final String FIND_ALL_BP = "findAllBusinessPartners";
	public static final String FIND_BP_BY_NAME = "findBusinessPartnerByName";
	public static final String PARAM_ID = "c_bpartner_id";
	public static final String PARAM_NAME = "name";
	
	@Id
	@Column(name=PARAM_ID)
	public String getID() {
		return id;
	}
	public void setID(String id) {
		this.id = id;
	}
	
	@Column(name="value")
	public String getValue() {
		return value;
	}
	public void setValue(String value) {
		this.value = value;
	}
	
	@Id
	@Column(name=PARAM_NAME)
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	@Column(name="taxid")
	public String getTaxNumber() {
		return taxNumber;
	}
	public void setTaxNumber(String taxNumber) {
		this.taxNumber = taxNumber;
	}
	
	@Column(name="name2")
	public String getName2() {
		return name2;
	}
	public void setName2(String name2) {
		this.name2 = name2;
	}
	
	
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	
	
	
	////Connections in database///
	@ManyToOne
	@JoinColumn(name="c_bp_group_id", nullable=false)
	public BusinessPartnerGroup getBpGroup() {
		return bpGroup;
	}
	
	public void setBpGroup(BusinessPartnerGroup bpGroup) {
		this.bpGroup = bpGroup;
	}
	
	@Column(name="ad_client_id")
	public String getADClientId() {
		return ADClientId;
	}
	public void setADClientId(String adClientId) {
		this.ADClientId = adClientId;
	}
	
	@Column(name="ad_org_id")
	public String getADOrgId(){
		return ADOrgId;
	}
	
	public void setADOrgId(String adOrgId) {
		this.ADOrgId = adOrgId;
	}
	
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "BusinessPartner [id=" + id
				+ ", value=" + value + ", name=" + name + ", name2=" + name2
				+ ", taxNumber=" + taxNumber + ", description=" + description
				+ ", BusinessPartnerGroup=" + bpGroup + "]";
	}
	
	public void persist() {
		if(this.id==null){
			this.id = UUID.randomUUID().toString().replaceAll("-", "");
			System.out.println("id of new instance has been set to " + id);
		}
		if(value==null){setValue(name);}
		BusinessPartnerUtil.persistBusinessPartner(this);
	}
	public String getCreatedBy() {
		return createdBy;
	}
	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
	}
	public String getUpdatedBy() {
		return updatedBy;
	}
	public void setUpdatedBy(String updatedBy) {
		this.updatedBy = updatedBy;
	}
}
