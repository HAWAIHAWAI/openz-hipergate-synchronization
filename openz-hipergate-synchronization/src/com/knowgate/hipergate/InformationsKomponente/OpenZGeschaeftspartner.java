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
	 * 
	 */
	private static final long serialVersionUID = 1517150760610046850L;
	
	/* Steuernummer des Unternehmens. Sollte eindeutig sein.*/
	public String id;
	
    public String steuernummer = "";
    public String unternehmensName = null;;
    public String straﬂe1UndNr = null;
    public String straﬂe2UndNr = null;
    public String postleitzahl = null;
    public String status = null;
    public String land= null;
    public String stadt = null;
    public String telefonnummer = null;
    /* zus‰tzliche Beschreibung die ¸bertragen wird. */
    public String beschreibung = null;
    /*Beschreibt den Bereich, in dem das Unternnehmen, dem HAWAICYLCE n¸tzlich ist.
      Bisher sind nur die Kategorien Materialien, Dienstleistung und Sonstiges in Planung.*/
    public String kategorie;
    /* Beschreibt die Branche, in dem das Unternehmen t‰tig ist,
     zum Beispiel Fahrradlenker oder Lederwaren usw.*/
    public String branche = null;
    public String timestamp = null;

    public OpenZGeschaeftspartner(){}

    public String getSteuernummer() {
        return steuernummer;
    }

    /**
	 * @return the id
	 */
	public String getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(String id) {
		this.id = id;
	}

	public String getUnternehmensName() {
        return unternehmensName;
    }

    public String getStraﬂe1UndNr() {
        return straﬂe1UndNr;
    }

    public String getStraﬂe2UndNr() {
        return straﬂe2UndNr;
    }

    public String getPostleitzahl() {
        return postleitzahl;
    }

    public String getLand() {
        return land;
    }

    public String getStadt() {
        return stadt;
    }

    public String getTelefonnummer() {
        return telefonnummer;
    }

    public String getBeschreibung() {
        return beschreibung;
    }

    public String getKategorie() {
        return kategorie;
    }

    public String getBranche() {
        return branche;
    }

    public String getTimestamp() {
        return timestamp;
    }

    public void setSteuernummer(String steuernummer) {
        this.steuernummer = steuernummer;
    }

    public void setUnternehmensName(String unternehmensName) {
        this.unternehmensName = unternehmensName;
    }

    public void setStraﬂe1UndNr(String straﬂe1UndNr) {
        this.straﬂe1UndNr = straﬂe1UndNr;
    }

    public void setStraﬂe2UndNr(String straﬂe2UndNr) {
        this.straﬂe2UndNr = straﬂe2UndNr;
    }

    public void setPostleitzahl(String postleitzahl) {
        this.postleitzahl = postleitzahl;
    }

    public void setLand(String land) {
        this.land = land;
    }

    public void setStadt(String stadt) {
        this.stadt = stadt;
    }

    public void setTelefonnummer(String telefonnummer) {
        this.telefonnummer = telefonnummer;
    }

    public void setBeschreibung(String beschreibung) {
        this.beschreibung = beschreibung;
    }

    public void setKategorie(String kategorie) {
        this.kategorie = kategorie;
    }

    public void setBranche(String branche) {
        this.branche = branche;
    }

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
