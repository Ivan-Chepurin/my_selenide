package org.mySelenide;

import org.mySelenide.driver.DriverManager;
import org.openqa.selenium.By;

import java.util.Calendar;
import java.util.List;

import static org.mySelenide.Selectors.byXpath;
import static org.mySelenide.Selectors.cssSelector;

public class MySelenide {

    public static void open(String url) {
        DriverManager.open(url);
    }

    public static void close() {
        DriverManager.close();
    }

    public static MyWebElement $(By selector) {
        return new MyWebElement(selector);
    }

    public static MyWebElement $(String cssSelector) {
        return new MyWebElement(cssSelector(cssSelector));
    }

    public static MyWebElement $x(String xPath) {
        return new MyWebElement(byXpath(xPath));
    }

    public static List<MyWebElement> $$(By selector) {
        return MyWebElement.findElements(selector);
    }

    public static List<MyWebElement> $$(String cssSelector) {
        return MyWebElement.findElements(cssSelector(cssSelector));
    }

    public static List<MyWebElement> $$x(String xPath) {
        return MyWebElement.findElements(byXpath(xPath));
    }
}
