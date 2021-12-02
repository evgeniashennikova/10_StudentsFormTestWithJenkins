package test;

import org.junit.jupiter.api.Test;
import test.pages.ComponentCalendar;
import test.pages.ModalWindowPage;
import test.pages.RegistrationsPage;

import static io.qameta.allure.Allure.step;
import static test.TestData.*;

public class StudentsRegistrationForm extends TestBase {

    RegistrationsPage registrationsPage = new RegistrationsPage();
    ModalWindowPage modalWindowPage = new ModalWindowPage();
    ComponentCalendar componentCalendar = new ComponentCalendar();

    @Test
    void studentsForm() {

        step("Открыть форму для регистрации студента", () -> {
            registrationsPage.openPage();
        });

        step("Заполнить поля Name, Email, Mobile, выбрать Gender", () -> {
            registrationsPage.typeNameStudent()
                    .typeLastName()
                    .typeUserEmail()
                    .typeGender()
                    .typeUserNumber();
        });

        step("Выбрать в календаре дату рождения", () -> {
            componentCalendar.dateSelection();
        });

        step("Заполнить поля Subjects, Current Address, выбрать Hobbies и " +
                "State and City, вставить картинку профиля", () -> {
            registrationsPage
                    .typeSubjects()
                    .typeHobbies()
                    .typeUploadPicture()
                    .typeAddress()
                    .typeState()
                    .typeCity();
        });

        step("Отправить форму, нажав кнопку Submit", () -> {
            registrationsPage.typeSubmit();
        });

        step("Подтвердить успешную отправку формы", () -> {
            modalWindowPage.checkHeader()
                    .checkResultsValue("Student Name", nameStudent + "\t" + lastName)
                    .checkResultsValue("Student Email", userEmail)
                    .checkResultsValue("Gender", gender)
                    .checkResultsValue("Mobile", userNumber)
                    .checkResultsValue("Date of Birth", dateOfBirth)
                    .checkResultsValue("Subjects", specName)
                    .checkResultsValue("Hobbies", hobbies)
                    .checkResultsValue("Picture", imageName)
                    .checkResultsValue("Address", address)
                    .checkResultsValue("State and City", state + "\t" + city);
        });
    }
}
