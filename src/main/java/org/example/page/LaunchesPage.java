package org.example.page;

import lombok.extern.log4j.Log4j2;
import org.example.domain.LaunchStatistics;
import org.example.utility.Converter;
import org.example.utility.Waiter;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;

import static org.junit.jupiter.api.Assertions.assertEquals;

@Log4j2
public class LaunchesPage extends BasePage {
    private static final String LAUNCH_SIDE_GRID_NAME_TEMPLATE = "//div[@class= 'gridRow__grid-row-wrapper--1dI9K'][@data-id='%d']";
    private static final String TOTAL_FIELD_TEMPLATE = ".//a[@statuses= \"PASSED,FAILED,SKIPPED,INTERRUPTED\"]";
    private static final String PASSED_FIELD_TEMPLATE = ".//a[@statuses= \"PASSED\"]";
    private static final String FAILED_FIELD_TEMPLATE = ".//a[@statuses= \"FAILED,INTERRUPTED\"] ";
    private static final String SKIPPED_FIELD_TEMPLATE = ".//a[@statuses= \"SKIPPED\"] ";


    public LaunchesPage verifyLaunchStatistics(int id, LaunchStatistics launchStatistics) {
        Waiter.waitForLoading(2);
        By blockXpath = By.xpath(String.format(LAUNCH_SIDE_GRID_NAME_TEMPLATE, id));
        WebElement blockElement = getWebDriver().findElement(blockXpath);

        String total = findElementText(TOTAL_FIELD_TEMPLATE, blockElement);
        String passed = findElementText(PASSED_FIELD_TEMPLATE, blockElement);
        String failed = findElementText(FAILED_FIELD_TEMPLATE, blockElement);
        String skipped = findElementText(SKIPPED_FIELD_TEMPLATE, blockElement);

        log.debug("==================================");
        log.debug("total: " + total);
        log.debug("passed: " + passed);
        log.debug("failed: " + failed);
        log.debug("skipped: " + skipped);

        assertEquals(total, Converter.integerToString(launchStatistics.getTotal()));
        assertEquals(passed, Converter.integerToString(launchStatistics.getPassed()));
        assertEquals(failed, Converter.integerToString(launchStatistics.getFailed()));
        assertEquals(skipped, Converter.integerToString(launchStatistics.getSkipped()));

        return this;
    }

    private static String findElementText(String xpathTemplate, WebElement parentWebElement) {
        try {
            By elementXpath = By.xpath(xpathTemplate);
            WebElement fieldElement = parentWebElement.findElement(elementXpath);
            return fieldElement.getText();
        } catch (NoSuchElementException e) {
            log.debug("Element not find: ", e);
            return null;
        }
    }
}
