package com.qa.opencart.utils;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class BasePage {

    private WebDriver driver;
    private WebDriverWait wait;
    public BasePage(WebDriver driver){
        this.driver=driver;
    }

    public void clickSafely(By locator){
        driver.findElement(locator).click();
    }


}
