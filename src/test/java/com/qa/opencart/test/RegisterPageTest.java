package com.qa.opencart.test;

import com.qa.opencart.base.BaseTest;
import com.qa.opencart.utils.Constants;
import com.qa.opencart.utils.ExcelUtil;
import com.qa.opencart.utils.GenerateRandomNumber;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.io.IOException;
import java.util.HashMap;
import java.util.Iterator;

public class RegisterPageTest extends BaseTest {

    @BeforeClass
    public void registerSetUp(){
        registerPage=loginPage.clickRegister();
    }

    @DataProvider
    public Iterator<Object[]> getTestData(){
        try {
            return ExcelUtil.getDataFromExcel("RegisterData","register");
        } catch (IOException e) {
            e.printStackTrace();
        } catch (InvalidFormatException e) {
            e.printStackTrace();
        }
        return null;
    }
    @Test(dataProvider = "getTestData")
    public void registerPageTest(HashMap<String,String> input){
//     registerPage.enterFirstName("Madhuri");
//     registerPage.enterLastName("Kulkarni");
//     registerPage.enterEmailID("madhu"+ GenerateRandomNumber.generateRandomNum()+"@gmail.com");
//     registerPage.enterPhone("787887878");
//     registerPage.enterPassword("Abcd1234");
//     registerPage.enterConfirmPassword("Abcd1234");
//     registerPage.setSubscribe("Yes");
        registerPage.enterFirstName(input.get("firstName"));
        registerPage.enterLastName(input.get("lastName"));
        registerPage.enterEmailID(input.get("email")+ GenerateRandomNumber.generateRandomNum()+"@gmail.com");
        registerPage.enterPhone(input.get("telephone"));
        registerPage.enterPassword(input.get("password"));
        registerPage.enterConfirmPassword(input.get("password"));
        registerPage.setSubscribe(input.get("subscribe"));
        registerPage.clickPrivacy();
        accountsPage=registerPage.clickContinue();
        Assert.assertEquals(accountsPage.getSuccessMessage(), Constants.REGISTER_SUCCESS_MESSAGE);
    }

}
