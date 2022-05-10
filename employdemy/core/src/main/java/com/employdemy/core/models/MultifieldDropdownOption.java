package com.employdemy.core.models;

import org.apache.sling.api.SlingHttpServletRequest;
import org.apache.sling.api.resource.Resource;
import org.apache.sling.models.annotations.DefaultInjectionStrategy;
import org.apache.sling.models.annotations.Model;
import org.apache.sling.models.annotations.injectorspecific.InjectionStrategy;
import org.apache.sling.models.annotations.injectorspecific.ValueMapValue;


 /**
  * Sling Model for multifiled section
  */
 @Model(adaptables = { SlingHttpServletRequest.class, Resource.class },
  defaultInjectionStrategy = DefaultInjectionStrategy.OPTIONAL)
public class MultifieldDropdownOption {
    
  /**
   * title
   */
  @ValueMapValue(name = "title", injectionStrategy = InjectionStrategy.OPTIONAL)
  private String title;

  /**@return
   * title
   */
   public final String title() {
   return title;
 }

   /**
   * description
   */
   @ValueMapValue(name = "description", injectionStrategy = InjectionStrategy.OPTIONAL)
   private String description;

    /**@return
     * description
     */
   public final String getDescription() {
     return description;
   }
}
