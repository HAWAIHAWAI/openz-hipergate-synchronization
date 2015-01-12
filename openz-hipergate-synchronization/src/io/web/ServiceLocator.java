package io.web;


import java.util.HashSet;
import java.util.Set;

import javax.ws.rs.ApplicationPath;
import javax.ws.rs.core.Application;


@ApplicationPath("/service")
public class ServiceLocator extends Application {
	  private Set<Class<?>> services;
	  
	  public ServiceLocator(){
		  System.err.println("***Service Locator instantiated***");
		  services = new HashSet<Class<?>>();
		  addService(BusinessPartnerGroupService.class);
		  addService(BusinessPartnerService.class);
	  }
	  
	  @Override
	  public Set<Class<?>> getClasses()
	  {
	    return services;
	  }
	  
	  public void addService(Class<?> service){
		    services.add(service);
	  }
	  
	  public void removeService(Class<?> service){
		  services.remove(service);
	  }
}
