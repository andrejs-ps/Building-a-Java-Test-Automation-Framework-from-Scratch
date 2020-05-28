package test.framework;

import java.io.IOException;
import java.io.UncheckedIOException;
import java.util.Properties;

public class PropertiesUtils {


    public static String getProperty(String file, String key){
        Properties prop = new Properties();
        try {
            //load a properties file from class path, inside static method
            prop.load(PropertiesUtils.class.getClassLoader().getResourceAsStream(file));
        }
        catch (IOException ex) {
            throw new UncheckedIOException(ex);
        }
        return prop.getProperty(key);
    }
}
