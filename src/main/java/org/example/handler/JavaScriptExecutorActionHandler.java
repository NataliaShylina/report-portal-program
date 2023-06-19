package org.example.handler;

import com.codeborne.selenide.SelenideElement;
import com.codeborne.selenide.WebDriverRunner;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import static com.codeborne.selenide.Selenide.$;

public class JavaScriptExecutorActionHandler {
    public void scrollToElement(SelenideElement element) {
        WebDriver webDriver = WebDriverRunner.getWebDriver();
        JavascriptExecutor javascriptExecutor = (JavascriptExecutor) webDriver;
        WebElement webElement = element.toWebElement();

        javascriptExecutor.executeScript("arguments[0].scrollIntoView();", webElement);
    }

    public void click(String xpath){
        WebElement element = $(By.xpath(xpath));
        JavascriptExecutor executor = (JavascriptExecutor)WebDriverRunner.getWebDriver();
        executor.executeScript("arguments[0].click();", element);
    }
}
