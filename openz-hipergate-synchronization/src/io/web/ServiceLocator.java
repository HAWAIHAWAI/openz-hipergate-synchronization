package io.web;


import java.util.HashSet;
import java.util.Set;

import javax.ws.rs.ApplicationPath;
import javax.ws.rs.core.Application;


@ApplicationPath("/service")
public class ServiceLocator extends Application {
	  @Override
	  public Set<Class<?>> getClasses()
	  {
	    Set<Class<?>> s = new HashSet<Class<?>>();
	    s.add(BusinessPartnerService.class);
	    return s;
	  }
}
