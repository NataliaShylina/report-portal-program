package org.example.page;

import lombok.extern.log4j.Log4j2;
import org.example.domain.Credentials;
import org.example.element.Button;
import org.example.element.InputField;
import org.openqa.selenium.By;

@Log4j2
public class LoginPage extends BasePage {

    private final InputField loginField = getInputField(By.xpath("//input[@placeholder='Login']"));
    private final InputField passwordField = getInputField(By.xpath("//input[@placeholder='Password']"));
    private final Button loginButton = getButton(By.xpath("//button[normalize-space()='Login']"));


    public SideBar login(Credentials credentials) {
        log.debug("login: *******");
        getWebDriver().get(BASE_PATH + "ui/#login");
        loginField.sendKey(credentials.getLogin());
        passwordField.sendKey(credentials.getPassword());
        loginButton.click();

        return new SideBar();
    }
}
