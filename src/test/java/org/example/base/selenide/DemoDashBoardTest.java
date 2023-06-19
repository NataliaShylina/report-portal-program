package org.example.base.selenide;

import com.codeborne.selenide.SelenideElement;
import org.example.handler.ActionHandler;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;

class DemoDashBoardTest extends AbstractLoginTest {
    private final ActionHandler actionHandler = new ActionHandler();

    @Test
    void dragAndDropTestCasesTrendChart() {

        $(By.xpath("//a[@class='sidebarButton__nav-link--2TC0L sidebarButton__active--3dvg_']")).click();
        $(By.xpath("//a[@class='gridCell__grid-cell--3e2mS gridCell__align-left--2beIG dashboardTable__name--1sWJs'][normalize-space()='DEMO DASHBOARD']")).click();
        SelenideElement elementToMove = $(By.xpath("//*[contains(@class, 'widgetHeader__info-block--1n0yX')]//*[text() = 'TEST CASES GROWTH TREND CHART']"));

        actionHandler.dragAndDrop(elementToMove, -400, -200);
    }
}
