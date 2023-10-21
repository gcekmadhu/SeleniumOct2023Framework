package com.qa.opencart.test;

import com.qa.opencart.base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class ProductInfoTest extends BaseTest {
    @BeforeClass
    public void productInfoSetup(){
        accountsPage = loginPage.doLogin("m@r.com", "Abcd1234");

    }

    @Test
    public void productInfoTest(){
        try {
            resultsPage = accountsPage.doSearch("Apple");
            prInf = resultsPage.selectProduct("Apple Cinema 30\"");
            Assert.assertTrue(prInf.getProductHeader().contains("Apple"));
            prInf.selectRadio();
            prInf.selectBothCheckbox();
            prInf.selectType();
            prInf.enterText();
            //prInf.uploadFile();
        }
        catch (Exception e){
            e.printStackTrace();
        }
    }
}
