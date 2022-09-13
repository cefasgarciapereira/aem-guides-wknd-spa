package com.adobe.aem.guides.wknd.spa.vue.core.models.impl;
 
import org.apache.sling.api.SlingHttpServletRequest;
import org.apache.sling.models.annotations.DefaultInjectionStrategy;
import org.apache.sling.models.annotations.Exporter;
import org.apache.sling.models.annotations.Model;
import org.apache.sling.models.annotations.injectorspecific.ValueMapValue;
 
import com.adobe.aem.guides.wknd.spa.vue.core.models.HandsOnComponent;
import com.adobe.cq.export.json.ComponentExporter;
import com.adobe.cq.export.json.ExporterConstants;

import javax.annotation.PostConstruct;

import java.io.File;  // Import the File class
import java.io.FileWriter;   // Import the FileWriter class
import java.io.IOException;  // Import the IOException class to handle errors

import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Scanner;
 
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

   private String fetchData(String query){
      try{
         // Host url
         URL url = new URL("https://api.publicapis.org/entries?title="+query);
         HttpURLConnection conn = (HttpURLConnection) url.openConnection();
         conn.setRequestMethod("GET");
         conn.connect();

         //Getting the response code
         int responsecode = conn.getResponseCode();

         if (responsecode != 200) {
            return "Error: Response code is not 200";
         } else {

            String inline = "";
            Scanner scanner = new Scanner(url.openStream());

            //Write all the JSON data into a string using a scanner
            while (scanner.hasNext()) {
               inline += scanner.nextLine();
            }

            //Close the scanner
            scanner.close();

            return inline;
         }
      }catch(IOException e){
         return "Erro na chamada à API";
      }
   }

   @PostConstruct
   private void init(){
      try {
         File myObj = new File("handson.txt");
         FileWriter myWriter = new FileWriter("handson.txt");
         String content = fetchData(getTitle());
         myWriter.write(content);
         myWriter.close();
      } catch (IOException e) {
         System.out.println("An error occurred.");
         e.printStackTrace();
      }
   }
}