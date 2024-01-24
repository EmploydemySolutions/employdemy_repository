// package com.employdemy.core.models;

// import java.util.ArrayList;
// import java.util.HashMap;
// import java.util.Iterator;
// import java.util.List;
// import java.util.Map;
// import javax.annotation.PostConstruct;
// import javax.inject.Inject;
// import com.employdemy.core.models.impl.TextUrlNestedList;
// import org.apache.sling.api.SlingHttpServletRequest;
// import org.apache.sling.api.resource.Resource;
// import org.apache.sling.models.annotations.DefaultInjectionStrategy;
// import org.apache.sling.models.annotations.Model;
// import org.apache.sling.models.annotations.injectorspecific.ChildResource;
// import org.apache.sling.models.annotations.injectorspecific.ValueMapValue;
// import org.slf4j.Logger;
// import org.slf4j.LoggerFactory;


// @Model( adaptables = {Resource.class,SlingHttpServletRequest.class},
//  defaultInjectionStrategy = DefaultInjectionStrategy.OPTIONAL)
// public class SubNavigationModel {

//     private static final Logger LOGGER = LoggerFactory.getLogger(SubNavigationModel.class);  ///calling logger class

//     /** The aria label for hamburger icon. */
//     @ValueMapValue (name ="morelabel")       //read the author diaglog fields or values
//     private String moreLabel;

//     @ChildResource(name ="primaryLinks")   //calling field from slightly to sling and reading the multifield resources and converting into valuemap
//     Resource primaryLinksResource;
//     /**
//      *  primaryLinks.
//      */

//         private List<Map<String, String>> primaryLinks;     

        
    
//         @Inject
//         private List<TextUrlNestedList> content;

//         public List<TextUrlNestedList> getContent() {
//          return content;
// }

       

//     /**
//      * Init method of GlobalNavigationModel. and Nested Multifield
//      */
//      @PostConstruct                        ///calling java main class or it will call after all anotation trigered
//          protected void init() {              //assign  list obj
//          primaryLinks = getPrimaryLinks();
//          // Strart implementation for Nested Multifield
//          content = new ArrayList<>();
//          Resource currentResource = primaryLinksResource.getChild("item0").getChild("content");
//              if (currentResource != null) {
//                 Iterator<Resource> childResource = currentResource.listChildren();
//              while (childResource.hasNext()) {
//                 Resource childNode = childResource.next();
//                 TextUrlNestedList multi = childNode.adaptTo(TextUrlNestedList.class);
//                 content.add(multi);
//             }
//         }
//         // End 
        
//     }
    
//     public List<Map<String, String>> getPrimaryLinks() {
//         List<Map<String, String>> primaryLinks=new ArrayList<>();       ///Create list obj 
//         try {
//             if(primaryLinksResource!=null){                            ///checking the resources null or not
//                 for (Resource primaryResource : primaryLinksResource.getChildren()) {           ///iterating the resources    
//                     Map<String,String> primaryResourceMap=new HashMap<>();                       ///creating map obj
//                     primaryResourceMap.put("label",primaryResource.getValueMap().get("label",String.class));  ///reading data and resources fields to map 
//                     primaryResourceMap.put("url",primaryResource.getValueMap().get("url",String.class));      
//                     primaryResourceMap.put("page",primaryResource.getValueMap().get("page",String.class)); 
//                     primaryLinks.add(primaryResourceMap);
//                 }
//         }
//         }catch (Exception e){
//             LOGGER.info("\n ERROR while getting Book Details {} ",e.getMessage());
//         }                                                                              //if any error it will catch
//         LOGGER.info("\n SIZE {} ",primaryLinks.size());
//         return primaryLinks;                                          //checking data in custom logs
//     }

  

//     public String getMoreLabel() {
//         return moreLabel;
//     }
    
// }
