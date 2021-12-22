package mailTest;

import org.junit.jupiter.api.Test;
import org.mySelenide.MyWebElement;

import java.util.List;

import static mailTest.TestProps.getProp;
import static org.mySelenide.MySelenide.*;
import static org.mySelenide.Selectors.*;
import static org.mySelenide.driver.DriverManager.open;
import static org.mySelenide.driver.DriverManager.changeWindow;
import static org.mySelenide.driver.DriverManager.closeCurrentWindow;
import static org.mySelenide.driver.DriverManager.getCurrentURL;

public class MailTest {

    @Test
    public void ALoginAndLogout() {
        open(getProp("homePage"));

        $(byXpath("//*[@data-statlog=\"notifications.mail.logout.enter\"]")).click();

        if (!getCurrentURL().contains(getProp("passwordPage"))) {
            $x("//input[@type=\"text\"]").sendKeys(getProp("login"));
            $x("//button[@data-t=\"button:action:passp:sign-in\"]").click();
        }

        $x("//input[@data-t=\"field:input-passwd\"]").sendKeys(getProp("password"));
        $x("//*[contains(@data-t, \"button:\")]").click();


        $x("//a[@aria-haspopup=\"true\"]").click();
        $x("//a[@data-statlog=\"mail.login.usermenu.exit\"]").click();
    }

    @Test
    public void SendMail() {
        open(getProp("homePage"));

        $(byXpath("//*[@data-statlog=\"notifications.mail.logout.enter\"]")).click();

        if (!getCurrentURL().contains(getProp("passwordPage"))) {
            $x("//input[@type=\"text\"]").sendKeys(getProp("login"));
            $x("//button[@data-t=\"button:action:passp:sign-in\"]").click();
        }

        $x("//input[@data-t=\"field:input-passwd\"]").sendKeys(getProp("password"));
        $x("//*[contains(@data-t, \"button:\")]").click();

        $x("//a[@data-statlog=\"notifications.mail.login.inbox.unread\"]").click();

        changeWindow(2);


        $x("//a[contains(@class, \"mail-ComposeButton\")]").click();

        $x("//div[@class=\"composeYabbles\"]").sendKeys(getProp("email"));

        $x("//input[@class=\"composeTextField ComposeSubject-TextField\"]").sendKeys(getProp("theme"));
        $x("//div[@role=\"textbox\"]").sendKeys(getProp("text"));
        $x("//button[@class=\"Button2 Button2_pin_circle-circle Button2_view_default Button2_size_l\"]").click();

        $x("//span[@data-click-action=\"mailbox.check\"]").click();


        $x("//a[@href=\"https://yandex.ru\"]").click();

        changeWindow(3);

        $x("//a[@aria-haspopup=\"true\"]").click();
        $x("//a[@data-statlog=\"mail.login.usermenu.exit\"]").click();

        closeCurrentWindow();
        closeCurrentWindow();
    }

    @Test
    public void DeleteTodayMails() {
        open(getProp("homePage"));

        $(byXpath("//*[@data-statlog=\"notifications.mail.logout.enter\"]")).click();

        if (!getCurrentURL().contains(getProp("passwordPage"))) {
            $x("//input[@type=\"text\"]").sendKeys(getProp("login"));
            $x("//button[@data-t=\"button:action:passp:sign-in\"]").click();
        }

        $x("//input[@data-t=\"field:input-passwd\"]").sendKeys(getProp("password"));
        $x("//*[contains(@data-t, \"button:\")]").click();

        $x("//a[@data-statlog=\"notifications.mail.login.inbox.unread\"]").click();

        changeWindow(2);

        List<MyWebElement> dates = $$x("//span[@class=\"mail-MessageSnippet-Item_dateText\"]");
        List<MyWebElement> checkBoxes = $$x("//span[@class=\"_nb-checkbox-flag _nb-checkbox-normal-flag\"]");
        System.out.println("dates - " + dates.size() + " | checkBoxes - " + checkBoxes.size());
        for (int i = 0; i < dates.size(); i++) {

            System.out.println(dates.get(i).getAttribute("innerHTML"));

            if (dates.get(i).getAttribute("title").contains("сегодня")) {
                checkBoxes.get(i).click();
            }
        }
        $x("//span[contains(@class, \"js-toolbar-item-title-delete\")]").click();
        $x("//span[contains(@class, \"mail-ComposeButton-Refresh \")]").click();

        closeCurrentWindow();

        $x("//a[@aria-haspopup=\"true\"]").click();
        $x("//a[@data-statlog=\"mail.login.usermenu.exit\"]").click();
    }
}
