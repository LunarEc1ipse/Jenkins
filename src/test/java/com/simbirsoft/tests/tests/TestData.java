package com.simbirsoft.tests.tests;

import com.github.javafaker.Faker;
import com.simbirsoft.tests.config.CredentialsConfig;
import org.aeonbits.owner.ConfigFactory;

import java.io.File;
import java.time.Month;
import java.util.Random;

import static java.lang.String.format;

public class TestData {
    private static final Faker faker = new Faker();
    private static final String rawMonth = String.format(String.valueOf(Month.of(faker.number().numberBetween(1, 12))));
    public static String
            firstName = faker.name().firstName(),
            lastName = faker.name().lastName(),
            userEmail = faker.internet().emailAddress(),
            userNumber = faker.numerify("89########"),
            currentAddress = faker.address().fullAddress(),
            day = "3",
            month = rawMonth.substring(0, 1).toUpperCase() + rawMonth.substring(1).toLowerCase(),
            year = String.valueOf(faker.number().numberBetween(1930, 2000));
    public static CredentialsConfig credentials =
            ConfigFactory.create(CredentialsConfig.class);
    public static String gender = getRandomArrayValue(new String[]{"Male", "Female", "Other"});
    public static String hobbies = getRandomArrayValue(new String[]{"Sports", "Reading", "Music"});
    public static File picture = new File("src/test/resources/hello.png");
    public static String state = "NCR";
    public static String city = "Delhi";
    public static String[] subjects = new String[]{"Maths", "English"};
    static String login = credentials.login();
    static String password = credentials.password();
    public static String URL =
            format("https://%s:%s@selenoid.autotests.cloud/wd/hub/", login, password);

    private static String getRandomArrayValue(String[] array) {
        int randomValue = new Random().nextInt(array.length);
        return array[randomValue];
    }
}
