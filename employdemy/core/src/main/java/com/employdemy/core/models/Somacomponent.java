package com.employdemy.core.models;   

import org.apache.sling.api.SlingHttpServletRequest;
import org.apache.sling.api.resource.Resource;
import org.apache.sling.models.annotations.Model;
import org.apache.sling.models.annotations.injectorspecific.ValueMapValue;
import org.apache.sling.models.annotations.DefaultInjectionStrategy;

 @Model(adaptables = { SlingHttpServletRequest.class, Resource.class },
  defaultInjectionStrategy = DefaultInjectionStrategy.OPTIONAL)
public class Somacomponent {
    @ValueMapValue
    private String name;
 
	@ValueMapValue
    private String sirname;


      public String getName() {
		return name;
	}

	public String getSirname() {
		return sirname;
	}
}
