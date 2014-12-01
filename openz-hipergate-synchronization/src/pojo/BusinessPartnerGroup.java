package pojo;

import io.database.BusinessPartnerGroupUtil;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import java.util.UUID;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * The minified version of c_bpartner_group table
 * @author cglaeser
 *
 */

@Entity
@Table(name="c_bp_group")
@NamedQueries({
	//NamedQuery zur Auflistung aller Branchen
	@NamedQuery(name = BusinessPartnerGroup.FIND_BRANCHE_BY_ID,
            query = "SELECT b " +
		            "FROM BusinessPartnerGroup b " +
            		"WHERE b.ID = :" + BusinessPartnerGroup.PARAM_ID ),
   @NamedQuery(name = BusinessPartnerGroup.FIND_ALL_BRANCHEN,
                    query = "SELECT b " +
        		            "FROM BusinessPartnerGroup b ")
})
public class BusinessPartnerGroup implements Serializable {



	/**
	 * 
	 */
	private static final long serialVersionUID = 2038990287130585695L;

	private String id;
	
	/**
	 * An always identical number C726FEC915A54A0995C568555DA5BB3C
	 */
	private String ClientID;
	
	/**
	 * An always identical number 5F1A818D54EF4182A30C9235FF8658E5
	 */
	private String OrgID;
	
	/**
	 * An always identical number 1
	 */
	private Character isActive;
	
	/**
	 * The creation time of the entry
	 */
	private Date created;
	
	/**
	 * An always identical number DDAA21D11CB04D4D8EC59E39934B27FB
	 */
	private String createdBy;
	
	/**
	 * The last update time of the entry
	 */
	private Date updated;
	
	/**
	 * An always identical number DDAA21D11CB04D4D8EC59E39934B27FB
	 */
	private String updatedBy;
	
	/**
	 * The name of the Group;
	 */
	private String value;
	
	/**
	 * Usually identical to name
	 */
	private String name;
	
	/**
	 * The description of the group
	 */
	private String description;
	
	/**
	 * Usually 'N'
	 */
	private char isDefault;
	
	private List<BusinessPartner> businessPartners;
	
	public static final String PARAM_ID = "c_bp_group_id";
	
	public static final String FIND_BRANCHE_BY_ID = "getBrancheByID";

	public static final String FIND_ALL_BRANCHEN = "findAllBranchen";


	@Id
	@Column(name=PARAM_ID)
	public String getID() {
		return this.id;
	}


	public void setID(String id) {
		this.id = id;
	}


	@Column(name="ad_client_id")
	public String getClientID() {
		return ClientID;
	}


	public void setClientID(String clientID) {
		ClientID = clientID;
	}


	@Column(name="ad_org_id")
	public String getOrgID() {
		return OrgID;
	}


	public void setOrgID(String orgID) {
		OrgID = orgID;
	}


	@Column(name="isactive")
	public Character isActive() {
		return isActive;
	}


	public void setActive(Character isActive) {
		this.isActive = isActive;
	}

	@Temporal(value = TemporalType.TIMESTAMP)
	public Date getCreated() {
		return created;
	}


	public void setCreated(Date created) {
		this.created = created;
	}

	@Column(name="createdby")
	public String getCreatedBy() {
		return createdBy;
	}


	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
	}

	@Temporal(value = TemporalType.TIMESTAMP)
	public Date getUpdated() {
		return updated;
	}


	public void setUpdated(Date updated) {
		this.updated = updated;
	}


	@Column(name="updatedby")
	public String getUpdatedBy() {
		return updatedBy;
	}


	public void setUpdatedBy(String updatedBy) {
		this.updatedBy = updatedBy;
	}


	@Column(name="value")
	public String getValue() {
		return value;
	}


	public void setValue(String value) {
		this.value = value;
	}


	@Column(name="name")
	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}

	@Column(name="description")
	public String getDescription() {
		return description;
	}


	public void setDescription(String description) {
		this.description = description;
	}

	@Column(name="isdefault")
	public char getIsDefault() {
		return isDefault;
	}

	public void setIsDefault(char isDefault) {
		this.isDefault = isDefault;
	}
	
	@OneToMany(cascade=CascadeType.ALL, mappedBy="bpGroup")
	public List<BusinessPartner> getBusinessPartners(){
		return businessPartners;
	}
	
	public void setBusinessPartners(List<BusinessPartner> businessPartners){
		this.businessPartners = businessPartners;
	}


	@Override
	public String toString() {
		return "BusinessPartnerGroup [id=" + id + ", ClientID=" + ClientID + ", OrgID="
				+ OrgID + ", isActive=" + isActive + ", created=" + created
				+ ", createdBy=" + createdBy + ", updated=" + updated
				+ ", updatedBy=" + updatedBy + ", value=" + value + ", name="
				+ name + ", description=" + description + ", isDefault="
				+ isDefault + "]";
	}
	
	public void persist(){
		BusinessPartnerGroupUtil.persistBusinessPartner(this);
	}
}
