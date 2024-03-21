package selenide;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;
import static org.openqa.selenium.bidi.script.LocalValue.setValue;

public class TestDemoqa {

    @BeforeAll
     static void Beforeall() {
        Configuration.browserSize = "1100x1080";
        Configuration.baseUrl = "https://www.rzd.ru";
        Configuration.browser = "firefox";



    }
    @Test
    void AutoTest() {

        String firstName = "Pavel";
        String lastName = "Gromov";
        String email = "zxGrom@mail.com";
        String mobile = "9054443211";
        String subjects = "IT";
        String currentAddress = "Pugachev st., 24";
        String login = "asmus";
        String password = "1234qwe";


        System.setProperty("chromeoptions.args", "--remote-allow-origins=*");
        open("https://www.rzd.ru");
        $("[data-test-id=profile]").click();
        $("[data-id=reg]").click();
        $("span.tooltip-ask__icon").hover();
        sleep(2000);

        $("[data-test-id=registration-email]").setValue(email);
        $("[data-test-id=registration-login]").setValue(login);
        $("[data-test-id=registration-password]").setValue(password);
        $("[data-test-id=registration-password-confirm]").setValue(password);
        $("[data-test-id=registration-firstName]").setValue(firstName);
        $("[data-test-id=registration-lastName]").setValue(lastName);
        $("[data-test-id=registration-phone]").setValue(mobile);
        $("span.check__label").click();

        $("[data-test-id=registration-post]").click();
        $("[data-test-id=registration-register]").click();

        sleep(2000);



    }
}
