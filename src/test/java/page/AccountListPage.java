package page;

import io.qameta.allure.Step;
import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

@Log4j2
public class AccountListPage extends AbstractPage {
    public final static String URL = "https://ateneumszkolawyzsza.lightning.force.com/lightning/o/Account/list?filterName=Recent";
    public final static By ACCOUNT_NAME_COLUMN = By.xpath("//span[@title='Account Name']");
    public final static By NEW_BUTTON = By.xpath("//div[@title='New']");
    public final static String ACCOUNT_NAME = "//*[contains(@title,'%s')]";

    public AccountListPage(WebDriver driver) {
        super(driver);
    }

    @Step("Open Accounts Page")
    @Override
    public AccountListPage openPage() {
        log.info("Open Accounts page");
        driver.get(URL);
        return this;
    }

    @Override
    public AccountListPage isPageOpened() {
        try {
            log.info("Waiting for Accounts page to be opened");
            waitElementIsVisible(ACCOUNT_NAME_COLUMN);
        } catch (TimeoutException e) {
            Assert.fail("The page has not been loaded. Account name column not found by locator " + ACCOUNT_NAME_COLUMN);
        }
        return this;
    }

    @Step("Click New button")
    public NewAccountModal clickNewButton() {
        log.info("Click New button");
        waitElementIsVisible(NEW_BUTTON).click();
        return new NewAccountModal(driver);
    }

    @Step("Open account '{name}'")
    public AccountDetailsPage openAccount(String name) {
        log.info("Open account '{}'", name);
        waitElementIsVisible(By.xpath(String.format(ACCOUNT_NAME, name))).click();
        return new AccountDetailsPage(driver);
    }
}
