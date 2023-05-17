package org.example.element;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class AreaText extends BaseElement{
    public AreaText(WebDriver webDriver, By by) {
        super(webDriver, by);
    }
    public boolean isPresent(){
        return webDriver.findElement(by).isDisplayed();
    }
}
