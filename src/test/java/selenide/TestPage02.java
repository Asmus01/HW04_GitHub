package selenide;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class TestPage02 {

    @BeforeAll
    static void beforeAll() {
        System.setProperty("chromeoptions.args", "--remote-allow-origins=*");
        Configuration.baseUrl = "https://github.com";
    }
    @Test
    void searchJUnit5CodeTest() {
        open("/selenide/selenide");
        $(byText("Solutions")).hover();
        $(byText("Enterprise")).click();
        $("body").shouldHave(text("Build like the best"));
    }
}