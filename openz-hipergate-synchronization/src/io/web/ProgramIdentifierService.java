package io.web;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;

/**
 * Small service for identifying the service program.
 * @author HAWAI
 *
 */
@Path("/programIdentifier")
public class ProgramIdentifierService {
	
	  /**
	   * Returns a simple String with the name of the program.
	   * @return Simple String with the name of the program.
	   */
	  @GET
	  @Produces("text/html")
	  public Response getProgramName()
	  {
		String outMsg = "openz-hipergate-synchronization";
	    return Response.status(200).entity(outMsg).build();
	  }

}
