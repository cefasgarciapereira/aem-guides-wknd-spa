package com.adobe.aem.guides.wknd.spa.vue.core.models.impl;
 
import org.apache.sling.api.SlingHttpServletRequest;
import org.apache.sling.models.annotations.DefaultInjectionStrategy;
import org.apache.sling.models.annotations.Exporter;
import org.apache.sling.models.annotations.Model;
import org.apache.sling.models.annotations.injectorspecific.ValueMapValue;
 
import com.adobe.aem.guides.wknd.spa.vue.core.models.ImageCustomComponent;
import com.adobe.cq.export.json.ComponentExporter;
import com.adobe.cq.export.json.ExporterConstants;
 
@Model(
   adaptables = SlingHttpServletRequest.class,
   adapters = { ImageCustomComponent.class, ComponentExporter.class },
   resourceType = ImageCustomComponentImpl.RESOURCE_TYPE,
   defaultInjectionStrategy = DefaultInjectionStrategy.OPTIONAL)
@Exporter(
   name = ExporterConstants.SLING_MODEL_EXPORTER_NAME,
   extensions = ExporterConstants.SLING_MODEL_EXTENSION)
public class ImageCustomComponentImpl implements ImageCustomComponent {
 
   static final String RESOURCE_TYPE = "wknd-spa-vue/components/image-custom";
 
   @ValueMapValue
   private String src;
 
   @ValueMapValue
   private String alt;
    
   @ValueMapValue
   private String title;
 
   @Override
   public String getExportedType() {
       return ImageCustomComponentImpl.RESOURCE_TYPE;
   }
 
   @Override
   public String getSrc() {
       return this.src;
   }
 
   @Override
   public String getAlt() {
       return this.alt;
   }
 
   @Override
   public String getTitle() {
       return this.title;
   }
}