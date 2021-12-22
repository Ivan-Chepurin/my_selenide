package mailTest;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class TestProps {

    private final static Properties PROPERTIES = new Properties();

    static {
        try (FileInputStream stream = new FileInputStream("src/test/resources/test.properties")) {
            PROPERTIES.load(stream);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static String getProp(String key) {
        return PROPERTIES.getProperty(key);
    }
}
