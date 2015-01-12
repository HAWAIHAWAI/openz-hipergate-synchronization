package io.web;

import io.hipergateSynchronization.Synchronization;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;

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
	    return Response.status(200).entity(outMsg).build();
	  }
	  
	  //TODO
	  @GET
	  @Path("/import/start")
	  @Produces("text/plain")
	  public Response startImport(){
		  StringBuilder sb = new StringBuilder().append("Import, ");
		  int numberOfMessages = 0; 
		  Synchronization.hipergatePull();
		  sb.append("NumberOfBusinessPartners edited: " + numberOfMessages);
		  return Response.status(200).entity(sb.toString()).build();
	  }
}