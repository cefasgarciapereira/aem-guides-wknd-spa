package com.adobe.aem.guides.wknd.spa.vue.core.models;
 
import com.adobe.cq.export.json.ComponentExporter;
 
public interface ImageCustomComponent extends ComponentExporter {
   public String getSrc();
   public String getAlt();
   public String getTitle();
}