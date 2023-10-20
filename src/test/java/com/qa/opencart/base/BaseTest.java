package com.qa.opencart.base;

import com.qa.opencart.factory.DriverFactory;
import com.qa.opencart.pages.*;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

import java.util.Properties;

public class BaseTest {
    public WebDriver driver;
    public Properties prop;
    public  DriverFactory dr;
    public LoginPage loginPage;
    public AccountsPage accountsPage;
    public RegisterPage registerPage;
    public ResultsPage resultsPage;
    public ProductsInfoPage prInf;

    @BeforeTest
    public void setup(){
        dr=new DriverFactory();
        prop =dr.initProp();
        driver=dr.initDriver(prop);
        loginPage=new LoginPage(driver);
    }

    @AfterTest
    public void tearDown(){

        driver.quit();

    }

}
