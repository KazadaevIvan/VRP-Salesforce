package page;

import io.qameta.allure.Step;
import lombok.extern.log4j.Log4j2;
import model.User;
import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

@Log4j2
public class LoginPage extends AbstractPage {
    public final static String URL = "https://login.salesforce.com/";
    public final static By USERNAME = By.id("username");
    public final static By PASSWORD = By.id("password");
    public final static By LOGIN_BUTTON = By.id("Login");

    public LoginPage(WebDriver driver) {
        super(driver);
    }

    @Step("Open Login page")
    public LoginPage openPage() {
        log.info("Open Login page");
        driver.get(URL);
        return this;
    }

    public LoginPage isPageOpened() {
        try {
            log.info("Waiting for Login page to be opened");
            waitElementIsVisible(LOGIN_BUTTON);
        } catch (TimeoutException e) {
            Assert.fail("The page has not been loaded. Login button not found by locator " + LOGIN_BUTTON);
        }
        return this;
    }

    @Step("Login")
    public LoginPage login(User user) {
        log.info("Login");
        driver.findElement(USERNAME).sendKeys(user.getUsername());
        driver.findElement(PASSWORD).sendKeys(user.getPassword());
        driver.findElement(LOGIN_BUTTON).click();
        return this;
    }
}
