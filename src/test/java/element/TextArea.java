package element;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class TextArea extends AbstractElement {
    public final static String textAreaLocator = "//*[contains(text(),'%s')]/parent::label/following-sibling::textarea";

    public TextArea(WebDriver driver, String label) {
        super(driver, label);
    }

    public void write(String text) {
        driver.findElement(By.xpath(String.format(textAreaLocator, label))).sendKeys(text);
    }
}
