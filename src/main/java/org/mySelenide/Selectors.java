package org.mySelenide;

import org.openqa.selenium.By;

public class Selectors {

    public static By byXpath(String xpath) {
        return By.xpath(xpath);
    }

    public static By cssSelector(String cssSelector) {
        return By.cssSelector(cssSelector);
    }
}
