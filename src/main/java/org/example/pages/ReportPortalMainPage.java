package org.example.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

/**
 * Hello world!
 *
 */
public class ReportPortalMainPage {
    private WebDriver driver;
    private By searchByNameField = By.xpath("//div[@class='layout__page-container--qkF50']");
    public ReportPortalMainPage(WebDriver driver){
        this.driver = driver;
    }
    public void openDashBoards(){
        driver.get("http://localhost:8080/ui/#default_personal/dashboard");
    }
    public void searchDashBoard(String query){
        WebElement searchBoxElement = driver.findElement(searchByNameField);
        searchBoxElement.sendKeys(query);
        searchBoxElement.submit();


    }
}
