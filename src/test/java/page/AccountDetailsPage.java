package page;

import model.Account;
import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class AccountDetailsPage extends AbstractPage {
    public final static By DETAILS_TAB = By.xpath("(//*[@title='Details'])[1]/a");
    public final static String DETAIL = "//*[contains(text(),'%s')]/ancestor::div/" +
            "div[@class='slds-form-element__control']/descendant::";
    public final static String BASE_INFO = "*[@data-output-element-id='output-field']";
    public final static String ADDRESS_DETAIL = "//*[contains(text(),'%s')]/following::div/*";
    public final static String EDIT_BILLING_ADDRESS_DETAIL_BUTTON = String.format(DETAIL, "Billing") + "button";
    public final static By CANCEL_EDIT_BUTTON = By.xpath("//button[@name='CancelEdit']");

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
            new WebDriverWait(driver, WAIT_TIMEOUT_SECONDS).until(ExpectedConditions.elementToBeClickable(DETAILS_TAB));
        } catch (TimeoutException e) {
            Assert.fail("The page has not been loaded. Details not found by locator " + DETAILS_TAB);
        }
        return this;
    }

    public AccountDetailsPage openAccountDetails() {
        driver.findElement(DETAILS_TAB).click();
        new WebDriverWait(driver, WAIT_TIMEOUT_SECONDS).until(ExpectedConditions.presenceOfElementLocated(By.xpath(String.format(DETAIL + BASE_INFO, "Account Name"))));
        return this;
    }

    public String getPoleText(String poleName) {
        return driver.findElement(By.xpath(String.format(DETAIL + BASE_INFO, poleName))).getText();
    }

    private String getAddressPoleText(String poleName) {
        return driver.findElement(By.xpath(String.format(ADDRESS_DETAIL, poleName))).getAttribute("value");
    }

    public Account getAccountDetails() {
        Account account = Account.builder()
                .accountName(getPoleText("Account Name"))
                .website(getPoleText("Website"))
                .type(getPoleText("Type"))
                .phone(getPoleText("Phone"))
                .description(getPoleText("Description"))
                .industry(getPoleText("Industry"))
                .employees(getPoleText("Employees"))
                .build();

        driver.findElement(By.xpath(EDIT_BILLING_ADDRESS_DETAIL_BUTTON)).click();

        account.setBillingStreet(getAddressPoleText("Billing Street"));
        account.setBillingCity(getAddressPoleText("Billing City"));
        account.setBillingState(getAddressPoleText("Billing State"));
        account.setBillingZip(getAddressPoleText("Billing Zip"));
        account.setBillingCountry(getAddressPoleText("Billing Country"));
        account.setShippingStreet(getAddressPoleText("Shipping Street"));
        account.setShippingCity(getAddressPoleText("Shipping City"));
        account.setShippingState(getAddressPoleText("Shipping State"));
        account.setShippingZip(getAddressPoleText("Shipping Zip"));
        account.setShippingCountry(getAddressPoleText("Shipping Country"));

        driver.findElement(CANCEL_EDIT_BUTTON).click();

        return account;
    }
}
