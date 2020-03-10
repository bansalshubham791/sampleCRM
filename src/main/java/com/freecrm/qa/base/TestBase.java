package com.freecrm.qa.base;

import com.freecrm.qa.utils.TestUtil;
import com.freecrm.qa.utils.WebEventListener;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.events.EventFiringWebDriver;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;
/*BaseTest is a base class which  deals with all the common functions used by all the pages.
This class is responsible for loading the configurations from properties files, Initializing the WebDriver, Implicit Waits,
Extent Reports and also to create the object of FileInputStream which is responsible for pointing towards the file from which the data should be read.*/

public class TestBase {
    public static Properties prop;
    public static WebDriver driver;
    public static EventFiringWebDriver e_driver;
    public static WebEventListener eventListener;

    /**
     * @return Properties
     */
    public Properties getProp() {
        return prop;
    }

    public TestBase(){
        try{
            prop = new Properties();
            FileInputStream ip = new FileInputStream("C:\\Users\\Shubham Bansal\\IdeaProjects\\comjavasampleSelenium\\src\\main\\resources\\config.properties");
            prop.load(ip);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public void initializer(){
        String browserName = prop.getProperty("browser");
        if(browserName.equals("chrome")){
            System.setProperty("webdriver.chrome.driver", prop.getProperty("driver.chrome.path"));
            driver = new ChromeDriver();
        }
        else if(browserName.equals("FF")){
            System.setProperty( "webdriver.gecko.driver", prop.getProperty("driver.firefox.path"));
            driver = new FirefoxDriver();
        }
        e_driver = new EventFiringWebDriver(driver);
        eventListener = new WebEventListener();
        e_driver.register(eventListener);
        driver = e_driver;
        driver.manage().window().maximize();
        driver.manage().deleteAllCookies();
        driver.manage().timeouts().pageLoadTimeout(TestUtil.PAGE_LOAD_TIMEOUT, TimeUnit.SECONDS);
        driver.manage().timeouts().implicitlyWait(TestUtil.IMPLICIT_WAIT, TimeUnit.SECONDS);
        driver.get(prop.getProperty("url.freecrm.landingPage"));
    }
}
