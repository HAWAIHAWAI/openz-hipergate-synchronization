/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.knowgate.hipergate.InformationsKomponente;


/**
 * Class for Geschaeftspartner from OpenZ.
 *
 * @author Hawai
 */
public class OpenZGeschaeftspartner implements java.io.Serializable{

    /**
	 * For serialization. Required for pulling messages from Hipergate-Rabbit-MQ.
	 */
	private static final long serialVersionUID = 1517150760610046850L;
	
	/* Steuernummer des Unternehmens. Sollte eindeutig sein.*/
	/**
	 * Tax ID, should be unique.
	 */
	public String id;
	
    public String steuernummer = "";
    
    /**
     * Name of the Company
     */
    public String unternehmensName = null;;
    
    /**
     * Street 1 and number.
     */
    public String straﬂe1UndNr = null;
    
    /**
     * Street 2 and number
     */
    public String straﬂe2UndNr = null;
    
    /**
     * Postcode
     */
    public String postleitzahl = null;
    
    /**
     * State
     */
    public String status = null;
    
    /**
     * Country
     */
    public String land= null;
    
    /**
     * City
     */
    public String stadt = null;
    
    /**
     * Phone number
     */
    public String telefonnummer = null;
    /* zus‰tzliche Beschreibung die ¸bertragen wird. */
    /**
     * Further information (will be transferred).
     */
    public String beschreibung = null;
    /*Beschreibt den Bereich, in dem das Unternnehmen, dem HAWAICYLCE n¸tzlich ist.
      Bisher sind nur die Kategorien Materialien, Dienstleistung und Sonstiges in Planung.*/
    /**
     * Category for the group of the company.
     */
    public String kategorie;
    /* Beschreibt die Branche, in dem das Unternehmen t‰tig ist,
     zum Beispiel Fahrradlenker oder Lederwaren usw.*/
    /**
     * Sector of the company.
     */
    public String branche = null;
    
    /**
     * Timestamp of the last entry
     */
    public String timestamp = null;

    /**
     * Construnctor.
     */
    public OpenZGeschaeftspartner(){}

    /**
     * Retrieve the taxid
     * @return The taxid.
     */
    public String getSteuernummer() {
        return steuernummer;
    }

    /**
     * Returns the id
	 * @return the id
	 */
	public String getId() {
		return id;
	}

	/**
	 * Setter for the id.
	 * @param id the id to set
	 */
	public void setId(String id) {
		this.id = id;
	}

	/**
	 * Returns the name of the company.
	 * @return Name of the company
	 */
	public String getUnternehmensName() {
        return unternehmensName;
    }

	/**
	 * Getter for Straﬂe1UndNr
	 * @return String for Straﬂe1UndNr.
	 */
    public String getStraﬂe1UndNr() {
        return straﬂe1UndNr;
    }

	/**
	 * Getter for Straﬂe2UndNr
	 * @return String for Straﬂe2UndNr.
	 */
    public String getStraﬂe2UndNr() {
        return straﬂe2UndNr;
    }

    /**
     * Getter for postcode.
     * @return Postcode as String.
     */
    public String getPostleitzahl() {
        return postleitzahl;
    }

    /**
     * Getter for country.
     * @return Country as String.
     */
    public String getLand() {
        return land;
    }

    /**
     * Getter for city.
     * @return City as String.
     */
    public String getStadt() {
        return stadt;
    }

    /**
     * Getter for phone number.
     * @return Phone number as String.
     */
    public String getTelefonnummer() {
        return telefonnummer;
    }

    /**
     * Getter for further information.
     * @return Further information as String.
     */
    public String getBeschreibung() {
        return beschreibung;
    }

    /**
     * Getter for Category.
     * @return Category as String.
     */
    public String getKategorie() {
        return kategorie;
    }

    /**
     * Getter for sector.
     * @return Sector as String.
     */
    public String getBranche() {
        return branche;
    }

    /**
     * Getter for timestamp.
     * @return Timestamp as String.
     */
    public String getTimestamp() {
        return timestamp;
    }

    /**
     * Setter for taxid.
     * @param steuernummer The taxid.
     */
    public void setSteuernummer(String steuernummer) {
        this.steuernummer = steuernummer;
    }

    /**
     * Setter for the name of the company.
     * @param unternehmensName The name of the company.
     */
    public void setUnternehmensName(String unternehmensName) {
        this.unternehmensName = unternehmensName;
    }

    /**
     * Setter for Straﬂe1UndNr (Street1AndNr).
     * @param straﬂe1UndNr The straﬂe1UndNr.
     */
    public void setStraﬂe1UndNr(String straﬂe1UndNr) {
        this.straﬂe1UndNr = straﬂe1UndNr;
    }

    /**
     * Setter for Straﬂe2UndNr (Street2AndNr).
     * @param straﬂe2UndNr The straﬂe2UndNr.
     */
    public void setStraﬂe2UndNr(String straﬂe2UndNr) {
        this.straﬂe2UndNr = straﬂe2UndNr;
    }

    /**
     * Setter for postcode.
     * @param postleitzahl The postcode.
     */
    public void setPostleitzahl(String postleitzahl) {
        this.postleitzahl = postleitzahl;
    }

    /**
     * Setter for country.
     * @param land The country.
     */
    public void setLand(String land) {
        this.land = land;
    }

    /**
     * Setter for city.
     * @param stadt The city.
     */
    public void setStadt(String stadt) {
        this.stadt = stadt;
    }

    /**
     * Setter for phone number.
     * @param telefonnummer The phone number.
     */
    public void setTelefonnummer(String telefonnummer) {
        this.telefonnummer = telefonnummer;
    }

    /**
     * Setter for further information.
     * @param beschreibung Further information.
     */
    public void setBeschreibung(String beschreibung) {
        this.beschreibung = beschreibung;
    }

    /**
     * Setter for category.
     * @param kategorie The category.
     */
    public void setKategorie(String kategorie) {
        this.kategorie = kategorie;
    }

    /**
     * Setter for sector.
     * @param branche The sector.
     */
    public void setBranche(String branche) {
        this.branche = branche;
    }

    /**
     * Setter for timestamp.
     * @param timestamp The timestamp.
     */
    public void setTimestamp(String timestamp) {
        this.timestamp = timestamp;
    }

	/* (non-Javadoc)
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((beschreibung == null) ? 0 : beschreibung.hashCode());
		result = prime * result + ((branche == null) ? 0 : branche.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result
				+ ((kategorie == null) ? 0 : kategorie.hashCode());
		result = prime * result + ((land == null) ? 0 : land.hashCode());
		result = prime * result
				+ ((postleitzahl == null) ? 0 : postleitzahl.hashCode());
		result = prime * result + ((stadt == null) ? 0 : stadt.hashCode());
		result = prime * result + ((status == null) ? 0 : status.hashCode());
		result = prime * result
				+ ((steuernummer == null) ? 0 : steuernummer.hashCode());
		result = prime * result
				+ ((straﬂe1UndNr == null) ? 0 : straﬂe1UndNr.hashCode());
		result = prime * result
				+ ((straﬂe2UndNr == null) ? 0 : straﬂe2UndNr.hashCode());
		result = prime * result
				+ ((telefonnummer == null) ? 0 : telefonnummer.hashCode());
		result = prime * result
				+ ((timestamp == null) ? 0 : timestamp.hashCode());
		result = prime
				* result
				+ ((unternehmensName == null) ? 0 : unternehmensName.hashCode());
		return result;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		OpenZGeschaeftspartner other = (OpenZGeschaeftspartner) obj;
		if (beschreibung == null) {
			if (other.beschreibung != null)
				return false;
		} else if (!beschreibung.equals(other.beschreibung))
			return false;
		if (branche == null) {
			if (other.branche != null)
				return false;
		} else if (!branche.equals(other.branche))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (kategorie == null) {
			if (other.kategorie != null)
				return false;
		} else if (!kategorie.equals(other.kategorie))
			return false;
		if (land == null) {
			if (other.land != null)
				return false;
		} else if (!land.equals(other.land))
			return false;
		if (postleitzahl == null) {
			if (other.postleitzahl != null)
				return false;
		} else if (!postleitzahl.equals(other.postleitzahl))
			return false;
		if (stadt == null) {
			if (other.stadt != null)
				return false;
		} else if (!stadt.equals(other.stadt))
			return false;
		if (status == null) {
			if (other.status != null)
				return false;
		} else if (!status.equals(other.status))
			return false;
		if (steuernummer == null) {
			if (other.steuernummer != null)
				return false;
		} else if (!steuernummer.equals(other.steuernummer))
			return false;
		if (straﬂe1UndNr == null) {
			if (other.straﬂe1UndNr != null)
				return false;
		} else if (!straﬂe1UndNr.equals(other.straﬂe1UndNr))
			return false;
		if (straﬂe2UndNr == null) {
			if (other.straﬂe2UndNr != null)
				return false;
		} else if (!straﬂe2UndNr.equals(other.straﬂe2UndNr))
			return false;
		if (telefonnummer == null) {
			if (other.telefonnummer != null)
				return false;
		} else if (!telefonnummer.equals(other.telefonnummer))
			return false;
		if (timestamp == null) {
			if (other.timestamp != null)
				return false;
		} else if (!timestamp.equals(other.timestamp))
			return false;
		if (unternehmensName == null) {
			if (other.unternehmensName != null)
				return false;
		} else if (!unternehmensName.equals(other.unternehmensName))
			return false;
		return true;
	}    
 
    
}
