package page;

import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.util.List;

public class AccountDetailsPage extends AbstractPage {
    public final static By DETAILS_TAB = By.xpath("(//*[@title='Details'])[1]/a");
    public final static String DETAIL = "//*[contains(text(),'%s')]/ancestor::div/" +
            "div[@class='slds-form-element__control']/descendant::*";
    public final static String BASE_INFO = "[@data-output-element-id='output-field']";
    public final static String ADDRESS_INFO = "[@class='slds-truncate']";

    public AccountDetailsPage(WebDriver driver) {
        super(driver);
    }

    @Override
    public NewAccountModal openPage() {
        throw new RuntimeException("Don't do this");
    }

    @Override
    public AccountDetailsPage isPageOpened() {
        try {
            new WebDriverWait(driver, WAIT_TIMEOUT_SECONDS).until(ExpectedConditions.presenceOfElementLocated(DETAILS_TAB));
        } catch (TimeoutException e) {
            Assert.fail("The page has not been loaded. Details not found by locator " + DETAILS_TAB);
        }
        return this;
    }

    public AccountDetailsPage openAccountDetails() {
        new WebDriverWait(driver, WAIT_TIMEOUT_SECONDS).until(ExpectedConditions.elementToBeClickable(DETAILS_TAB));
        driver.findElement(DETAILS_TAB).click();
        return this;
    }

    public String getPoleText(String poleName) {
        return driver.findElement(By.xpath(String.format(DETAIL + BASE_INFO, poleName))).getText();
    }

    public String getAddressPoleText(String addressType) {
        StringBuilder address = new StringBuilder();
        List<WebElement> list = driver.findElements(By.xpath(String.format(DETAIL + ADDRESS_INFO, addressType)));
        for (WebElement line : list) {
            address.append(line.getText()).append("\n");
        }
        return String.valueOf(address);
    }
}
