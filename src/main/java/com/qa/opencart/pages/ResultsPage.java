package com.qa.opencart.pages;

import com.qa.opencart.utils.Constants;
import com.qa.opencart.utils.ElementUtil;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class ResultsPage {
    private WebDriver driver;
    private ElementUtil ele;
    public ResultsPage(WebDriver driver) {
        this.driver=driver;
        ele=new ElementUtil(driver);
    }

    private By header= By.cssSelector("#content h1");
    private By productResults=By.cssSelector("div.caption a");

    public String getSearchHeaderName(){
        return ele.doGetText(header);
    }

    public List<WebElement> searchProductListCount(){
         return ele.waitForElementsVisible(productResults, Constants.DEFAULT_TIMEOUT);
    }

    public ProductsInfoPage selectProduct(String productName){
        List<WebElement> ls=searchProductListCount();
        for(WebElement e:ls){
            if(e.getText().equals(productName)){
                e.click();
                break;
            }
        }
      return new ProductsInfoPage(driver);
    }

}
