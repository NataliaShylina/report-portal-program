package org.example.element;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LinkedText  extends BaseElement{
    public LinkedText(WebDriver webDriver, By by) {
        super(webDriver, by);
    }

    public void click(){
        webDriver.findElement(by).click();
    }
}
