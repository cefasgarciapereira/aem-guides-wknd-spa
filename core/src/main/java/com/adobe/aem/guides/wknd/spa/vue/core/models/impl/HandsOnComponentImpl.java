package com.adobe.aem.guides.wknd.spa.vue.core.models.impl;
 
import org.apache.sling.api.SlingHttpServletRequest;
import org.apache.sling.models.annotations.DefaultInjectionStrategy;
import org.apache.sling.models.annotations.Exporter;
import org.apache.sling.models.annotations.Model;
import org.apache.sling.models.annotations.injectorspecific.ValueMapValue;
 
import com.adobe.aem.guides.wknd.spa.vue.core.models.HandsOnComponent;
import com.adobe.cq.export.json.ComponentExporter;
import com.adobe.cq.export.json.ExporterConstants;
 
@Model(
   adaptables = SlingHttpServletRequest.class,
   adapters = { HandsOnComponent.class, ComponentExporter.class },
   resourceType = HandsOnComponentImpl.RESOURCE_TYPE,
   defaultInjectionStrategy = DefaultInjectionStrategy.OPTIONAL)
@Exporter(
   name = ExporterConstants.SLING_MODEL_EXPORTER_NAME,
   extensions = ExporterConstants.SLING_MODEL_EXTENSION)
public class HandsOnComponentImpl implements HandsOnComponent {
 
   static final String RESOURCE_TYPE = "wknd-spa-vue/components/hands-on";
    
    @ValueMapValue
    private String title;
 
   @Override
   public String getExportedType() {
       return HandsOnComponentImpl.RESOURCE_TYPE;
   }
 
   @Override
   public String getTitle() {
       return this.title;
   }
}