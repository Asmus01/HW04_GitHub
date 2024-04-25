package selenide;

import com.codeborne.selenide.Selenide;
import org.junit.jupiter.api.Test;
import pages.components.TestBase;

import static com.codeborne.selenide.Condition.appear;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import static utils.RandomUtils.randomEmail;
import static utils.RandomUtils.randomString;

public class RegistrationWithRandomUtils extends TestBase {



    @Test
    void autoTest() {

        String firstName = randomString(10);
        String lastName = randomString(10);
        String email = randomEmail();
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
        Selenide.executeJavaScript("$('#fixedban').remove()");//delete ads-banner


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

        $("input#uploadPicture").uploadFromClasspath("img/02.png");//
        $("#currentAddress").setValue(currentAddress);
        $("#state").click();
        //     $(byText("Haryana")).click();//
        $("#react-select-3-option-2").click();
        $("#city").click();
        $(byText("Karnal")).click();
        $("#submit").click();
        $(".modal-dialog").shouldBe(appear);//check
        $(".modal-content").shouldHave(text("Thanks for submitting the form"));//check

        $("tbody").shouldHave(text(firstName), text(lastName), text(email))
                .shouldHave(text(mobile), text(currentAddress), text(dateOfBirth),
                        text("Maths, English"), text("Sports, Reading, Music"),
                        text("Male"), text("02.png"), text("Haryana Karnal"));


    }

}
