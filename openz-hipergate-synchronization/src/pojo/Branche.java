package pojo;

import java.util.Date;

/**
 * The minified version of c_bpartner_group table
 * @author cglaeser
 *
 */
public class Branche {
	
	private String ID;
	
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
	private boolean isActive;
	
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
}
