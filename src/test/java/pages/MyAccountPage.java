package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import static org.assertj.core.api.Assertions.*;

public class MyAccountPage extends BasePage {


    public MyAccountPage(WebDriver driver) {
        super(driver);
        this.driver=driver;
        PageFactory.initElements(this.driver, this);
    }

    public boolean isLoggedIn() throws Exception {
        myDashBoard.isDisplayed();
        return true;
    }
}
