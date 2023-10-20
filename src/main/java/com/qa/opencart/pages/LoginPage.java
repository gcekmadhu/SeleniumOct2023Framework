package com.qa.opencart.pages;

import com.qa.opencart.utils.Constants;
import com.qa.opencart.utils.ElementUtil;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage {

    ElementUtil ele;
    private WebDriver driver;
    private By emailId=By.id("input-email");
    private By password=By.id("input-password");
    private By loginButton=By.cssSelector("input.btn.btn-primary");
    private By forgottenPassword=By.linkText("Forgotten Password");
    private By registerLink=By.linkText("Register");

    public LoginPage(WebDriver driver){
        this.driver=driver;
        ele=new ElementUtil(driver);
    }

    public String getLoginPageTitle(){
        return ele.waitForTitleToBe(Constants.DEFAULT_TIMEOUT,Constants.LOGIN_PAGE_TITLE);
    }

    public boolean loginPageUrl(){
        return ele.waitForUrlContains(Constants.LOGIN_PAGE_URL,Constants.DEFAULT_TIMEOUT);
    }

    public boolean isForgotPasswordLinkDisplayed(){

        return ele.doIsDiplayed(forgottenPassword);
    }
    public boolean isRegisterLinkDisplayed(){
        return ele.doIsDiplayed(registerLink);
    }

    public AccountsPage doLogin(String email,String pwd){
        ele.doSendKeys(emailId,email);
        ele.doSendKeys(password,pwd);
        ele.doClick(loginButton);
        return new AccountsPage(driver);
    }

    public RegisterPage clickRegister(){
        ele.doClick(registerLink);
        return new RegisterPage(driver);
    }


}
