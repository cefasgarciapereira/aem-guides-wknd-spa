package com.adobe.aem.guides.wknd.spa.vue.core.servlets;

import com.day.cq.commons.jcr.JcrConstants;
import org.apache.sling.api.SlingHttpServletRequest;
import org.apache.sling.api.SlingHttpServletResponse;
import org.apache.sling.api.resource.Resource;
import org.apache.sling.api.servlets.HttpConstants;
import org.apache.sling.api.servlets.SlingAllMethodsServlet;
import org.apache.sling.api.servlets.SlingSafeMethodsServlet;
import org.apache.sling.servlets.annotations.SlingServletResourceTypes;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.propertytypes.ServiceDescription;

import javax.servlet.Servlet;
import javax.servlet.ServletException;
import java.io.IOException;

import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Scanner;

@Component(service = { Servlet.class }, property={"sling.servlet.methods=get", "sling.servlet.paths=/bin/products"})
@SlingServletResourceTypes(
        resourceTypes="wknd-spa-vue/components/page",
        methods=HttpConstants.METHOD_GET,
        extensions="json")
@ServiceDescription("Products Servlet")
public class DummyProductsServlet extends SlingSafeMethodsServlet {

    private static final long serialVersionUID = 1L;

    @Override
    protected void doGet(final SlingHttpServletRequest req,
            final SlingHttpServletResponse resp) throws ServletException, IOException {
        final Resource resource = req.getResource();
        resp.setCharacterEncoding("UTF-8");
        resp.setContentType("application/json");
        resp.getWriter().write(fetchData());
    }

    protected String fetchData(){
        try{
            String endpoint = "https://dummyjson.com/products";

            // Host url
            URL url = new URL(endpoint);
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
}