/*
 *  Copyright 2015 Adobe Systems Incorporated
 *
 *  Licensed under the Apache License, Version 2.0 (the "License");
 *  you may not use this file except in compliance with the License.
 *  You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 *  Unless required by applicable law or agreed to in writing, software
 *  distributed under the License is distributed on an "AS IS" BASIS,
 *  WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *  See the License for the specific language governing permissions and
 *  limitations under the License.
 */
package com.adobe.aem.guides.wknd.spa.vue.core.servlets;

import com.adobe.aem.guides.wknd.spa.vue.core.services.ServiceTransferConfig;
import org.apache.sling.api.SlingHttpServletRequest;
import org.apache.sling.api.SlingHttpServletResponse;
import org.apache.sling.api.servlets.HttpConstants;
import org.apache.sling.api.servlets.SlingAllMethodsServlet;
import org.apache.sling.api.servlets.SlingSafeMethodsServlet;
import org.apache.sling.servlets.annotations.SlingServletResourceTypes;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;
import org.osgi.service.component.propertytypes.ServiceDescription;

import javax.servlet.Servlet;
import javax.servlet.ServletException;
import javax.servlet.http.Cookie;

import java.io.IOException;
import java.nio.file.Path;

/**
 * Servlet that writes some sample content into the response. It is mounted for
 * all resources of a specific Sling resource type. The
 * {@link SlingSafeMethodsServlet} shall be used for HTTP methods that are
 * idempotent. For write operations use the {@link SlingAllMethodsServlet}.
 */
@Component(service = { Servlet.class }, property={"sling.servlet.methods=get", "sling.servlet.paths=/bin/ssoservlet"})
@SlingServletResourceTypes(
        resourceTypes="wknd-spa-vue/components/page",
        methods=HttpConstants.METHOD_GET,
        extensions="txt")
@ServiceDescription("SSO Servlet")
public class SetCookieServlet extends SlingSafeMethodsServlet {

    @Reference
    private ServiceTransferConfig serviceTransferConfig;

    private static final long serialVersionUID = 1L;

    @Override
    protected void doGet(final SlingHttpServletRequest req,
            final SlingHttpServletResponse resp) throws ServletException, IOException {

        String data = req.getParameter("data");
        Cookie cookie = new Cookie("data", data);
        
        cookie.setMaxAge(86400);
        cookie.setPath("/");

        resp.addCookie(cookie);
        resp.setContentType("text/plain");
        resp.getWriter().write("OK");
        resp.sendRedirect("https://www.google.com.br");
    }
}
