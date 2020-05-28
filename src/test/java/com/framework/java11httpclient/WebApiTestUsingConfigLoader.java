package com.framework.java11httpclient;

import org.junit.jupiter.api.Test;
import org.junit.platform.commons.util.StringUtils;

import java.io.IOException;
import java.io.UncheckedIOException;
import java.util.Properties;

public class WebApiTestUsingConfigLoader {

    String baseUrl = getProperty("api_config.properties", "baseurl");

    public static String getProperty(String file, String key){
        Properties prop = new Properties();
        try {
            //load a properties file from class path, inside static method
            prop.load(WebApiTestUsingConfigLoader.class.getClassLoader().getResourceAsStream(file));
        }
        catch (IOException ex) {
            throw new UncheckedIOException(ex);
        }
        return prop.getProperty(key);
    }

    @Test
    void doSomethingUseful() {

        System.out.println(baseUrl);

        // use the URL to make requests
    }


}
