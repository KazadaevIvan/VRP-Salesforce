package page;

import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class LoginPage extends AbstractPage {
    public final static String URL = "https://login.salesforce.com/";
    public final static By USERNAME = By.id("username");
    public final static By PASSWORD = By.id("password");
    public final static By LOGIN_BUTTON = By.id("Login");

    public LoginPage(WebDriver driver) {
        super(driver);
    }

    public LoginPage openPage() {
        driver.get(URL);
        return this;
    }

    public LoginPage isPageOpened() {
        try {
            new WebDriverWait(driver, WAIT_TIMEOUT_SECONDS).until(ExpectedConditions.elementToBeClickable(LOGIN_BUTTON));
        } catch (TimeoutException e) {
            Assert.fail("The page has not been loaded. Login button not found by locator " + LOGIN_BUTTON);
        }
        return this;
    }

    public LoginPage login(String userName, String password) {
        driver.findElement(USERNAME).sendKeys(userName);
        driver.findElement(PASSWORD).sendKeys(password);
        driver.findElement(LOGIN_BUTTON).click();
        return this;
    }
}
