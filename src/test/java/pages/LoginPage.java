package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import static org.assertj.core.api.AssertionsForInterfaceTypes.assertThat;


/**
 * Created by Maksymilian on 2017-03-25.
 */
public class LoginPage extends BasePage{

    @FindBy(id = "email")
    WebElement inputLogin;
    @FindBy(id = "pass")
    WebElement inputPassword;
    @FindBy(id = "send2")
    WebElement buttonLogin;
    @FindBy(css = "[class='page messages'] >div>div>div>div")
    WebElement alertMessage;
    @FindBy(css = "[class='block-content'] [class='control'] [class='mage-error']")
    WebElement frontendValidation;


    public LoginPage(WebDriver driver) {
        super(driver);
        this.driver = driver;
        PageFactory.initElements(this.driver, this);
    }

    public void login(String login, String password) throws InterruptedException {
        inputLogin.clear();
        inputLogin.sendKeys(login);
        inputPassword.clear();
        inputPassword.sendKeys(password);
        buttonLogin.click();
    }

    public boolean isAlertMessageDisplayed() throws Exception {
        usefulWaits.waitForVisible(alertMessage, 10);
        assertThat(alertMessage.getText().contains("Invalid login or password."));
        return true;
    }

    public boolean isValidationDisplayed() throws Exception {
        usefulWaits.waitForVisible(frontendValidation, 10);
        assertThat(frontendValidation.getText().contains("This is a required field."));
        return true;
    }



}
