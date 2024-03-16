package selenide;

import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;


public class TestPageOfGithub {



        @Test
        void searchJUnit5CodeTest() {
            System.setProperty("chromeoptions.args", "--remote-allow-origins=*");
            open("https://github.com");
            $(byText("Solutions")).hover();
            $(byText("Enterprise")).click();
            $("body").shouldHave(text("Build, secure, and ship software faster"));





    }
}