package com.freecrm.qa.pages;

import com.freecrm.qa.base.TestBase;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class LoginPage extends TestBase {

    //Page Factory - OR
    @FindBy(name = "email")
    @CacheLookup
    WebElement username;
    @FindBy(name="password")
    WebElement password;
    @FindBy(how = How.XPATH, using = "//div[@class='ui fluid large blue submit button']")
    WebElement loginBtn;

    //Initializing the page objects:
    public LoginPage(){
        PageFactory.initElements(driver, this);
    }

    //Actions:
    public String validateLoginPageTitle(){
        return driver.getTitle();
    }

    public String validateEasyLogoImage(){
        return driver.getTitle();
    }

    public HomePage login(String userName, String passWord)
    {
        username.sendKeys(userName);
        password.sendKeys(passWord);
        loginBtn.click();
        return new HomePage();
    }
}
