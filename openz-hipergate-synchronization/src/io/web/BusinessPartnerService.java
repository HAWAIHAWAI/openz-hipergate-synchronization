package io.web;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;

import database.BusinessPartnerUtil;

@Path("/businessPartner")
public class BusinessPartnerService {

	  @GET
	  @Path("/")
	  @Produces("text/xml")
	  public Response getMessage()
	  {
	    String outMsg = io.xml.BusinessPartnerXML.getAllBusinessPartners();
	    return Response.status(200).entity(outMsg).build();
	  }
	
	  @GET
	  @Path("/{id}")
	  @Produces("text/xml")
	  public Response getMessage(@PathParam("id") String id)
	  {
	    String outMsg = io.xml.BusinessPartnerXML.getBusinessPartnerByID(id);
	    return Response.status(200).entity(outMsg).build();
	  }
}
