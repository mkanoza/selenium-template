package tests;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.*;
import pages.HomePage;
import pages.LoginPage;
import pages.MyAccountPage;
import tools.DataProviderClass;

import static org.assertj.core.api.Assertions.assertThat;

public class LoginTest {

    WebDriver driver;

    @BeforeClass
    public void setUp() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();

    }

    @BeforeMethod
    public void prepareBrowser() {
        driver.get("http://magento2-demo.nexcess.net");
    }

    @Test(enabled = false)
    public void LoginTest(){

        driver.findElement(By.cssSelector("[class='panel header'] [class='authorization-link']")).click();
        driver.findElement(By.id("email")).sendKeys("roni_cost@example.com");
        driver.findElement(By.id("pass")).sendKeys("roni_cost3@example.com");
        driver.findElement(By.id("send2")).click();
        assertThat(driver.getTitle()).isEqualTo("My Account");
    }
    @Test(enabled = false)
    public void LoginTestFail(){

        driver.findElement(By.cssSelector("[class='panel header'] [class='authorization-link']")).click();
        driver.findElement(By.id("email")).sendKeys("roni_cost@example.com");
        driver.findElement(By.id("pass")).sendKeys("roni_cost@example.com");
        driver.findElement(By.id("send2")).click();
        assertThat(driver.getTitle()).isNotEqualTo("My Account");
    }

    @Parameters({"login", "password"})
    @Test(dataProvider = "dataProviderSignIn", dataProviderClass = DataProviderClass.class)
    public void LoginWithCorrectDataTest(String login, String password) throws Exception {
        HomePage homePage = new HomePage(driver);
        homePage.clickLoginButton();
        LoginPage loginPage = new LoginPage(driver);
        loginPage.login(login, password);
        MyAccountPage myAccountPage = new MyAccountPage(driver);
        assertThat(myAccountPage.isLoggedIn());
    }
    @Parameters({"login", "password"})
    @Test(dataProvider =  "dataProviderSignInWithInvalidUser", dataProviderClass = DataProviderClass.class)
    public void LoginWithInvalidUserTest(String login, String password) throws Exception {
        HomePage homePage = new HomePage(driver);
        homePage.clickLoginButton();
        LoginPage loginPage = new LoginPage(driver);
        loginPage.login(login, password);
        assertThat(loginPage.isAlertMessageDisplayed());
    }
    @Parameters({"login", "password"})
    @Test(dataProvider = "dataProviderSignInWithInvalidPassword", dataProviderClass = DataProviderClass.class)
    public void LoginWithInvalidPasswordTest(String login, String password) throws Exception {
        HomePage homePage = new HomePage(driver);
        homePage.clickLoginButton();
        LoginPage loginPage = new LoginPage(driver);
        loginPage.login(login, password);
        assertThat(loginPage.isAlertMessageDisplayed());
    }
    @Parameters({"login", "password"})
    @Test(dataProvider = "dataProviderSignInWithInvalidUserAndPassword", dataProviderClass = DataProviderClass.class)
    public void LoginWithInvalidUserAndPasswordTest(String login, String password) throws Exception {
        HomePage homePage = new HomePage(driver);
        homePage.clickLoginButton();
        LoginPage loginPage = new LoginPage(driver);
        loginPage.login(login, password);
        assertThat(loginPage.isAlertMessageDisplayed());
    }
    @Parameters({"login", "password"})
    @Test(dataProvider = "dataProviderSignInWithoutData", dataProviderClass = DataProviderClass.class)
    public void LoginWithoutDataTest(String login, String password) throws Exception {
        HomePage homePage = new HomePage(driver);
        homePage.clickLoginButton();
        LoginPage loginPage = new LoginPage(driver);
        loginPage.login(login, password);
        assertThat(loginPage.isValidationDisplayed());
    }

    @AfterMethod
    public void cleanUp() {
        driver.manage().deleteAllCookies();
    }

    @AfterClass
    public void driverGone() {
        driver.close();
    }
}
