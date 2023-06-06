package test;

import org.testng.annotations.Test;
import page.AccountListPage;
import page.LoginPage;

public class AccountTest extends CommonConditions {

    @Test(description = "Verify that user could create new account")
    public void newAccountShouldBeCreated() {
        new LoginPage(driver)
                .openPage()
                .login("", "");

        new AccountListPage(driver)
                .openPage()
                .isPageOpened();
    }
}
