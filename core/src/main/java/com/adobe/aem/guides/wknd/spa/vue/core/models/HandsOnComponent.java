package com.adobe.aem.guides.wknd.spa.vue.core.models;
 
import com.adobe.cq.export.json.ComponentExporter;
 
public interface HandsOnComponent extends ComponentExporter {
   public String getTitle();
}