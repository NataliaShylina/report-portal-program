package org.example.page;

import org.example.element.Button;
import org.example.utility.Waiter;
import org.openqa.selenium.By;

public class SideBar extends BasePage {
    private final Button dashBoardsButton = getButton(By.xpath("//a[@class='sidebarButton__nav-link--2TC0L sidebarButton__active--3dvg_']"));
    private final Button launchesButton = getButton(By.xpath("(//a[@href='#default_personal/launches'])"));

    public DashboardPage openDashBoardPage() {
        Waiter.waitForLoading(2);
        dashBoardsButton.click();
        return new DashboardPage();
    }

    public LaunchesPage openLaunchesPage() {
        Waiter.waitForLoading(2);
        launchesButton.click();
        return new LaunchesPage();
    }
}
