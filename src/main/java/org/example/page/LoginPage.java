package org.example.page;

import lombok.extern.log4j.Log4j2;
import org.example.domain.Credentials;
import org.example.element.Button;
import org.example.element.InputField;
import org.example.utility.Waiter;
import org.openqa.selenium.By;

@Log4j2
public class LoginPage extends BasePage {
    private static final String BASE_PATH = "http://localhost:8080/";

    private final InputField loginField = getInputField(By.xpath("//input[@placeholder='Login']"));
    private final InputField passwordField = getInputField(By.xpath("//input[@placeholder='Password']"));
    private final Button loginButton = getButton(By.xpath("//button[normalize-space()='Login']"));


    public SideBar login(Credentials credentials) {
        log.debug("login: *******");
        getWebDriver().get(BASE_PATH + "ui/#login");
        Waiter.waitForLoading(3);
        loginField.sendKey(credentials.getLogin());
        passwordField.sendKey(credentials.getPassword());
        loginButton.click();

        return new SideBar();
    }
}
