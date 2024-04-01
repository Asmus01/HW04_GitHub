package pages;

import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import pages.components.CalendarComponent;
import pages.components.RegistrationResultsModal;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class RegistrationPage {

    CalendarComponent calendarComponent = new CalendarComponent();
    RegistrationResultsModal registrationResultsModal = new RegistrationResultsModal();

        private final String TITLE_TEXT = "Student Registration Form";
        private final SelenideElement
            firstNameInput = $("#firstName"),
            lastNameInput = $("#lastName");


        public RegistrationPage openPage() {

        open("/automation-practice-form");
        $("#app").shouldHave(text(TITLE_TEXT));//check page of site, constant TITLE_TEXT
        Selenide.executeJavaScript("$('#RightSide_Advertisement').remove()");//delete ads-banners
        Selenide.executeJavaScript("$('footer').remove()");
        Selenide.executeJavaScript("$('#fixedban').remove()");//delete footer
        return this;

    }
        public RegistrationPage setFirstName(String value) {

        firstNameInput.setValue(value);
        return this;

    }
        public RegistrationPage setLastName(String value) {

        lastNameInput.setValue(value);
        return this;

    }

        public RegistrationPage setEmail(String value) {

        $("#userEmail").setValue(value);
        return this;

    }
    
        public RegistrationPage setGenter(String value) {

        $("#genterWrapper").$(byText(value)).click();// best
        return this;

    }

        public RegistrationPage setMobile(String value) {

        $("#userNumber").setValue(value).click();
        return this;

    }

        public RegistrationPage setBirthDay(String day, String month, String year) {
        $("#dateOfBirthInput").click();
        calendarComponent.setDate(day, month, year);
        return this;

    }
    }



