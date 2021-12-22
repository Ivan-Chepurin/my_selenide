package org.mySelenide.driver;


import org.openqa.selenium.chrome.ChromeDriver;

public class DriverManager {

    private static MyDriver driver;

    public static void open(String url) {
        if (driver == null) {
            driver = MyDriver.getInstance();
        }
        driver.open(url);
    }

    public static void close() {
        driver.shutDown();
    }

    public static ChromeDriver driver() {
        return driver.driver();
    }

    public static void closeCurrentWindow() {
        driver.closeCurrentWindow();
    }

    public static void changeWindow(int number) {
        driver.changeWindow(number);
    }

    public static void cleanCookie() {
        driver.cleanCookie();
    }

    public static void closeAllWindows() {
        driver.closeAllWindows();
    }

    public static String getCurrentURL() {
        return driver.getCurrentURL();
    }
}
