package page;

import model.Account;
import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class AccountDetailsPage extends AbstractPage {
    public final static By DETAILS_TAB = By.xpath("//li[@title='Details']/a");
    public final static String DETAIL = "//span[text()='%s']/parent::div/following::*[@data-output-element-id='output-field']";
    public final static String EDIT_DETAIL_BUTTON = "/following::button[contains(@title,'Edit')]";
    public final static String EDIT_DETAIL_INPUT = "//label[contains(text(),'%s')]/following::*[self::input or self::textarea]";
    public final static By CANCEL_EDIT_BUTTON = By.xpath("//button[@name='CancelEdit']");
    public final static By SAVE_EDIT_BUTTON = By.xpath("//button[@name='SaveEdit']");

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
            waitElementIsVisible(DETAILS_TAB);
        } catch (TimeoutException e) {
            Assert.fail("The page has not been loaded. Details tab not found by locator " + DETAILS_TAB);
        }
        return this;
    }

    public AccountDetailsPage openAccountDetails() {
        driver.findElement(DETAILS_TAB).click();
        waitElementIsVisible(By.xpath(String.format(DETAIL, "Account Name")));
        return this;
    }

    private String getPoleText(String poleName) {
        return waitElementIsVisible(By.xpath(String.format(DETAIL, poleName)))
                .getText();
    }

    private String getAddressPoleText(String poleName) {
        return waitElementIsVisible(By.xpath(String.format(EDIT_DETAIL_INPUT, poleName)))
                .getAttribute("value");
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

        driver.findElement(By.xpath(String.format(DETAIL, "Billing Address") + EDIT_DETAIL_BUTTON)).click();

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

    public AccountDetailsPage editDetail(String detail, String newValue) {
        waitElementIsVisible(By.xpath(String.format(DETAIL, detail) + EDIT_DETAIL_BUTTON))
                .click();
        driver.findElement(By.xpath(String.format(EDIT_DETAIL_INPUT, detail))).clear();
        driver.findElement(By.xpath(String.format(EDIT_DETAIL_INPUT, detail))).sendKeys(newValue);
        driver.findElement(SAVE_EDIT_BUTTON).click();
        return this;
    }
}
