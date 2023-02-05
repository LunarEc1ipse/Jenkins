package com.simbirsoft.tests.tests;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.logevents.SelenideLogger;
import com.simbirsoft.tests.helpers.Attach;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.openqa.selenium.remote.DesiredCapabilities;

import static com.simbirsoft.tests.tests.TestData.URL;


public class TestBase {

    @BeforeAll
    static void setup() {
        String browser = System.getProperty("browser");
        String browserVersion = System.getProperty("browserVersion");
        String browserSize = System.getProperty("browserSize");
        SelenideLogger.addListener("AllureSelenide", new AllureSelenide());
        Configuration.remote = URL;

        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("enableVNC", true);
        capabilities.setCapability("enableVideo", true);
        Configuration.browser = browser;
        Configuration.browserSize = browserSize;
        Configuration.browserVersion = browserVersion;
        Configuration.browserCapabilities = capabilities;
    }

    @AfterEach
    public void tearDown() {
        Attach.screenshotAs("Last screenshot");
        Attach.pageSource();
        Attach.browserConsoleLogs();
        Attach.addVideo();
    }
}
