package org.example.element;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class BaseElement {

    protected final WebDriver webDriver;
    protected final By by;

    public BaseElement(WebDriver webDriver, By by) {
        this.webDriver = webDriver;
        this.by = by;
    }
}
