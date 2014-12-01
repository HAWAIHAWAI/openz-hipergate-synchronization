package global;

import java.io.File;
import java.net.URL;

/**
 * Globale Einstellungen für die Programinitalisierung
 * @author cglaeser
 */
public class Settings {
	
	/**
	 * The url where the openz-export web site is located
	 */
	private String hipergateLocation;

	
	/**
	 * @return A url in the form "http://www.example.com/resourceIdentifier"
	 */
	public String getHipergateLocation() {
		return hipergateLocation;
	}
	/**
	 * @param newUrl A url in the form "http://www.example.com/resourceIdentifier"
	 */
	public void setHipergateLocation(String location) {
		hipergateLocation = location;
	}
}
