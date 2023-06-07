package page;

import element.DropDown;
import element.Input;
import element.InputWithSearch;
import element.TextArea;
import io.qameta.allure.Step;
import lombok.extern.log4j.Log4j2;
import model.Account;
import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

@Log4j2
public class NewAccountModal extends AbstractPage {

    public final static By ACCOUNT_NAME_POLE = By.xpath("//span[contains(text(),'Account Name')]/following::input");
    public final static By SAVE_BUTTON = By.xpath("//button[@title='Save']");

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
            log.info("Waiting for New Account modal to be opened");
            waitElementIsVisible(ACCOUNT_NAME_POLE);
        } catch (TimeoutException e) {
            Assert.fail("The modal has not been loaded. Account name pole not found by locator " + ACCOUNT_NAME_POLE);
        }
        return this;
    }

    @Step("Input account info")
    public NewAccountModal inputAccountInfo(Account account) {
        log.info("Input account info: {}", account);
        new InputWithSearch(driver, "Account Name").write(account.getAccountName());
        new DropDown(driver, "Type").selectOption(account.getType());
        new Input(driver, "Website").write(account.getWebsite());
        new Input(driver, "Phone").write(account.getPhone());
        new TextArea(driver, "Description").write(account.getDescription());
        new DropDown(driver, "Industry").selectOption(account.getIndustry());
        new Input(driver, "Employees").write(account.getEmployees());
        new TextArea(driver, "Billing Street").write(account.getBillingStreet());
        new Input(driver, "Billing City").write(account.getBillingCity());
        new Input(driver, "Billing State").write(account.getBillingState());
        new Input(driver, "Billing Zip").write(account.getBillingZip());
        new Input(driver, "Billing Country").write(account.getBillingCountry());
        new TextArea(driver, "Shipping Street").write(account.getShippingStreet());
        new Input(driver, "Shipping City").write(account.getShippingCity());
        new Input(driver, "Shipping State").write(account.getShippingState());
        new Input(driver, "Shipping Zip").write(account.getShippingZip());
        new Input(driver, "Shipping Country").write(account.getShippingCountry());
        return this;
    }

    @Step("Click Save button")
    public AccountDetailsPage clickSaveButton() {
        log.info("Click Save button");
        waitElementIsVisible(SAVE_BUTTON).click();
        return new AccountDetailsPage(driver);
    }
}
