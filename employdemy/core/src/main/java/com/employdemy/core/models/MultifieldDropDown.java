package com.employdemy.core.models;

import org.apache.sling.api.SlingHttpServletRequest;
import org.apache.sling.api.resource.Resource;
import org.apache.sling.models.annotations.DefaultInjectionStrategy;
import org.apache.sling.models.annotations.Exporter;
import org.apache.sling.models.annotations.Model;
import org.apache.sling.models.annotations.injectorspecific.ChildResource;
import org.apache.sling.models.annotations.injectorspecific.InjectionStrategy;
import org.apache.sling.models.annotations.injectorspecific.ValueMapValue;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import javax.annotation.PostConstruct;


 /**
  * Sling Model for multifield
  */
 @Model(adaptables = { SlingHttpServletRequest.class, Resource.class },
  resourceType = { "employdemy/components/multifield" },
  defaultInjectionStrategy = DefaultInjectionStrategy.OPTIONAL)
  @Exporter(name = "jackson", extensions = "json")
public class MultifieldDropDown {
    
    /**
     * log variable
     */
  private static final Logger LOG = LoggerFactory.getLogger(MultifieldDropDown.class);
  /**
    * list
    */
  private List<MultifieldDropdownOption> options;

   /**
    * currencyToggle
    */
    @ValueMapValue(name = "title", injectionStrategy = InjectionStrategy.OPTIONAL)
    private String title;

  /**
    * childResource
    */

  @ChildResource(name = "multifieldOptions")
  private Resource multifieldOptions;

/**@return
    * getter
    */
  public final Resource getMultifieldOptions() {
    return multifieldOptions;
  }
/**@return
    * getter
    */
    public final List<MultifieldDropdownOption> getMultifields() {
        return this.options;
    }

  /**
    * init method
    */
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
   
  /**@return
    * title
    */
  public final String getTitle() {
    return title;
  }
}
