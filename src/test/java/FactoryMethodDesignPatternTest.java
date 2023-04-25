import org.example.designpatterns.DriverFactory;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class FactoryMethodDesignPatternTest {
    @DataProvider
    public static Object[][] getData() {
        return new String[][]{
                {"edge"}
        };
    }

    @Test(dataProvider = "getData")
    public void factoryMethodTest(String browser) {
        WebDriver driver = DriverFactory.getDriver(browser);
        driver.get("http://localhost:8080/ui/#login");
        driver.close();
    }
}