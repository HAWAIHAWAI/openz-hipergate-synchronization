package io.web;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;

/**
 * Service related to BusinessPartnerGroup(s).
 * @author HAWAI
 *
 */
@Path("/businessPartnerGroup")
public class BusinessPartnerGroupService {

	/**
	 * Retrieves the BusinessPartnerGroups as GET-response (xml-style).
	 * @return BusinessPartners information as xml-file.
	 */
	  @GET
	  @Path("/")
	  @Produces("text/xml")
	  public Response getMessage()
	  {
	    String outMsg = io.xml.BusinessPartnerGroupXML.getAllBusinessPartnerGroups();
	    return Response.status(200).entity(outMsg).build();
	  }
	
	  /**
	   * Retrieves a specific BusinessPartnerGroup as GET-Response(xml-style).
	   * @param id The id to specifiy the BusinessPartnerGroup.
	   * @return BusinessPartner information as xml-file.
	   */
	  @GET
	  @Path("/id/{id}")
	  @Produces("text/xml")
	  public Response getMessage(@PathParam("id") String id)
	  {
	    String outMsg = io.xml.BusinessPartnerGroupXML.getBusinessPartnerGroupByID(id);
	    return Response.status(200).entity(outMsg).build();
	  }
}
