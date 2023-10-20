package com.qa.opencart.factory;

import com.qa.opencart.utils.ApplicationException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

/**
 * @author Madhuri Kulkarni
 */
public class DriverFactory {
    public WebDriver driver;
    public Properties prop;

    /**
     * Takes browser name and return driver related to browser passed as argument
     * @param prop
     * @return WebDriver of browser passed
     */
    public WebDriver initDriver(Properties prop){
        String browser=prop.getProperty("browser");
        System.out.println("Browser is : "+browser);
        switch (browser.toLowerCase().trim()){
            case "chrome":
                driver=new ChromeDriver();
                break;
            case "firefox":
                driver=new FirefoxDriver();
                break;
            case "edge":
                driver=new EdgeDriver();
                break;
            default:
                System.out.println("Please pass right browser");
                throw new ApplicationException("INVALID BROWSER");
        }
        driver.manage().window().maximize();
        driver.manage().deleteAllCookies();
        driver.get(prop.getProperty("url"));
        return driver;
    }

    /**
     * This method will return prop and initialize property based on property file
     * @return will return prop
     */
    public Properties initProp(){
        prop =new Properties();
        try {
            FileInputStream fis=new FileInputStream("./src/test/resources/config/config.properties");
            prop.load(fis);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return prop;
    }
}
