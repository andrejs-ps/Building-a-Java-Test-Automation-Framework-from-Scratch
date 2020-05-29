package framework.java11httpclient;

import org.junit.jupiter.api.Test;
import test.framework.PropertiesUtils;

public class WebApiTestUsingConfigLoader {

    String baseUrl = PropertiesUtils.getProperty("api_config.properties", "baseurl");

    @Test
    void doSomethingUseful() {

        System.out.println(baseUrl);

        // use the URL to make requests
    }
}
