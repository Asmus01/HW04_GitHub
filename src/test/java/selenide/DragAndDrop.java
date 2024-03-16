package selenide;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;


public class DragAndDrop {

    @BeforeAll
    static void beforeAll() {
        Configuration.browserSize = "1100x1080";
        Configuration.baseUrl = "https://the-internet.herokuapp.com/drag_and_drop";
    }

    @Test
    void DragAndDrop1() {
        System.setProperty("chromeoptions.args", "--remote-allow-origins=*");
        open("https://the-internet.herokuapp.com/drag_and_drop");
        actions().moveToElement($("#column-b").dragAndDropTo("#column-a"));

sleep(2000);

    }
}