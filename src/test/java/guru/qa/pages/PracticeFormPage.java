package guru.qa.pages;

import com.codeborne.selenide.SelenideElement;
import guru.qa.pages.components.CalendarComponent;
import guru.qa.pages.components.ResultTableComponent;
import guru.qa.pages.components.StateAndCityComponent;

import java.io.File;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.Selenide.executeJavaScript;

public class PracticeFormPage {

    private CalendarComponent calendarComponent = new CalendarComponent();
    private ResultTableComponent resultTableComponent = new ResultTableComponent();
    private StateAndCityComponent stateAndCityComponent = new StateAndCityComponent();
    private SelenideElement firstNameInput = $("#firstName"),
            lastNameInput = $("#lastName"),
            emailInput = $("#userEmail"),
            genderInput = $("#genterWrapper");


    private final static String TITLE_TEXT = "Student Registration Form";



    public PracticeFormPage openPage(){
        open("/automation-practice-form");
        $(".practice-form-wrapper").shouldHave(text(TITLE_TEXT));
        executeJavaScript("$('footer').remove()");
        executeJavaScript("$('#fixedban').remove()");

        return this;
    }

    public PracticeFormPage setFirstName(String value) {
        firstNameInput.setValue(value);

        return this;
    }
    public PracticeFormPage setLastName(String value) {
        lastNameInput.setValue(value);

        return this;
    }
    public PracticeFormPage setUserEmail(String value) {
        emailInput.setValue(value);

        return this;
    }

    public PracticeFormPage setGender(String value) {
        genderInput.$(byText(value)).click();

        return this;
    }

    public PracticeFormPage setNumber(String value) {
        $("#userNumber").setValue(value);

        return this;
    }

    public PracticeFormPage setBirthDate(String day, String month, String year) {
        $("#dateOfBirthInput").click();
        calendarComponent.setDate(day, month, year);

        return this;
    }

    public PracticeFormPage setSubjectsInput(String value) {
        $("#subjectsInput").setValue(value).pressEnter();

        return this;
    }

    public PracticeFormPage setHobbies(String value) {
        $("#hobbiesWrapper").$(byText(value)).click();

        return this;
    }

    public PracticeFormPage uploadFile(String value) {
        $("#uploadPicture").uploadFile(new File(value));

        return this;
    }

    public PracticeFormPage setAddress(String value) {
        $("#currentAddress").setValue(value);

        return this;
    }

    public PracticeFormPage setStateAndCity(String state, String city) {
        stateAndCityComponent.setStateAndCity(state, city);

        return this;
    }

    public PracticeFormPage clickOnSubmit() {
        $("#submit").click();

        return this;
    }


    public PracticeFormPage checkResultTableIsVisible() {
        resultTableComponent.checkIsVisible();

        return this;
    }

    public PracticeFormPage checkResult(String key, String value) {
        resultTableComponent.checkResult(key, value);

        return this;
    }

}
