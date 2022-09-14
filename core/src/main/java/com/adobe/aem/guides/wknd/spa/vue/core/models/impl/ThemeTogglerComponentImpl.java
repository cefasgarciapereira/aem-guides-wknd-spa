package com.adobe.aem.guides.wknd.spa.vue.core.models.impl;
 
import org.apache.sling.api.SlingHttpServletRequest;
import org.apache.sling.models.annotations.DefaultInjectionStrategy;
import org.apache.sling.models.annotations.Exporter;
import org.apache.sling.models.annotations.Model;
import org.apache.sling.models.annotations.injectorspecific.ValueMapValue;
 
import com.adobe.aem.guides.wknd.spa.vue.core.models.ThemeTogglerComponent;
import com.adobe.cq.export.json.ComponentExporter;
import com.adobe.cq.export.json.ExporterConstants;
 
@Model(
   adaptables = SlingHttpServletRequest.class,
   adapters = { ThemeTogglerComponent.class, ComponentExporter.class },
   resourceType = ThemeTogglerComponentImpl.RESOURCE_TYPE,
   defaultInjectionStrategy = DefaultInjectionStrategy.OPTIONAL)
@Exporter(
   name = ExporterConstants.SLING_MODEL_EXPORTER_NAME,
   extensions = ExporterConstants.SLING_MODEL_EXTENSION)
public class ThemeTogglerComponentImpl implements ThemeTogglerComponent {
 
   static final String RESOURCE_TYPE = "wknd-spa-vue/components/theme-toggler";
 
   @Override
   public String getExportedType() {
       return ThemeTogglerComponentImpl.RESOURCE_TYPE;
   }
}