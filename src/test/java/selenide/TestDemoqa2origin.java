package selenide;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import pages.RegistrationPage;
import pages.components.RegistrationResultsModal;

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

        RegistrationPage registrationPage = new RegistrationPage();

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


        registrationPage.openPage()
                .setFirstName(firstName)
                .setLastName(lastName)
                .setEmail(email)
                .setGenter("Male")
                .setMobile(mobile)
                .setBirthDay("28","April","1990");










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



        registrationPage.verifyModalAppears()
                        .verifyModalResults("Student Name", firstName + " Gromov")
                        .verifyModalResults("Student Email", email)
                        .verifyModalResults("Gender", "Male")
                        .verifyModalResults("Mobile", mobile)
                        .verifyModalResults("Date of Birth", dateOfBirth);




        $("tbody").shouldHave(text(firstName), text(lastName), text(email),
        text(mobile),text(currentAddress), text(dateOfBirth), text("Maths, English"), text("Sports, Reading, Music")
        ,text("Male"), text("01.pdf"), text("Haryana Karnal"));


    }

}
