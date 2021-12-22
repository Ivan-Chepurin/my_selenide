package org.mySelenide.driver;

import org.mySelenide.properties.ConfProperties;
import org.openqa.selenium.chrome.ChromeDriver;

import javax.xml.datatype.Duration;
import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

public class MyDriver {

    private static MyDriver instance;

    private ChromeDriver driver;
    private ArrayList<String> tabs = new ArrayList<>();

    private MyDriver() {
        System.setProperty("webdriver.chrome.driver", ConfProperties.getProperty("driverPath"));
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);
        System.out.println(driver.getWindowHandle());
    }

    public static MyDriver getInstance() {
        if (instance == null) {
            instance = new MyDriver();
        }
        return instance;
    }

    public void open(String url) {
        if (url.length() > 0) {
            driver.get(url);
        }
    }

    public void shutDown() {
        System.out.println(driver.getWindowHandle());
        closeAllWindows();
        driver.quit();
        instance = null;
    }

    public ChromeDriver driver() {
        return driver;
    }

    public void closeAllWindows() {
        checkTabs();
        for (String handle : driver().getWindowHandles()) {
            tabs.remove(handle);
            driver.switchTo().window(handle);
            driver.close();
        }
    }

    public void closeCurrentWindow() {
        checkTabs();
        tabs.remove(driver.getWindowHandle());
        driver.close();
        if (tabs.size() > 0) {
            driver.switchTo().window(tabs.get(tabs.size() - 1));
        }
    }


    public void changeWindow(int number) {
        checkTabs();
        number--;
        if (number >= 0 && number < tabs.size() && number != tabs.indexOf(driver.getWindowHandle())) {
            driver.switchTo().window(tabs.get(number));
        }
    }

    private void checkTabs() {
        if (tabs.size() < driver.getWindowHandles().size()) {
            for (String handle : driver.getWindowHandles()) {
                if (tabs.contains(handle)) continue;
                tabs.add(handle);
            }
        }
    }

    public void cleanCookie() {
        driver.manage().deleteAllCookies();
    }

    public String getCurrentURL() {
        return driver.getCurrentUrl();
    }
}
