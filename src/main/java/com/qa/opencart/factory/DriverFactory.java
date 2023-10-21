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
    public OptionsManager optionsManager;

    /**
     * Takes browser name and return driver related to browser passed as argument
     * @param prop
     * @return WebDriver of browser passed
     */
    public WebDriver initDriver(Properties prop){
        optionsManager=new OptionsManager(prop);
        String browser=prop.getProperty("browser");
        System.out.println("Browser is : "+browser);
        switch (browser.toLowerCase().trim()){
            case "chrome":
                driver=new ChromeDriver(optionsManager.getChromeOptions());
                break;
            case "firefox":
                driver=new FirefoxDriver(optionsManager.getFirefoxOptions());
                break;
            case "edge":
                driver=new EdgeDriver(optionsManager.getEdgeOptions());
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
        FileInputStream fis = null;
        String env=System.getProperty("env");
        if(env==null) {
            try {
                fis = new FileInputStream("./src/test/resources/config/config.properties");
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }
        }
        else{
            System.out.println("Running on env : "+env);
            try {
                switch (env.toLowerCase().trim()) {
                    case "qa":
                        fis = new FileInputStream("./src/test/resources/config/qa.config.properties");
                        break;
                    case "stage":
                        fis = new FileInputStream("./src/test/resources/config/stage.config.properties");
                        break;
                    default:
                        System.out.println("Please pass right env name");
                        throw new ApplicationException("INVALID ENV");
                        

                }
            }
            catch (FileNotFoundException e) {
                e.printStackTrace();
            }


        }
        try {
            prop.load(fis);
        }
        catch (IOException e){
            e.printStackTrace();
        }
        return prop;
    }
}
