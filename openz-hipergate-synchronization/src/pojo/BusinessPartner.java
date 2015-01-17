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
 * The minified version of c_bpartner from the OpenZ-DB.
 * Fields and methods relate to the columns in the database.
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
	
	/**
	 * Field for c_bpartner_id (which is the PK).
	 */
	private String id;
	
	/**
	 * Field for value.
	 */
	private String value;
	
	/**
	 * Field for name.
	 */
	private String name;
	
	/**
	 * Field for name2.
	 */
	private String name2;
	
	/**
	 * Field for taxid.
	 */
	private String taxid;
	
	/**
	 * Field for description.
	 */
	private String description;
	
	/**
	 * Field for c_bp_group_id.
	 */
	private BusinessPartnerGroup bpGroup;
	
	/**
	 * Field for ad_client_id.
	 */
	private String ADClientId;
	
	/**
	 * Field for ad_org_id.
	 */
	private String ADOrgId;
	
	/**
	 * Field for createdby.
	 */
	private String createdBy;
	
	/**
	 * Field for updatedby.
	 */
	private String updatedBy;
	
	/*
	 * Static fields for names and parameters.
	 */
	public static final String FIND_BP_BY_ID = "findBusinessPartnerByID";
	public static final String FIND_ALL_BP = "findAllBusinessPartners";
	public static final String FIND_BP_BY_NAME = "findBusinessPartnerByName";
	public static final String PARAM_ID = "c_bpartner_id";
	public static final String PARAM_NAME = "name";
	
	/**
	 * Getter for the primary key.
	 * @return Value for primary key.
	 */
	@Id
	@Column(name=PARAM_ID)
	public String getID() {
		return id;
	}
	/**
	 * Setter for the primary key.
	 * @param id The primary key.
	 */
	public void setID(String id) {
		this.id = id;
	}
	
	/**
	 * Getter for value.
	 * @return Entry for value.
	 */
	@Column(name="value")
	public String getValue() {
		return value;
	}
	/**
	 * Setter for value.
	 * @param value The value.
	 */
	public void setValue(String value) {
		this.value = value;
	}
	
	/**
	 * Getter for name.
	 * @return Name.
	 */
	@Id
	@Column(name=PARAM_NAME)
	public String getName() {
		return name;
	}
	/**
	 * Setter for name.
	 * @param name The name.
	 */
	public void setName(String name) {
		this.name = name;
	}
	
	/**
	 * Getter for taxid.
	 * @return The taxid.
	 */
	@Column(name="taxid")
	public String getTaxid() {
		return taxid;
	}
	/**
	 * Setter for taxid.
	 * @param taxid The taxid.
	 */
	public void setTaxid(String taxid) {
		this.taxid = taxid;
	}
	
	/**
	 * Getter for name2.
	 * @return Name2.
	 */
	@Column(name="name2")
	public String getName2() {
		return name2;
	}
	/**
	 * Setter for name2.
	 * @param name2 The name2.
	 */
	public void setName2(String name2) {
		this.name2 = name2;
	}
	
	/**
	 * Getter for description.
	 * @return Description,
	 */
	public String getDescription() {
		return description;
	}
	/**
	 * Setter for description.
	 * @param description The description.
	 */
	public void setDescription(String description) {
		this.description = description;
	}
	
	
	
	////Connections in database///
	/**
	 * Getter for BusinessPartnerGroup ( foreign key: c_bp_group_id ).
	 * @return The BusinessPartnerGroup.
	 */
	@ManyToOne
	@JoinColumn(name="c_bp_group_id", nullable=false)
	public BusinessPartnerGroup getBpGroup() {
		return bpGroup;
	}
	
	/**
	 * Setter for BusinessPartnerGroup.
	 * @param bpGroup The BusinessPartnerGroup.
	 */
	public void setBpGroup(BusinessPartnerGroup bpGroup) {
		this.bpGroup = bpGroup;
	}
	
	/**
	 * Getter for ad_client_id.
	 * @return The ad_client_id.
	 */
	@Column(name="ad_client_id")
	public String getADClientId() {
		return ADClientId;
	}
	
	/**
	 * Setter for ad_client_id.
	 * @param adClientId The ad_client_id.
	 */
	public void setADClientId(String adClientId) {
		this.ADClientId = adClientId;
	}
	
	/**
	 * Getter for ad_org_id.
	 * @return The ad_org_id.
	 */
	@Column(name="ad_org_id")
	public String getADOrgId(){
		return ADOrgId;
	}
	
	/**
	 * Setter for ad_org_id.
	 * @param adOrgId The ad_org_id.
	 */
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
				+ ", taxNumber=" + taxid + ", description=" + description
				+ ", BusinessPartnerGroup=" + bpGroup + "]";
	}
	
	/**
	 * Method to persist the BusinessPartner in the OpenZ-DB.
	 */
	public void persist() {
		if(this.id==null){
			this.id = UUID.randomUUID().toString().replaceAll("-", "");
			System.out.println("id of new instance has been set to " + id);
		}
		if(value==null){setValue(name);}
		BusinessPartnerUtil.persistBusinessPartner(this);
	}
	
	/**
	 * Getter for createdby.
	 * @return createdby as String.
	 */
	public String getCreatedBy() {
		return createdBy;
	}
	
	/**
	 * Setter for createdby.
	 * @param createdBy The createdby.
	 */
	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
	}
	
	/**
	 * Setter for updatedby.
	 * @return updatedby as String.
	 */
	public String getUpdatedBy() {
		return updatedBy;
	}
	
	/**
	 * Setter for updatedby.
	 * @param updatedBy The updatedby.
	 */
	public void setUpdatedBy(String updatedBy) {
		this.updatedBy = updatedBy;
	}
}
