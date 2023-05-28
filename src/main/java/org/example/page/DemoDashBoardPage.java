package org.example.page;


import dev.failsafe.internal.util.Assert;
import org.example.element.AreaText;
import org.openqa.selenium.By;

public class DemoDashBoardPage extends BasePage {
    private final AreaText launchStatisticsAreaText = getAreaText(By.xpath("//div[contains(text(),'LAUNCH STATISTICS AREA')]"));
    public DemoDashBoardPage verifyLaunchStatisticsAreaTextPresence(){
        boolean isPresent = launchStatisticsAreaText.isPresent();

        Assert.isTrue(isPresent,"Launch Statistics Area is not present");

        return this;
    }

}
