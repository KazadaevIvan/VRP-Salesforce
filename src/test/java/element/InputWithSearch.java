package element;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class InputWithSearch extends AbstractElement {
    public final static String INPUT_WITH_SEARCH = "//*[contains(text(),'%s')]/parent::label/following-sibling::div/descendant::input";
    public final static String OPTION = "//a[@role='option']/descendant::div[@title='%s']";

    public InputWithSearch(WebDriver driver, String label) {
        super(driver, label);
    }

    public void write(String text) {
        driver.findElement(By.xpath(String.format(INPUT_WITH_SEARCH, label))).sendKeys(text);
    }
}
