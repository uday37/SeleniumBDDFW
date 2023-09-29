package org.amazon.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {

    private WebDriver driver;
   public LoginPage(WebDriver driver){
        this.driver = driver;
       PageFactory.initElements(driver, this);
    }

    @FindBy(xpath="//input[@name='username']")
    private WebElement userNameInput;

    @FindBy(xpath="//input[@name='password']")
    private WebElement passwordInput;


    @FindBy(xpath="//input[@value='Log In']")
    private WebElement loginBtn;

    @FindBy(xpath="//a[normalize-space()='Forgot login info?']")
    private WebElement forGotLoginInfoLink;

    @FindBy(xpath="//p[@class='error']")
    private WebElement errorMessage;

    public void clickLogInButton() {
        loginBtn.click();
    }

    public void enterUserName(String userName) {
        //userNameInput.clear();
        userNameInput.sendKeys(userName);
    }

    public void enterPassword(String password) {
       // passwordInput.clear();
        passwordInput.sendKeys(password);
    }

    public void clickForgotLoginInfoLink() {
        forGotLoginInfoLink.click();
    }


    public void login(String userName, String passWord){
        enterUserName(userName);
        enterPassword(passWord);
        clickLogInButton();
    }

    public String verifyErrorMessage(){
        return errorMessage.getText();
    }
}
