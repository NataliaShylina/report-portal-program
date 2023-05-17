package org.example.page;

import org.example.element.LinkedText;
import org.example.utility.Waiter;
import org.openqa.selenium.By;

public class DashboardPage extends BasePage {
    private final LinkedText dashBoardLinkedText = getLinkedText(By.xpath("//a[@class='gridCell__grid-cell--3e2mS gridCell__align-left--2beIG dashboardTable__name--1sWJs'][normalize-space()='DEMO DASHBOARD']"));

    public DemoDashBoardPage chooseDemoDashBoard() {
        Waiter.waitForLoading(2);
        dashBoardLinkedText.click();

        return new DemoDashBoardPage();
    }
}
