package com.employdemy.core.models;

import java.util.List;

import org.apache.sling.api.SlingHttpServletRequest;
import org.apache.sling.api.resource.Resource;
import org.apache.sling.models.annotations.DefaultInjectionStrategy;
import org.apache.sling.models.annotations.Exporter;
import org.apache.sling.models.annotations.Model;
import org.apache.sling.models.annotations.injectorspecific.ChildResource;
import org.apache.sling.models.annotations.injectorspecific.ValueMapValue;

import com.adobe.cq.export.json.ComponentExporter;
import com.adobe.cq.export.json.ExporterConstants;

import lombok.Getter;

@Getter
@Model(adaptables = {SlingHttpServletRequest.class, Resource.class},
  resourceType = {TextCtaModel.RESOURCE_TYPE}, defaultInjectionStrategy = DefaultInjectionStrategy.OPTIONAL)
@Exporter(name = ExporterConstants.SLING_MODEL_EXPORTER_NAME, selector = ExporterConstants.SLING_MODEL_SELECTOR,  extensions = ExporterConstants.SLING_MODEL_EXTENSION)
public class TextCtaModel implements ComponentExporter{

    static final String RESOURCE_TYPE = "employdemy/components/worldvision/textcta";

    @ValueMapValue
    private String heading;

    @ValueMapValue
    private String background;

    @ChildResource
    private List<ButtonFieldList> buttonField; 

    @Getter
    @Model(adaptables = Resource.class, defaultInjectionStrategy = DefaultInjectionStrategy.OPTIONAL)
    public static class ButtonFieldList{

    @ValueMapValue
    private String buttonText;

    @ValueMapValue
    private String buttonUrl;

    }

    @Override
    public String getExportedType() {
        return TextCtaModel.RESOURCE_TYPE;
    }
}
