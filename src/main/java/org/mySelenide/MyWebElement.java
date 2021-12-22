package org.mySelenide;

import static org.mySelenide.driver.DriverManager.driver;
import org.openqa.selenium.*;

import java.util.ArrayList;
import java.util.List;

public class MyWebElement {

    private WebElement element;

    public MyWebElement(By selector) {
        this.element = driver().findElement(selector);
    }

    public MyWebElement(WebElement element) {
        this.element = element;
    }

    public void click() {
        element.click();
    }

    public void sendKeys(CharSequence... keysToSend) {
        element.sendKeys(keysToSend);
    }

    public void clear() {
        element.clear();
    }

    public String getTagName() {
        return element.getTagName();
    }

    public String getAttribute(String name) {
        return element.getAttribute(name);
    }

    public boolean isSelected() {
        return element.isSelected();
    }

    public boolean isEnabled() {
        return element.isEnabled();
    }

    public String getText() {
        return element.getText();
    }

    public static List<MyWebElement> findElements(By by) {
        List<MyWebElement> elements = new ArrayList<>();
        for (WebElement item: driver().findElements(by)) {
            elements.add(new MyWebElement(item));
        }
        return elements;
    }

    public MyWebElement findElement(By by) {
        return new MyWebElement(element.findElement(by));
    }

    public String getCssValue(String propertyName) {
        return element.getCssValue(propertyName);
    }

    public WebElement inner() {
        return element;
    }
}
