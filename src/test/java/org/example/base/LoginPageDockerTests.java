package org.example.base;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.Test;

public class LoginPageDockerTests {
    @Test
    public void dockerTest() {
        WebDriverManager.edgedriver().setup();
        WebDriver driver = new EdgeDriver();
//        driver.manage().window().maximize();
        driver.get("http://localhost:8080/ui/#login");
        driver.findElement(By.xpath("//input[@placeholder='Login']")).sendKeys("default");//String query
        driver.findElement(By.xpath("//input[@placeholder='Password']")).sendKeys("1q2w3e");
        driver.findElement(By.xpath("//button[normalize-space()='Login']")).click();
    }
}
