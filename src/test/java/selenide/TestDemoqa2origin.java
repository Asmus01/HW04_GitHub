package selenide;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.io.File;

import static com.codeborne.selenide.Condition.appear;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class TestDemoqa2origin {
    @BeforeAll
    static void Beforeall() {
        Configuration.browserSize = "1100x1080";
        Configuration.baseUrl = "https://demoqa.com";
        Configuration.browser = "firefox";

    }
    @Test
    void autoTest2() {

        String firstName = "Pavel";
        String lastName = "Gromov";
        String email = "zxGrom@mail.com";
        String mobile = "9054443211";
        String subjects = "IT";
        String currentAddress = "Ultimate st.,21";
        String login = "asmus";
        String password = "1234qwe";
        String dateOfBirth = "28 April,1990";
        String filePath = "src\\test\\data\\01.pdf";

        open("/automation-practice-form");
        $("#app").shouldHave(text("Student Registration Form"));//check page of site
        Selenide.executeJavaScript("$('#RightSide_Advertisement').remove()");//delete ads-banners
        Selenide.executeJavaScript("$('footer').remove()");//delete footer

        $("#firstName").setValue(firstName);
        $("#lastName").setValue(lastName);
        $("#userEmail").setValue(email);


        $("#genterWrapper").$(byText("Male")).click();// best

        $("#userNumber").setValue(mobile).click();
        $("#dateOfBirthInput").click();


        $(".react-datepicker__year-select").selectOption("1990");
        $(".react-datepicker__month-select").selectOption("April");

        $("div.react-datepicker__day--028").click();


        $("#subjectsInput").setValue("Maths").pressEnter();
        $("#subjectsInput").setValue("e");
        $(byText("English")).click();


        $("#hobbiesWrapper").$(byText("Sports")).click();
        $("#hobbiesWrapper").$(byText("Reading")).click();
        $("#hobbiesWrapper").$(byText("Music")).click();

        $("input#uploadPicture").uploadFile(new File(filePath));


        $("#currentAddress").setValue(currentAddress);

        $("#state").click();

        $("#react-select-3-option-2").click();

        $("#city").click();
        $(byText("Karnal")).click();
        $("#submit").click();

        $(".modal-dialog").shouldBe(appear);//check
        $(".modal-content").shouldHave(text("Thanks for submitting the form"));//check

        $("tbody").shouldHave(text(firstName), text(lastName), text(email))
        .shouldHave(text(mobile)).shouldHave(text(currentAddress)).shouldHave(text(dateOfBirth))
        .shouldHave(text("Maths, English")).shouldHave(text("Sports, Reading, Music"))
        .shouldHave(text("Male")).shouldHave(text("01.pdf")).shouldHave(text("Haryana Karnal"));


    }

}
