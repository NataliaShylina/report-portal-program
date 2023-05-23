package org.example.page;

import dev.failsafe.internal.util.Assert;
import org.example.element.AreaText;
import org.openqa.selenium.By;

public class LaunchesPage extends BasePage {
    private final AreaText demoAPITestsField = getAreaText(By.xpath("//td[@class='launchSuiteGrid__name-col--_sfp1 gridCell__grid-cell--3e2mS gridCell__align-left--2beIG']//span[@class='itemInfo__number--1ufC2'][normalize-space()='#10']"));
    private final AreaText demoAPITextBlock = getAreaText(By.xpath("//div[@class= 'gridRow__grid-row-wrapper--1dI9K'][@data-id='10']"));

    public LaunchesPage verifyThatDemoAPITests10IsPresent() {
        boolean isPresent = demoAPITestsField.isPresent();
        Assert.isTrue(isPresent, "Demo API Tests isn't present");
        return this;
    }

    public LaunchesPage verifyThatDemoAPITests10ContainsDemoData() {
//TODO
        return this;
    }
}
