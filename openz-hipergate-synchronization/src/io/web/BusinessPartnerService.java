package io.web;

import java.util.List;

import io.database.LogEntryUtil;
import io.hipergateSynchronization.Synchronization;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import pojo.LogEntry;

/**
 * 
 * Service related to BusinessPartner(s).
 * @author HAWAI
 *
 */
@Path("/businessPartner")
public class BusinessPartnerService {

	/**
	 * Retrieves the BusinessPartners as GET-response (xml-style).
	 * @return BusinessPartners information as xml-file.
	 */
	  @GET
	  @Produces("text/xml")
	  public Response getMessage()
	  {
		System.out.println(io.xml.BusinessPartnerXML.getAllBusinessPartners());
	    String outMsg = io.xml.BusinessPartnerXML.getAllBusinessPartners();
	    return Response.status(200).entity(outMsg).build();
	  }
	
	  /**
	   * Retrieves a specific BusinessPartner as GET-Response(text-html-style).
	   * @param id The id to specifiy the BusinessPartner.
	   * @return BusinessPartner information as text-html.
	   */
	  @GET
	  @Path("/id/{id}")
	  @Produces("text/xml")
	  public Response getMessage(@PathParam("id") String id)
	  {
	    String outMsg = io.xml.BusinessPartnerXML.getBusinessPartnerByID(id);
	    return Response.status(200).entity(outMsg).type(MediaType.TEXT_HTML).build();
	  }
	  

	  
	  /**
	   * Starts the import for BusinessPartners. Pulls the BusinessPartners from the
	   * Message Queue and persists the entries into the OpenZ-DB.
	   * @return Logfile as text-html.
	   */
	  //TODO
	  @GET
	  @Path("/import/start")
	  @Produces("text/plain")
	  public Response startImport(){
		  StringBuilder sb = new StringBuilder().append("<!DOCTYPE html><html><head><title>Import successful</title></head><body><p><b>Import</b><p> ");
		  Synchronization.hipergatePull();
		  sb.append("<p>BusinessPartners edited!</p>");
		  sb.append("<em>Logfile</em>");
		  List<LogEntry> logs = LogEntryUtil.getAllLogEntries();
		  for(LogEntry entry: logs){
			  sb.append("<p>"+entry+"</p>");
		  }
		  sb.append("</body></html>");
		  
		  return Response.status(200).entity(sb.toString()).type(MediaType.TEXT_HTML).build();
	  }
}