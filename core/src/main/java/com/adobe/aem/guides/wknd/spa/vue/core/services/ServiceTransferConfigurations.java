package com.adobe.aem.guides.wknd.spa.vue.core.services;

import org.osgi.service.metatype.annotations.AttributeDefinition;
import org.osgi.service.metatype.annotations.ObjectClassDefinition;

@ObjectClassDefinition(name = "ECOM Service Transfer Configuration", description = "This configuration has the private key to decrypt the transfer data from MVE")
public @interface ServiceTransferConfigurations {
    /**
     * Returns the private key
     * 
     * @return {@link String}
     */
    @AttributeDefinition(name = "Private Key", description = "Enter the private key")
    public String getPrivateKey();
}