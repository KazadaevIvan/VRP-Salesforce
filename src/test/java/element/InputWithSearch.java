package element;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class InputWithSearch extends AbstractElement {
    public final static String INPUT_WITH_SEARCH = "//span[contains(text(),'%s')]/ancestor::div[contains(@class, 'uiInput')]//input";

    public InputWithSearch(WebDriver driver, String label) {
        super(driver, label);
    }

    public void write(String text) {
        new WebDriverWait(driver, WAIT_TIMEOUT_SECONDS).until(ExpectedConditions.presenceOfElementLocated(By.xpath(String.format(INPUT_WITH_SEARCH, label))));
        driver.findElement(By.xpath(String.format(INPUT_WITH_SEARCH, label))).sendKeys(text);
    }
}
