package selenide;

import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.files.DownloadActions.click;

public class TestPageOfGithub extends BaseTest {

    @Test
    void ShouldBeTheTopExampleJUnit5() {
        // открыть страницу репозитория селенида
        System.setProperty("chromeoptions.args", "--remote-allow-origins=*");
        open("https://resources.github.com");
        $("#site-navigation-container").$("ul li.d-block")
        .click();

    sleep(3000);


    }
}