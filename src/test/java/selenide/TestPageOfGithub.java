package selenide;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;


public class TestPageOfGithub {

    @BeforeAll
    static void beforeAll() {
        Configuration.browserSize = "1100x1080";
        Configuration.baseUrl = "https://github.com";
    }

        @Test
        void searchTextLike() {
            System.setProperty("chromeoptions.args", "--remote-allow-origins=*");
            open("/selenide/selenide");
            $(byText("Solutions")).hover();
            $(byText("Enterprise")).click();
            $("body").shouldHave(text("Build, secure, and ship software faster"));





    }
}