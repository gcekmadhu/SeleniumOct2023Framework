package com.qa.opencart.test;

import com.qa.opencart.base.BaseTest;
import com.qa.opencart.utils.Constants;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class AccountsPageTest extends BaseTest {


    @BeforeClass
    public void accountPageSetup(){
        accountsPage=loginPage.doLogin("m@r.com","Abcd1234");

    }

    @Test
    public void accountsTitleTest(){
        Assert.assertEquals(accountsPage.accPageTitle(), Constants.ACCOUNTS_PAGE_TITLE);

    }

    @Test
    public void accountsPageSearchTest(){
        Assert.assertTrue(accountsPage.searchLinkDisplayed());
    }

    @Test
    public void accountsPageLogoutTest(){
        Assert.assertTrue(accountsPage.logoutLinkDisplayed());
    }

    @Test
    public void accountsHeadersTest(){
        Assert.assertEquals(accountsPage.getAccountHeaders(),Constants.ACCOUNTS_HEADER_LIST);
    }

    @DataProvider
    public Object[][] getSearchProduct(){
        return new Object[][]{
                {"mac",4},
                {"apple",1}
        };
    }
    @Test(dataProvider = "getSearchProduct")
    public void doSearchTest(String product,int count){
        resultsPage=accountsPage.doSearch(product);
        Assert.assertEquals(resultsPage.searchProductListCount().size(),count);

    }
    @DataProvider
    public Object[][] selectProductData(){
        return new Object[][]{
                {"mac","MacBook Pro"},
                {"apple","Apple Cinema 30\""}
        };
    }
    @Test(dataProvider = "selectProductData")
    public void selectProductTest(String product,String productName){
        resultsPage=accountsPage.doSearch(product);
        prInf=resultsPage.selectProduct(productName);
    }




}
