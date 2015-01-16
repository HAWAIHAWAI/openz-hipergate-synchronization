package pojo;

import io.database.BusinessPartnerUtil;
import io.database.LogEntryUtil;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

@Entity
@Table(name="_log")
@NamedQueries({
	   @NamedQuery(name = LogEntry.FIND_ALL_LOGENTRIES,
               query = "SELECT l " +
   		            "FROM LogEntry l ")
})
public class LogEntry implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 6321930723462455181L;
	
	
	private String id;
	private Timestamp timestamp;
	private String description;
	
	public static final String PARAM_ID = "id";
	public static final String PARAM_TIMESTAMP = "timestamp";
	public static final String PARAM_DESCRIPTION = "description";


	public static final String FIND_ALL_LOGENTRIES = "findAllLogentries";
	
	@Id
	@Column(name=PARAM_ID)
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	
	@Column(name=PARAM_TIMESTAMP)
	public Timestamp getTimestamp() {
		return timestamp;
	}
	public void setTimestamp(Timestamp timestamp) {
		this.timestamp = timestamp;
	}

	@Column(name=PARAM_DESCRIPTION)
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	
	public void persist() {
		if(this.id==null){
			this.id = UUID.randomUUID().toString().replaceAll("-", "");
			System.out.println("id of new instance has been set to " + id);
		}
		LogEntryUtil.persistLogEntry(this);
	}
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "LogEntry [id=" + id + ", timestamp=" + timestamp
				+ ", description=" + description + "]";
	}
}
