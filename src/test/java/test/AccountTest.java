package test;

import model.Account;
import model.User;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import page.AccountListPage;
import page.LoginPage;
import service.AccountCreator;
import service.UserCreator;

import static org.testng.Assert.assertEquals;

public class AccountTest extends CommonConditions {

    @BeforeMethod(description = "Login")
    public void loginUser() {
        User user = UserCreator.withCredentialsFromProperty();

        new LoginPage(driver)
                .openPage()
                .login(user);
    }

    @Test(description = "Verify that user could create new account")
    public void newAccountShouldBeCreated() {
        Account account = AccountCreator.withParametersFromProperty();

        Account actualAccount = new AccountListPage(driver)
                .openPage()
                .isPageOpened()
                .clickNewButton()
                .isPageOpened()
                .inputAccountInfo(account)
                .clickSaveButton()
                .isPageOpened()
                .getAccountDetails();

        assertEquals(actualAccount, account);
    }

    @Test(description = "Verify that user could update created account", dependsOnMethods = {"newAccountShouldBeCreated"})
    public void newAccountShouldBeUpdated() {
        Account updatedAccount = AccountCreator.withUpdatedPhone();

        Account actualAccount = new AccountListPage(driver)
                .openPage()
                .isPageOpened()
                .openAccount(updatedAccount.getAccountName())
                .isPageOpened()
                .editDetail("Phone", updatedAccount.getPhone())
                .clickSaveEditButton()
                .getAccountDetails();

        assertEquals(actualAccount, updatedAccount);
    }
}
