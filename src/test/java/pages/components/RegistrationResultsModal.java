package pages.components;

import static com.codeborne.selenide.Condition.appear;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;

public class RegistrationResultsModal {

    public static void verifyModalAppears() {

        $(".modal-dialog").shouldBe(appear);//check
        $(".modal-content").shouldHave(text("Thanks for submitting the form"));//check
    }

}
