package element;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class DropDown extends AbstractElement {
    public final static String SELECT = "//span[contains(text(),'%s')]/ancestor::div[contains(@class, 'uiInputSelect')]//a";
    public final static String OPTION = "//div[@class='select-options']/descendant::a[contains(text(),'%s')]";

    public DropDown(WebDriver driver, String label) {
        super(driver, label);
    }

    public void selectOption(String option) {
        driver.findElement(By.xpath(String.format(SELECT, label))).click();
        new WebDriverWait(driver, WAIT_TIMEOUT_SECONDS).until(ExpectedConditions.presenceOfElementLocated(By.xpath(String.format(OPTION, option))));
        driver.findElement(By.xpath(String.format(OPTION, option))).click();
    }
}
