package element;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class TextArea extends AbstractElement {
    public final static String TEXT_AREA = "//span[contains(text(),'%s')]/following::textarea";

    public TextArea(WebDriver driver, String label) {
        super(driver, label);
    }

    public void write(String text) {
        driver.findElement(By.xpath(String.format(TEXT_AREA, label))).sendKeys(text);
    }
}
