package com.adobe.aem.guides.wknd.spa.vue.core.services.impl;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.metatype.annotations.Designate;
import org.osgi.service.component.annotations.Activate;

import com.adobe.aem.guides.wknd.spa.vue.core.services.ServiceTransferConfig;
import com.adobe.aem.guides.wknd.spa.vue.core.services.ServiceTransferConfigurations;

@Component(name = "com.adobe.aem.guides.wknd.spa.vue.core.services.serviceTransferConfig", service = ServiceTransferConfig.class)
@Designate(ocd = ServiceTransferConfigurations.class)
public class ServiceTransferConfigImpl implements ServiceTransferConfig {
    private String privateKey;

    @Activate
    protected void activate(ServiceTransferConfigurations configuration) {
        this.privateKey = configuration.getPrivateKey();
    }

    @Override
    public String getPrivateKey() {
        return this.privateKey;
    }
}