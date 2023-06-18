package org.example.base.selenide;

import com.codeborne.selenide.SelenideElement;
import lombok.extern.log4j.Log4j2;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import static org.junit.jupiter.api.Assertions.assertEquals;

@Log4j2
class LaunchesTest {
    private static final String BASE_PATH = "http://localhost:8080/";
    private static final String LAUNCH_SIDE_GRID_NAME_TEMPLATE = "//div[@class= 'gridRow__grid-row-wrapper--1dI9K'][@data-id='%d']";
    private static final String TOTAL_FIELD_TEMPLATE = ".//a[@statuses= \"PASSED,FAILED,SKIPPED,INTERRUPTED\"]";

    private static final String PASSED_FIELD_TEMPLATE = ".//a[@statuses= \"PASSED\"]";
    @Test
    void verifyThatLaunchesContainsExpectedData() {
        open(BASE_PATH + "ui/#login");
        $(By.xpath("//input[@placeholder='Login']")).setValue("default");
        $(By.xpath("//input[@placeholder='Password']")).setValue("1q2w3e");
        $(By.xpath("//button[normalize-space()='Login']")).click();
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
}
