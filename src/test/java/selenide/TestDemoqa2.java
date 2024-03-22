package selenide;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selectors.withText;
import static com.codeborne.selenide.Selenide.*;

public class TestDemoqa2 {
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
        String dateOfBirth = "21 Mar 1990";

        open("/automation-practice-form");
        $("#firstName").setValue(firstName);
        $("#lastName").setValue(lastName);
        $("#userEmail").setValue(email);
        $(byText("Male")).click();

        $("#dateOfBirthInput").click();
        $(".react-datepicker__year-select").$(byText("1990")).click();
        $(".react-datepicker__month-select").$(byText("April")).click();
        $("div.react-datepicker__day--028").click();


        $("#subjectsInput").setValue("a");
        $(byText("Maths")).click();
        $("#subjectsInput").setValue("e");
        $(byText("English")).click();


        $(byText("Sports")).click();
        $(byText("Reading")).click();
        $(byText("Music")).click();

        $("input#uploadPicture").click();
        $("#hobbies-checkbox-3").click();




    }

}
