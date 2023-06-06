package page;

import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class NewAccountModal extends AbstractPage {

    public final static By ACCOUNT_NAME_POLE = By.xpath("//span[contains(text(),'Sort')]/following-sibling::" +
            "span[contains(text(),'Account Name')]");

    public NewAccountModal(WebDriver driver) {
        super(driver);
    }

    @Override
    public NewAccountModal openPage() {
        throw new RuntimeException("Don't do this");
    }

    @Override
    public NewAccountModal isPageOpened() {
        try {
            new WebDriverWait(driver, WAIT_TIMEOUT_SECONDS).until(ExpectedConditions.presenceOfElementLocated(ACCOUNT_NAME_POLE));
        } catch (TimeoutException e) {
            Assert.fail("The modal has not been loaded. Account name pole not found by locator " + ACCOUNT_NAME_POLE);
        }
        return this;
    }
}
