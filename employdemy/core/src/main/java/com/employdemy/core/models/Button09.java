package com.employdemy.core.models;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.annotation.PostConstruct;

import org.apache.sling.api.resource.Resource;
import org.apache.sling.models.annotations.Model;
import org.apache.sling.models.annotations.injectorspecific.ChildResource;
import org.apache.sling.models.annotations.injectorspecific.InjectionStrategy;
import org.apache.sling.models.annotations.injectorspecific.ValueMapValue;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


@Model(adaptables = Resource.class)
public class Button09 {
 
@ValueMapValue
private String label;

@ValueMapValue
private String cssClass;

@ValueMapValue
private String linkTo;


public String getLinkTo() {
    return linkTo;
}

public String getLabel() {
    return label;
}

public String getCssClass() {
    return cssClass;
}

@ValueMapValue(name = "title", injectionStrategy = InjectionStrategy.OPTIONAL)
  private String title;

  public final String title() {
    return title;
  }

@ValueMapValue(name = "description", injectionStrategy = InjectionStrategy.OPTIONAL)
  private String description;

  public final String getDescription() {
    return description;
  }

   private static final Logger LOG = LoggerFactory.getLogger(Button09.class);

   private List<MultifieldDropdownOption> options;

    @ChildResource(name = "multifieldOptions")
  private Resource multifieldOptions;

  public final Resource getMultifieldOptions() {
    return multifieldOptions;
  }
    public final List<MultifieldDropdownOption> getMultifields() {
        return this.options;
    }

      @PostConstruct
   protected final void init() {
    options = new ArrayList<>();
    if (multifieldOptions != null) {
      Iterator<Resource> iterator = multifieldOptions.listChildren();
      while (iterator.hasNext()) {
          Resource child = iterator.next();
          MultifieldDropdownOption MultifieldDropdownOption = child.adaptTo(MultifieldDropdownOption.class);
          options.add(MultifieldDropdownOption);
      }
  }
    LOG.error("unexcepted error");
   }
  
}
