package test;

import driver.DriverSingleton;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.*;
import util.TestListener;

@Listeners({TestListener.class})
public class CommonConditions {
    protected WebDriver driver;

    @BeforeClass(description = "Set up browser")
    public void setUp() {
        driver = DriverSingleton.getDriver();
    }

    @AfterClass(alwaysRun = true, description = "Close browser")
    public void stopBrowser() {
        DriverSingleton.closeDriver();
    }
}