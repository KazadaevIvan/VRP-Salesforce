package element;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class Input extends AbstractElement {
    public final static String INPUT = "//span[contains(text(),'%s')]/ancestor::div[contains(@class, 'uiInput')]//input";

    public Input(WebDriver driver, String label) {
        super(driver, label);
    }

    public void write(String text) {
        driver.findElement(By.xpath(String.format(INPUT, label))).sendKeys(text);
    }
}
