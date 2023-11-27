package com.employdemy.core.models;

import org.apache.sling.api.SlingHttpServletRequest;
import org.apache.sling.api.resource.Resource;
import org.apache.sling.models.annotations.Exporter;
import org.apache.sling.models.annotations.DefaultInjectionStrategy;
import org.apache.sling.models.annotations.Model;
import org.apache.sling.models.annotations.injectorspecific.ValueMapValue;

import com.adobe.cq.export.json.ComponentExporter;
import com.adobe.cq.export.json.ExporterConstants;

import lombok.Getter;

@Getter
@Model(adaptables = {SlingHttpServletRequest.class, Resource.class},
  resourceType = {HeroCTAModel.RESOURCE_TYPE}, defaultInjectionStrategy = DefaultInjectionStrategy.OPTIONAL)
@Exporter(name = ExporterConstants.SLING_MODEL_EXPORTER_NAME, selector = ExporterConstants.SLING_MODEL_SELECTOR,  extensions = ExporterConstants.SLING_MODEL_EXTENSION)
public class HeroCTAModel implements ComponentExporter {

    static final String RESOURCE_TYPE = "employdemy/components/worldvision/hero-cta";
    
    @ValueMapValue
    private String heroCTADescription;

    @ValueMapValue
    private String heroCTAImage;

    @ValueMapValue
    private String heroCTAImageAltText;

    @Override
    public String getExportedType() {
        return HeroCTAModel.RESOURCE_TYPE;
    }

}
