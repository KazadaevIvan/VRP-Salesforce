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

    @BeforeMethod
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
                .createAccount(account)
                .clickSaveButton()
                .isPageOpened()
                .openAccountDetails()
                .getAccountDetails();

        assertEquals(actualAccount, account);
    }
}
