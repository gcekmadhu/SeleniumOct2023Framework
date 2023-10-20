package com.qa.opencart.pages;

import com.qa.opencart.utils.ElementUtil;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public class RegisterPage {
    private WebDriver driver;
    private ElementUtil ele;
    public RegisterPage(WebDriver driver){
        this.driver=driver;
        ele=new ElementUtil(driver);

    }

    private By firstName=By.id("input-firstname");
    private By lastName=By.id("input-lastname");
    private By email=By.id("input-email");
    private By telephone=By.id("input-telephone");
    private By password=By.id("input-password");
    private By confirmPassword=By.id("input-confirm");
    private By subscribe=By.cssSelector(".radio-inline");
    private By privacyPolicy=By.xpath("//input[@name='agree']");
    private By continueButton=By.cssSelector(".btn.btn-primary");

    private String fn;
    private String ln;
    private String emailId;
    private String ph;
    private String pwd;

    public String getFn() {
        return fn;
    }

    public void setFn(String fn) {
        this.fn = fn;
    }

    public String getLn() {
        return ln;
    }

    public void setLn(String ln) {
        this.ln = ln;
    }

    public String getEmailId() {
        return emailId;
    }

    public void setEmailId(String emailId) {
        this.emailId = emailId;
    }

    public String getPh() {
        return ph;
    }

    public void setPh(String ph) {
        this.ph = ph;
    }

    public String getPwd() {
        return pwd;
    }

    public void setPwd(String pwd) {
        this.pwd = pwd;
    }



    public void enterFirstName(String fn){
        setFn(fn);
        ele.doSendKeys(firstName,getFn());
    }

    public void enterLastName(String ln){
        setLn(ln);
        ele.doSendKeys(lastName,getLn());

    }

    public void enterEmailID(String emailId){
        setEmailId(emailId);
        ele.doSendKeys(email,getEmailId());
    }

    public void enterPhone(String ph){
        setPh(ph);
        ele.doSendKeys(telephone,getPh());
    }

    public void enterPassword(String pwd){
        setPwd(pwd);
        ele.doSendKeys(password,getPwd());
    }

    public void enterConfirmPassword(String pwd){
        ele.doSendKeys(confirmPassword,getPwd());;
    }

    public void setSubscribe(String value){
        List<WebElement> ls=ele.getElements(subscribe);
        for(WebElement e:ls){
            System.out.println(e.getText());
            System.out.println(e.getText().equals(value));
            if(e.getText().equals(value)){
                e.click();
                break;
            }
        }
    }

    public void clickPrivacy(){
        ele.doClick(privacyPolicy);
    }

    public AccountsPage clickContinue(){
        ele.doClick(continueButton);
        return new AccountsPage(driver);
    }



}
