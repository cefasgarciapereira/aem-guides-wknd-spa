package com.adobe.aem.guides.wknd.spa.vue.core.servlets;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;

import com.adobe.aem.guides.wknd.spa.vue.core.services.ServiceTransferConfig;

import io.wcm.testing.mock.aem.junit5.AemContextExtension;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

@DisplayName("Simple Servlet Tests")
@ExtendWith(AemContextExtension.class)
class SimpleServletTest {

    private ServiceTransferConfig mockedServiceTransferConfig = mock(ServiceTransferConfig.class);
    private String PRIVATE_KEY = "abc123";

    @Test
    @DisplayName("Should get the private key")
    void testGetToken() {
        when(mockedServiceTransferConfig.getPrivateKey()).thenReturn(this.PRIVATE_KEY);
        assertEquals(this.PRIVATE_KEY, mockedServiceTransferConfig.getPrivateKey());
    }
}
