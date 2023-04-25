package org.example.base;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class TestBase {
    EdgeDriver driver;
    @Test(dataProvider = "testData")
    public void reportPortalLoginTest(String username, String password) throws InterruptedException{
        driver.get("http://localhost:8080/ui/#login");
        driver.findElement(By.xpath("//input[@placeholder='Login']")).sendKeys(username);
        driver.findElement(By.xpath("//input[@placeholder='Password']")).sendKeys(password);
        driver.findElement(By.xpath("//button[normalize-space()='Login']")).click();
        Assert.assertTrue(driver.getTitle().matches("Welcome,\n" + "login to your account"));
        System.out.println("Signed successfully");
    }
    @AfterMethod
    void ProgramTermination(){
        driver.quit();
    }
    @DataProvider(name = "testData")
    public Object[][] TestDataFeed(){
        ReadPropertyFile config = new ReadPropertyFile("report-portal-program//testData//defaultuser.properties");
                int rows = config.getRowCount(0);
        Object[][] credentials = new Object[rows][2];
    }
}
