package pojo;

import java.io.Serializable;

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
        		            "FROM BusinessPartner b ")
})
public class BusinessPartner implements Serializable {
	
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
	
	public static final String FIND_BP_BY_ID = "findBusinessPartnerByID";
	public static final String FIND_ALL_BP = "findAllBusinessPartners";
	public static final String PARAM_ID = "c_bpartner_id";
	
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
	@Column(name="name")
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	@ManyToOne
	@JoinColumn(name="c_bp_group_id", nullable=false)
	public BusinessPartnerGroup getBpGroup() {
		return bpGroup;
	}
	public void setBpGroup(BusinessPartnerGroup bpGroup) {
		this.bpGroup = bpGroup;
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
}
