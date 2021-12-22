package org.mySelenide.properties;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class ConfProperties {
    private static Properties PROPERTIES;

    static {
        try (FileInputStream stream = new FileInputStream("src\\main\\resources\\config.properties")) {
            PROPERTIES = new Properties();
            PROPERTIES.load(stream);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static String getProperty(String key) {
        return PROPERTIES.getProperty(key);
    }

}
