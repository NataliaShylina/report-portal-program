package org.example.base.selenide;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.WebDriverRunner;
import com.codeborne.selenide.junit5.ScreenShooterExtension;
import org.example.domain.Credentials;
import org.example.domain.UserType;
import org.example.provider.CredentialsProvider;
import org.example.utility.Waiter;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.extension.RegisterExtension;
import org.openqa.selenium.By;

import java.time.Duration;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class AbstractLoginTest {
    private static final Duration DURATION_TIMEOUT = Duration.ofSeconds(5);
    private static final String BASE_PATH = "http://localhost:8080/";

    @RegisterExtension
    static ScreenShooterExtension screenshotEmAll = new ScreenShooterExtension().to("target/screenshots");

    @BeforeEach
    void login() {
        Credentials credentials = new CredentialsProvider().provideByUserType(UserType.DEFAULT_USER);

        open(BASE_PATH + "ui/#login");
        WebDriverRunner.getWebDriver().manage().window().maximize();

        $(By.xpath("//input[@placeholder='Login']"))
                .should(Condition.visible, DURATION_TIMEOUT)
                .setValue(credentials.getLogin());
        $(By.xpath("//input[@placeholder='Password']"))
                .should(Condition.visible, DURATION_TIMEOUT)
                .setValue(credentials.getPassword());
        $(By.xpath("//button[normalize-space()='Login']")).click();

        Waiter.waitForLoading(5);
    }
}
