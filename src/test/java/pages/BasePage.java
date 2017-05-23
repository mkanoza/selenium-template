package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import element.UsefulWaits;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Created by Maksymilian on 2017-03-25.
 */
public class BasePage {

    @FindBy(css = "[class='column main'] [class='base']")
    public WebElement myDashBoard;

    WebDriver driver;
    String pageName;
    protected UsefulWaits usefulWaits;

    BasePage(String pageName){
        this.pageName = pageName;
    }

    BasePage(WebDriver driver) {
        this.usefulWaits = new UsefulWaits(driver);

    }
    public String getTitle() {
        return this.driver.getTitle();
    }

    public void assertTitle() {
        assertThat(this.getTitle()).isEqualTo(myDashBoard);
    }
}
