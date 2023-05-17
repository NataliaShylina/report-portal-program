package org.example.page;

import io.github.bonigarcia.wdm.WebDriverManager;
import lombok.extern.log4j.Log4j2;
import org.example.element.AreaText;
import org.example.element.Button;
import org.example.element.InputField;
import org.example.element.LinkedText;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

@Log4j2
public abstract class BasePage {

    private static WebDriver driver;

    static {
        log.debug("=================================");
        log.debug("Driver setuping");
        log.debug("=================================");
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
    }

    static final String BASE_PATH = "http://localhost:8080/";

    public WebDriver getWebDriver() {
        return driver;
    }

    public void closeDriver() {

        driver.close();
    }

    public Button getButton(By by) {
        return new Button(getWebDriver(), by);
    }

    public InputField getInputField(By by) {
        return new InputField(getWebDriver(), by);
    }

    public LinkedText getLinkedText(By by) {
        return new LinkedText(getWebDriver(), by);
    }

    public AreaText getAreaText(By by){
        return new AreaText(getWebDriver(),by);
    }
}
