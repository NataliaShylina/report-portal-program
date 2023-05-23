package org.example.page;

import org.example.element.Button;
import org.example.element.LinkedText;
import org.example.utility.Waiter;
import org.openqa.selenium.By;

import java.util.ArrayList;
import java.util.Collection;

public class DashboardPage extends BasePage {
    private final LinkedText dashBoardLinkedText = getLinkedText(By.xpath("//a[@class='gridCell__grid-cell--3e2mS gridCell__align-left--2beIG dashboardTable__name--1sWJs'][normalize-space()='DEMO DASHBOARD']"));

    private final Button addNewDashBoardButton = getButton(By.xpath("//span[@class='ghostButton__text--eUa9T']"));

    public DemoDashBoardPage chooseDemoDashBoard() {
        Waiter.waitForLoading(2);
        dashBoardLinkedText.click();

        return new DemoDashBoardPage();
    }
//
//    public DemoDashBoardPage chooseAddNewDashBoard() {
////        Waiter.waitForLoading(2);
//        addNewDashBoardButton.click();
//        return new DemoDashBoardPage();
//    }
}