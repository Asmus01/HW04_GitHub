package selenide;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.DragAndDropOptions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Selenide.*;


public class DragAndDrop2 {

    @BeforeAll
    static void beforeAll() {
        Configuration.browserSize = "1100x1080";
        Configuration.baseUrl = "https://the-internet.herokuapp.com/drag_and_drop";
    }

    @Test
    void DragAndDrop1() {
        System.setProperty("chromeoptions.args", "--remote-allow-origins=*");
        open("https://the-internet.herokuapp.com/drag_and_drop");
        $("#column-b").dragAndDrop(DragAndDropOptions.to("#column-a"));

;

    }
}