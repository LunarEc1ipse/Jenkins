package com.simbirsoft.tests.tests;

import com.simbirsoft.tests.pages.RegistrationPage;
import jdk.jfr.Description;
import org.junit.jupiter.api.Test;

import static com.simbirsoft.tests.tests.TestData.*;

public class AutomationPracticeFormWithPageObjectTest extends TestBase {

    RegistrationPage registrationPage = new RegistrationPage();

    @Test
    @Description("AutomationPracticeFormWithPageObjectTest")
    public void fillFromTest() {
        //Заполнение формы
        registrationPage.openPage();
        registrationPage.typeFirstName(firstName);
        registrationPage.typeLastName(lastName);
        registrationPage.typeEmail(userEmail);
        registrationPage.typeUserNumber(userNumber);
        registrationPage.selectGender(gender);
        registrationPage.typeSubject(subjects);
        registrationPage.selectHobbies(hobbies);
        registrationPage.uploadPicture(picture);
        registrationPage.typeAddress(currentAddress);
        registrationPage.stateAndCity.SelectState(state);
        registrationPage.stateAndCity.SelectCity(city);
        registrationPage.calendar.setDate(day, month, year);
        registrationPage.clickSubmit();
        //Проверка заполнения формы
        registrationPage.checkResultsUserName("Student Name", firstName + " " + lastName);
        registrationPage.checkResultsStudentEmail(userEmail);
        registrationPage.checkResultsStudentNumber(userNumber);
        registrationPage.checkResultsGender(gender);
        registrationPage.checkResultsDateOfBirth(day, month, year);
        registrationPage.checkResultsSubjects(subjects);
        registrationPage.checkResultsHobbies(hobbies);
        registrationPage.checkResultsAddress(currentAddress);
        registrationPage.checkResultsPicture(picture);
        registrationPage.checkResultsStateAndCity(state, city);
    }
}
