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
 * 
 * @author cglaeser
 *
 */

@Entity
@Table(name = "c_bp_group")
@NamedQueries({
		// NamedQuery zur Auflistung aller Branchen
		@NamedQuery(name = BusinessPartnerGroup.FIND_BUSINESSPARTNERGROUP_BY_ID, query = "SELECT b "
				+ "FROM BusinessPartnerGroup b "
				+ "WHERE b.ID = :"
				+ BusinessPartnerGroup.PARAM_ID),
		@NamedQuery(name = BusinessPartnerGroup.FIND_ALL_BUSINESSPARTNERGROUPS, query = "SELECT b "
				+ "FROM BusinessPartnerGroup b "),
		@NamedQuery(name = BusinessPartnerGroup.FIND_BUSINESSPARTNERGROUPS_BY_NAME, query = "SELECT b "
				+ "FROM BusinessPartnerGroup b "
				+ "WHERE b.name = :"
				+ BusinessPartnerGroup.PARAM_NAME), })
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

	/**
	 * List with Business Partners in this Group.
	 */
	private List<BusinessPartner> businessPartners;

	public static final String PARAM_ID = "c_bp_group_id";
	public static final String PARAM_NAME = "name";

	public static final String FIND_BUSINESSPARTNERGROUP_BY_ID = "getBusinessPartnerGroupByID";
	public static final String FIND_BUSINESSPARTNERGROUPS_BY_NAME = "getBusinessPartnerGroupByName";
	public static final String FIND_ALL_BUSINESSPARTNERGROUPS = "findAllBusinessPartnerGroups";

	/**
	 * Returns the Business Partner ID.
	 * 
	 * @return Business Partner ID.
	 */
	@Id
	@Column(name = PARAM_ID)
	public String getID() {
		return this.id;
	}

	/**
	 * Sets the ID.
	 * 
	 * @param id
	 *            The new ID.
	 */
	public void setID(String id) {
		this.id = id;
	}

	/**
	 * Returns the client ID
	 * 
	 * @return Client ID.
	 */
	@Column(name = "ad_client_id")
	public String getClientID() {
		return ClientID;
	}

	/**
	 * Sets the client ID.
	 * 
	 * @param clientID
	 *            The new client ID.
	 */
	public void setClientID(String clientID) {
		ClientID = clientID;
	}

	/**
	 * Returns the Organization ID.
	 * @return Organization ID.
	 */
	@Column(name = "ad_org_id")
	public String getOrgID() {
		return OrgID;
	}

	/**
	 * Sets the Organization ID.
	 * @param orgID The new Organization ID.
	 */
	public void setOrgID(String orgID) {
		OrgID = orgID;
	}

	/**
	 * Returns the character for "isactive".
	 * @return Character which indicates the "isactive" state.
	 */
	@Column(name = "isactive")
	public Character isActive() {
		return isActive;
	}

	/**
	 * Sets the "isactive" character.
	 * @param isActive The new "isactive" character.
	 */
	public void setActive(Character isActive) {
		this.isActive = isActive;
	}

	/**
	 * Returns the date of creation of this BusinessPartnerGroup.
	 * @return Date
	 */
	@Temporal(value = TemporalType.TIMESTAMP)
	public Date getCreated() {
		return created;
	}

	/**
	 * Sets the date of creation of this BusinessPartnerGroup.
	 * @param created The new creation date.
	 */
	public void setCreated(Date created) {
		this.created = created;
	}

	/**
	 * Returns the creator of this BusinessPartnerGroup.
	 * @return Creator of this BusinessPartnerGroup.
	 */
	@Column(name = "createdby")
	public String getCreatedBy() {
		return createdBy;
	}

	/**
	 * Sets the creator of this BusinessPartnerGroup.
	 * @param createdBy The new creator.
	 */
	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
	}

	/**
	 * Returns the update date.
	 * @return Update date.
	 */
	@Temporal(value = TemporalType.TIMESTAMP)
	public Date getUpdated() {
		return updated;
	}

	/**
	 * Sets the update date.
	 * @param updated The new update date.
	 */
	public void setUpdated(Date updated) {
		this.updated = updated;
	}

	/**
	 * Returns the instance (updater) which updated this BusinessPartnerGroup.
	 * @return Updater.
	 */
	@Column(name = "updatedby")
	public String getUpdatedBy() {
		return updatedBy;
	}

	/**
	 * Sets the "updater".
	 * @param updatedBy The new updater.
	 */
	public void setUpdatedBy(String updatedBy) {
		this.updatedBy = updatedBy;
	}

	/**
	 * Retrives the value(=name) of this BusinessPartnerGroup.
	 * @return Value (name) of this BusinessPartnerGroup.
	 */
	@Column(name = "value")
	public String getValue() {
		return value;
	}

	/**
	 * Sets the value(=name) of this BusinessPartnerGroup.
	 * @param value The new Value(name).
	 */
	public void setValue(String value) {
		this.value = value;
	}

	/**
	 * Returns the name of this BusinessPartnerGroup.
	 * @return Name of this BusinessPartnerGroup.
	 */
	@Column(name = PARAM_NAME)
	public String getName() {
		return name;
	}

	/**
	 * Sets the name of this BusinessPartnerGroup.
	 * @param name The new name.
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * Returns the description of this BusinessPartnerGroup.
	 * @return Description of this BusinessPartnerGroup.
	 */
	@Column(name = "description")
	public String getDescription() {
		return description;
	}

	/**
	 * Sets the description of this BusinessPartnerGroup.
	 * @param description The new description.
	 */
	public void setDescription(String description) {
		this.description = description;
	}

	/**
	 * Returns the character for "isdefault".
	 * @return "isdefault" character.
	 */
	@Column(name = "isdefault")
	public char getIsDefault() {
		return isDefault;
	}

	/**
	 * Sets the character for "isdefault".
	 * @param isDefault The new "isdefault" character.
	 */
	public void setIsDefault(char isDefault) {
		this.isDefault = isDefault;
	}

	/**
	 * Returns a list with all BusinessPartners within this BusinessPartnerGroup.
	 * @return List with all BusinessPartners within this BusinessPartnerGroup.
	 */
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "bpGroup")
	public List<BusinessPartner> getBusinessPartners() {
		return businessPartners;
	}

	/**
	 * Sets the BusinessPartners in this BusinessParterGroup to the passed list.
	 * @param businessPartners List with the new BusinessPartners of this group.
	 */
	public void setBusinessPartners(List<BusinessPartner> businessPartners) {
		this.businessPartners = businessPartners;
	}

	@Override
	public String toString() {
		return "BusinessPartnerGroup [id=" + id + ", ClientID=" + ClientID
				+ ", OrgID=" + OrgID + ", isActive=" + isActive + ", created="
				+ created + ", createdBy=" + createdBy + ", updated=" + updated
				+ ", updatedBy=" + updatedBy + ", value=" + value + ", name="
				+ name + ", description=" + description + ", isDefault="
				+ isDefault + "]";
	}

	/**
	 * Persists this BusinessPartnerGroup.
	 */
	public void persist() {
		BusinessPartnerGroupUtil.persistBusinessPartnerGroup(this);
	}
}
