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

@Path("/businessPartner")
public class BusinessPartnerService {

	  @GET
	  @Produces("text/xml")
	  public Response getMessage()
	  {
		System.out.println(io.xml.BusinessPartnerXML.getAllBusinessPartners());
	    String outMsg = io.xml.BusinessPartnerXML.getAllBusinessPartners();
	    return Response.status(200).entity(outMsg).build();
	  }
	
	  @GET
	  @Path("/id/{id}")
	  @Produces("text/xml")
	  public Response getMessage(@PathParam("id") String id)
	  {
	    String outMsg = io.xml.BusinessPartnerXML.getBusinessPartnerByID(id);
	    return Response.status(200).entity(outMsg).type(MediaType.TEXT_HTML).build();
	  }
	  
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