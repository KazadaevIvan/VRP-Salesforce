package element;

import org.openqa.selenium.WebDriver;

public class AbstractElement {

    protected WebDriver driver;
    protected String label;
    protected final int WAIT_TIMEOUT_SECONDS = 10;

    public AbstractElement(WebDriver driver, String label) {
        this.driver = driver;
        this.label = label;
    }
}
