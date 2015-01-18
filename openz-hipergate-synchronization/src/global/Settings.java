package global;

/**
 * Global settings for initialization.
 * 
 * @author cglaeser
 */
public class Settings {

	/**
	 * The URL (as String) where Hipergate is located.
	 */
	private String hipergateLocation;

	/**
	 * Retrieves the URL where Hipergate is located.
	 * 
	 * @return A url in the form "http://www.example.com/resourceIdentifier"
	 */
	public String getHipergateLocation() {
		return hipergateLocation;
	}

	/**
	 * Sets the URL where Hipergate is located.
	 * 
	 * @param location
	 *            A url in the form "http://www.example.com/resourceIdentifier"
	 */
	public void setHipergateLocation(String location) {
		hipergateLocation = location;
	}
}
