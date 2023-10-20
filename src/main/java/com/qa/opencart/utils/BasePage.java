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

    public String getTitleSafely(int timeout,String value){
        wait=new WebDriverWait(driver, Duration.ofSeconds(timeout));

        if(wait.until(ExpectedConditions.titleIs(value))){
            return driver.getTitle();
        }
        return null;

    }


    public WebElement getElementSafely(By locator){
        return driver.findElement(locator);
    }

    public boolean isDisplayedSafely(By locator){
        return getElementSafely(locator).isDisplayed();
    }

    public List<WebElement> getElementsSafely(By locator){
        return driver.findElements(locator);
    }
}
