package selenide;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import pages.RegistrationPage;
import pages.components.RegistrationResultsModal;
import pages.components.TestBase;

import java.io.File;

import static com.codeborne.selenide.Condition.appear;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class TestDemoqa2origin extends TestBase {

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


        registrationPage.openPage();
        registrationPage.setFirstName(firstName)
                .setLastName(lastName)
                .setEmail(email)
                .setGenter("Male")
                .setMobile(mobile)
                .setBirthDay("28","April","1990")
                .verifySubjects("Maths", "English")
                .verifyHobbies("Sports", "Reading", "Music")
                .verifyUpload(filePath)
                .verifyAddress(currentAddress)
                .verifyState("Haryana")
                .verifyCity("Karnal")
                .submit();



        registrationPage.verifyModalAppears()
                        .verifyModalResults("Student Name", firstName + " Gromov")
                        .verifyModalResults("Student Email", email)
                        .verifyModalResults("Gender", "Male")
                        .verifyModalResults("Mobile", mobile)
                        .verifyModalResults("Subjects", "Maths, English")
                        .verifyModalResults("Hobbies", "Sports")
                        .verifyModalResults("Picture", "01.pdf")
                        .verifyModalResults("Address", currentAddress)
                        .verifyModalResults("State and City", "Haryana Karnal");


    }

}
