package com.qa.opencart.pages;

import com.qa.opencart.utils.BasePage;
import com.qa.opencart.utils.Constants;
import com.qa.opencart.utils.ElementUtil;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;

public class AccountsPage {
    private WebDriver driver;
    private ElementUtil ele;
    public AccountsPage(WebDriver driver){
        this.driver=driver;
        ele=new ElementUtil(driver);

    }

    private By search= By.cssSelector("#search input");
    private By searchIcon=By.cssSelector(".input-group-btn");
    private By accountsHeaders=By.cssSelector("#content h2");
    private By logout=By.linkText("Logout");
    private By successMessage=By.cssSelector("#content h1");

    public String accPageTitle(){
        return ele.waitForTitleToBe(Constants.DEFAULT_TIMEOUT,Constants.ACCOUNTS_PAGE_TITLE);
    }

    public List<String> getAccountHeaders(){
        List<WebElement> listEl=ele.getElements(accountsHeaders);
        List<String> ls=new ArrayList<>();
        for(WebElement el:listEl){
            ls.add(el.getText());
        }
        return ls;
    }

    public boolean logoutLinkDisplayed(){

        return ele.doIsDiplayed(logout);
    }
    public boolean searchLinkDisplayed(){
        return ele.doIsDiplayed(search);
    }

    public ResultsPage doSearch(String searchItem){
        ele.doSendKeys(search,searchItem);
        ele.doClick(searchIcon);
        return new ResultsPage(driver);
    }

    public String getSuccessMessage(){
        return ele.doGetText(successMessage);
    }

}
