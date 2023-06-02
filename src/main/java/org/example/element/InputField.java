package org.example.element;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class InputField extends BaseElement {

    public InputField(WebDriver webDriver, By by) {
        super(webDriver, by);
    }

    public void sendKey(String text){

        webDriver.findElement(by).sendKeys(text);
    }
}
