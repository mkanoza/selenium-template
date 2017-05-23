package element;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class UsefulWaits {

    private static final int DEFAULT_TIMEOUT = 15;

    private WebDriverWait wait;
    private WebDriver driver;

    public UsefulWaits(WebDriver webDriver) {
        this.driver = webDriver;
        this.wait = new WebDriverWait(webDriver, DEFAULT_TIMEOUT);
    }

    public void waitForVisible(WebElement element, int seconds){
        new WebDriverWait(driver, seconds).until(ExpectedConditions.visibilityOf(element));
    }

}
