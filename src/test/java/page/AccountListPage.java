package page;

import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class AccountListPage extends AbstractPage {
    public final static String URL = "https://ateneumszkolawyzsza.lightning.force.com/lightning/o/Account/list?filterName=Recent";
    public final static By ACCOUNT_NAME_COLUMN = By.xpath("//span[@title='Account Name']");
    public final static By NEW_BUTTON = By.xpath("//div[@title='New']");
    public final static String ACCOUNT_NAME = "//*[contains(@title,'%s')]";

    public AccountListPage(WebDriver driver) {
        super(driver);
    }

    @Override
    public AccountListPage openPage() {
        driver.get(URL);
        return this;
    }

    @Override
    public AccountListPage isPageOpened() {
        try {
            waitElementIsVisible(ACCOUNT_NAME_COLUMN);
        } catch (TimeoutException e) {
            Assert.fail("The page has not been loaded. Account name column column not found by locator " + ACCOUNT_NAME_COLUMN);
        }
        return this;
    }

    public NewAccountModal clickNewButton() {
        waitElementIsVisible(NEW_BUTTON).click();
        return new NewAccountModal(driver);
    }

    public AccountDetailsPage openAccount(String name) {
        waitElementIsVisible(By.xpath(String.format(ACCOUNT_NAME, name))).click();
        return new AccountDetailsPage(driver);
    }
}
