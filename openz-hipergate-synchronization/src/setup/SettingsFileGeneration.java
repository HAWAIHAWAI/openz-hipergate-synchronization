package setup;


import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.net.MalformedURLException;
import java.net.URL;

import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.io.xml.DomDriver;

import global.FileOperations;
import global.Settings;

/**
 * @author Christian Gl�ser
 * Intended to generate the XML settings files
 */
public class SettingsFileGeneration {
	
	/**
	 * Location of Hipergate.
	 */
	private String hipergateLocation;

	/**
	 * Default values
	 */
	public SettingsFileGeneration(){
		hipergateLocation = "localhost";
	}
	
	/**
	 * Custom values
	 * @param url The url for creating the XML scaffold
	 * @param updateInterval The update interval in seconds
	 * @param folderLocation The folder location 
	 */
	public SettingsFileGeneration(String hipergateLocation){
		this.hipergateLocation = hipergateLocation;
	}
	
	/**
	 * Generates the XML scaffold
	 * @return A string with the generated XML file as content
	 */
	public String generateXMLScaffold(){
		Settings settings = new Settings();
		settings.setHipergateLocation(hipergateLocation);
        XStream xStream = new XStream(new DomDriver());
        xStream.alias("settings", Settings.class);
        return xStream.toXML(settings);
	}
	
    /**
     * Creates a XML scaffold with default values
     * @param args arguments for XMLScaffoldGeneration - currently none
     * @throws UnsupportedEncodingException The character encoding is not supported
     * @throws FileNotFoundException File path could not be opened
     */
    public static void main(String[] args) throws FileNotFoundException, UnsupportedEncodingException
    {
        SettingsFileGeneration xmlScaffold = new SettingsFileGeneration();
        PrintWriter writer = new PrintWriter("settings.xml", "UTF-8");
        writer.println(xmlScaffold.generateXMLScaffold());
        writer.close();
    }
}
