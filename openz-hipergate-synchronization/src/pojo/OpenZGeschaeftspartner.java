/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package pojo;

import java.util.List;

/**
 *
 * @author Hawai
 */
public class OpenZGeschaeftspartner implements java.io.Serializable{

    /* Steuernummer des Unternehmens. Sollte eindeutig sein.*/
    public int steuernummer = -1;
    public String unternehmensName = null;;
    public String stra�e1UndNr = null;
    public String stra�e2UndNr = null;
    public int postleitzahl = -1;
    public String land= null;
    public String stadt = null;
    public int telefonnummer = -1;
    /* zus�tzliche Beschreibung die �bertragen wird. */
    public String beschreibung = null;
    /*Beschreibt den Bereich, in dem das Unternnehmen, dem HAWAICYLCE n�tzlich ist.
      Bisher sind nur die Kategorien Materialien, Dienstleistung und Sonstiges in Planung.*/
    public String kategorie;
    /* Beschreibt die Branche, in dem das Unternehmen t�tig ist,
     zum Beispiel Fahrradlenker oder Lederwaren usw.*/
    public String branche = null;
    public String timestamp = null;

    public OpenZGeschaeftspartner(){}

    public int getSteuernummer() {
        return steuernummer;
    }

    public String getUnternehmensName() {
        return unternehmensName;
    }

    public String getStra�e1UndNr() {
        return stra�e1UndNr;
    }

    public String getStra�e2UndNr() {
        return stra�e2UndNr;
    }

    public int getPostleitzahl() {
        return postleitzahl;
    }

    public String getLand() {
        return land;
    }

    public String getStadt() {
        return stadt;
    }

    public int getTelefonnummer() {
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

    public void setSteuernummer(int steuernummer) {
        this.steuernummer = steuernummer;
    }

    public void setUnternehmensName(String unternehmensName) {
        this.unternehmensName = unternehmensName;
    }

    public void setStra�e1UndNr(String stra�e1UndNr) {
        this.stra�e1UndNr = stra�e1UndNr;
    }

    public void setStra�e2UndNr(String stra�e2UndNr) {
        this.stra�e2UndNr = stra�e2UndNr;
    }

    public void setPostleitzahl(int postleitzahl) {
        this.postleitzahl = postleitzahl;
    }

    public void setLand(String land) {
        this.land = land;
    }

    public void setStadt(String stadt) {
        this.stadt = stadt;
    }

    public void setTelefonnummer(int telefonnummer) {
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
    
 
    
}
