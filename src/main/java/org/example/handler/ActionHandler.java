package org.example.handler;

import org.openqa.selenium.WebElement;

import static com.codeborne.selenide.Selenide.actions;

public class ActionHandler {
    public void dragAndDrop(WebElement elementToMove, int xOffset, int yOffset) {
        actions().dragAndDropBy(elementToMove, xOffset, yOffset).perform();
    }

    public void method() {
//       actions().
    }
}
