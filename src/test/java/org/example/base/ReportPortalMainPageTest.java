package org.example.base;

import org.example.pages.ReportPortalMainPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.Test;

/**
 * Unit test for simple App.
 */
public class ReportPortalMainPageTest {
    @Test
    public void searchDemoDashBoard() {
        WebDriver driver = new EdgeDriver();
        ReportPortalMainPage page = new ReportPortalMainPage(driver);
        page.openDashBoards();
        page.searchDashBoard("DEMO DASHBOARD");
        System.out.println(driver.getTitle());
        driver.quit();
    }
}
