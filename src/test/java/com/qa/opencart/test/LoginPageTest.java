package com.qa.opencart.test;

import com.qa.opencart.base.BaseTest;
import com.qa.opencart.utils.Constants;
import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class LoginPageTest extends BaseTest {

    @Test
    public void loginPageTitleTest(){
        Assert.assertEquals(loginPage.getLoginPageTitle(), Constants.LOGIN_PAGE_TITLE);
    }

    @Test
    public void loginPageUrlTest(){
        Assert.assertTrue(loginPage.loginPageUrl());
    }

    @Test
    public void forgotPasswordLinkTest(){
        Assert.assertTrue(loginPage.isForgotPasswordLinkDisplayed());
    }


    @Test
    public void loginTest(){
        loginPage.doLogin("m@r.com","Abcd1234");

    }

}
