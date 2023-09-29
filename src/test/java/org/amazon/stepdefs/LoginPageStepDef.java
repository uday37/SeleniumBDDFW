package org.amazon.stepdefs;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.amazon.pages.LoginPage;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import org.testng.Assert;

import java.time.Duration;

public class LoginPageStepDef {
    private WebDriver driver;
    private LoginPage loginPage;

    @Before
    public void setUp(){
       //String driverPath = SeleniumManager.getInstance().getDriverPath("chromedriver");
       //System.out.println("driverPath:"+driverPath);
        ChromeOptions options = new ChromeOptions();

        options.addArguments("--headless");
        driver = new ChromeDriver(options);
        loginPage = new LoginPage(driver);
    }

    @After
    public void tearDown(Scenario scenario){
        if(scenario.isFailed()) {
            TakesScreenshot ts = (TakesScreenshot) driver;
            byte[] screenshot = ts.getScreenshotAs(OutputType.BYTES);
            scenario.attach(screenshot, "image/png", "scenario failed");
        }
        if(driver!=null){
            driver.quit();
        }
    }
    @Given("open the amazon site")
    public void open_the_amazon_site() throws InterruptedException {

        driver.get("https://parabank.parasoft.com/parabank/index.htm");
        driver.manage().window().maximize();
        //Thread.sleep(20000);


    }
    @Given("I have enter valid {string} and {string}")
    public void i_have_enter_valid_and(String userName, String passWord) {

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5000));
        loginPage.enterUserName(userName);
        loginPage.enterPassword(passWord);
    }
    @When("I have click on Login button")
    public void i_have_click_on_login_button() {
        loginPage.clickLogInButton();
    }
    @Then("I should be logged into Amazon site successfully")
    public void i_should_be_logged_into_amazon_site_successfully() {
    //no code
    }

    @Given("I have enter invalid {string} and {string}")
    public void i_have_enter_invalid_and(String userName, String passWord) {
        loginPage.enterUserName(userName);
        loginPage.enterPassword(passWord);
    }

    @Then("I should see the error message indicating {string}")
    public void i_should_see_the_error_message_indicating(String errorMessage) {
        Assert.assertEquals(errorMessage, loginPage.verifyErrorMessage());
    }
}
