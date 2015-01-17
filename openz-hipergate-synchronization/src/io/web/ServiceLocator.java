package io.web;


import java.util.HashSet;
import java.util.Set;

import javax.ws.rs.ApplicationPath;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Application;
import javax.ws.rs.core.Response;

/**
 * Application for the service of receiving BusinessPartners.
 * @author HAWAI
 *
 */
@ApplicationPath("/service")
public class ServiceLocator extends Application {
	  private Set<Class<?>> services;
	  
	  /**
	   * Constructor for the ServiceLocator.
	   * As default the BusinessPartnerGroupService and the
	   * BusinessParterService are set.
	   */
	  public ServiceLocator(){
		  System.err.println("***Service Locator instantiated***");
		  services = new HashSet<Class<?>>();
		  addService(BusinessPartnerGroupService.class);
		  addService(BusinessPartnerService.class);
		  addService(ProgramIdentifierService.class);
	  }
	  
	  /**
	   * Retrieves the classes of this ServiceLocator as a Set.
	   */
	  @Override
	  public Set<Class<?>> getClasses()
	  {
	    return services;
	  }
	  
	  /**
	   * Adds an additional service to this ServiceLocater-object.
	   * @param service
	   */
	  public void addService(Class<?> service){
		    services.add(service);
	  }
	  
	  /**
	   * Removes a service from this ServiceLocator-object.
	   * @param service
	   */
	  public void removeService(Class<?> service){
		  services.remove(service);
	  }
}
