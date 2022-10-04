package guru.qa.tests;

import com.codeborne.selenide.Configuration;
import com.github.javafaker.Faker;
import guru.qa.pages.PracticeFormPage;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Locale;


public class PracticeFormTestWithTestData extends TestBase {
    PracticeFormPage practiceFormPage = new PracticeFormPage();
    Faker faker = new Faker(new Locale("in-ID"));
    String firstName,
            lastName,
            userEmail,
            gender,
            phone,
            day,
            month,
            year,
            address;

    @BeforeEach
    void prepareTestData() {
        firstName = faker.name().firstName();
        lastName = faker.name().lastName();
        userEmail = faker.internet().emailAddress();
        gender = faker.demographic().sex();
        phone = faker.phoneNumber().subscriberNumber(10);
        day = faker.number().numberBetween(1, 30) + "";
        month = "June";
        year = faker.number().numberBetween(1920, 2022) + "";
        address = faker.address().fullAddress();
    }


    @Test
    void fillFormTests() {
        practiceFormPage.openPage()
                .setFirstName(firstName)
                .setLastName(lastName)
                .setUserEmail(userEmail)
                .setGender(gender)
                .setNumber(phone)
                .setBirthDate(day, month, year)
                .setSubjectsInput("Hindi")
                .setHobbies("Music")
                .uploadFile("src/test/resources/foto.jpg")
                .setAddress(address)
                .setStateAndCity("Uttar Pradesh", "Merrut")
                .clickOnSubmit();


        practiceFormPage.checkResultTableIsVisible()
                .checkResult("Student Name", firstName + " " + lastName)
                .checkResult("Date of Birth", day + " " + month + "," + year)
                .checkResult("Student Email", userEmail)
                .checkResult("Address", address);

    }
}