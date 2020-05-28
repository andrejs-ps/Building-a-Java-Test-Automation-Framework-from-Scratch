package com.framework.java11httpclient;

import com.testframework.PropertiesUtils;
import org.junit.jupiter.api.Test;

public class WebApiTestUsingConfigLoader {

    String baseUrl = PropertiesUtils.getProperty("api_config.properties", "baseurl");

    @Test
    void doSomethingUseful() {

        System.out.println(baseUrl);

        // use the URL to make requests
    }


}
