package com.freecrm.qa.test;

import com.freecrm.qa.base.TestBase;
import com.freecrm.qa.pages.HomePage;
import com.freecrm.qa.pages.LoginPage;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class LoginPageTest extends TestBase {
    LoginPage loginPage;
    HomePage homePage;
public LoginPageTest(){
    super();
}
@BeforeMethod
    public void setUp(){
    initializer();
    loginPage = new LoginPage();
}
@Test(priority = 1, groups = "Test")
public void loginPageTitleTest(){
    String title = loginPage.validateLoginPageTitle();
    Assert.assertEquals(title, "Cogmento CRM", "Incorrect title is present.");
}
@Test(priority = 2, groups = "Test")
public void loginTest(){
    homePage = loginPage.login( prop.getProperty("username"), prop.getProperty("password"));
}
@AfterMethod
    public void tearDown(){
    driver.quit();
}
}
