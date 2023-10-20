package com.qa.opencart.pages;

import com.qa.opencart.utils.ElementUtil;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.awt.*;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.util.List;

public class ProductsInfoPage {
    private WebDriver driver;
    private ElementUtil ele;
    public ProductsInfoPage(WebDriver driver) {
        this.driver=driver;
        ele=new ElementUtil(driver);
    }

    private By productHeader= By.cssSelector("#content h1");
    private By radioArea=By.cssSelector(".radio input");
    private By checkBoxArea=By.cssSelector(".checkbox input");
    private By selectArea=By.cssSelector("#input-option217");
    private By textArea=By.xpath("//textarea[contains(@id,'input-option')]");
    private By fileUpload=By.id("button-upload222");


    public String getProductHeader(){
        return ele.doGetText(productHeader);
    }

    public void selectRadio(){
        ele.doClick(radioArea);
    }
    public void selectBothCheckbox(){
        List<WebElement> ls=ele.getElements(checkBoxArea);
        for(WebElement e:ls){
            e.click();
        }
    }
    public void selectType(){
        ele.doSelectByIndex(selectArea,1);
    }

    public void enterText(){
        ele.doSendKeys(textArea,"This is mac product");
    }

    public void uploadFile(){
        ele.getElement(fileUpload).click();


        Robot rb = null;
        try {
            rb = new Robot();
            // copying File path to Clipboard
            StringSelection str = new StringSelection("E:\\Framework\\2023\\Selenium2023Framework\\src\\test\\resources\\testdata\\test.txt");
            Toolkit.getDefaultToolkit().getSystemClipboard().setContents(str, null);

            // press Contol+V for pasting
            rb.keyPress(KeyEvent.VK_CONTROL);
            rb.keyPress(KeyEvent.VK_V);

            // release Contol+V for pasting
            rb.keyRelease(KeyEvent.VK_CONTROL);
            rb.keyRelease(KeyEvent.VK_V);

            // for pressing and releasing Enter
            rb.keyPress(KeyEvent.VK_ENTER);
            rb.keyRelease(KeyEvent.VK_ENTER);
        } catch (AWTException e) {
            e.printStackTrace();
        }
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }




    }

}
