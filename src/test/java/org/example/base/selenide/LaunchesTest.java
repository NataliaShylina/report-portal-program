package org.example.base.selenide;

import com.codeborne.selenide.SelenideElement;
import lombok.extern.log4j.Log4j2;
import org.example.handler.JavaScriptExecutorActionHandler;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;
import static org.junit.jupiter.api.Assertions.assertEquals;

@Log4j2
class LaunchesTest extends AbstractLoginTest {
    private static final String LAUNCH_SIDE_GRID_NAME_TEMPLATE = "//div[@class= 'gridRow__grid-row-wrapper--1dI9K'][@data-id='%d']";
    private static final String TOTAL_FIELD_TEMPLATE = ".//a[@statuses= \"PASSED,FAILED,SKIPPED,INTERRUPTED\"]";

    private static final String PASSED_FIELD_TEMPLATE = ".//a[@statuses= \"PASSED\"]";

    private final JavaScriptExecutorActionHandler javaScriptExecutorActionHandler = new JavaScriptExecutorActionHandler();

    @Test
    void verifyThatLaunchesContainsExpectedData() {

        $(By.xpath("(//a[@href='#default_personal/launches'])")).click();
        SelenideElement blockElement = $(By.xpath(String.format(LAUNCH_SIDE_GRID_NAME_TEMPLATE, 10)));

        String total = blockElement.$(By.xpath(TOTAL_FIELD_TEMPLATE)).getText();
        String passed = blockElement.$(By.xpath(PASSED_FIELD_TEMPLATE)).getText();

        log.debug("==================================");
        log.debug("total: " + total);
        log.debug("passed: " + passed);

        assertEquals(total, "30");
        assertEquals(passed, "30");
    }

    @Test
    void scrollToElement() {
        $(By.xpath("//a[@class='sidebarButton__nav-link--2TC0L sidebarButton__active--3dvg_']")).click();
        $(By.xpath("(//a[@href='#default_personal/launches'])")).click();

        By blockXpath = By.xpath(String.format(LAUNCH_SIDE_GRID_NAME_TEMPLATE, 4));
        $(blockXpath).scrollIntoView(false);


        try {
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

    }
}
