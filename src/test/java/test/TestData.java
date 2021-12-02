package test;

import com.github.javafaker.Faker;

import java.util.Locale;

public class TestData {

    public static Faker faker = new Faker(new Locale("en"));

    public static String nameStudent = faker.name().firstName(),
            lastName = faker.name().lastName(),
            userEmail = faker.internet().emailAddress(),
            gender = "Male",
            userNumber = faker.phoneNumber().subscriberNumber(10),
            dateOfBirth = "05 October,2000",
            day = "05",
            month = "October",
            year = "2000",
            imageName = "photo.png",
            specName = "Hindi",
            shortSpecName = specName.substring(0, specName.length() - 1),
            subjectsContainerXpath = "//div[@id='subjectsContainer']",
            specNameXpath = String.format("//div[text()='%s']", specName),
            specialization = subjectsContainerXpath + specNameXpath,
            hobbies = "Sports",
            image = "photo.png",
            address = faker.address().streetAddress(),
            state = "NCR",
            city = "Noida";
}
