package com.freecrm.qa.test;

import com.freecrm.qa.base.TestBase;
import com.freecrm.qa.pages.ContactsPage;
import com.freecrm.qa.pages.HomePage;
import com.freecrm.qa.pages.LoginPage;
import com.freecrm.qa.utils.TestUtil;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class HomePageTest extends TestBase {
    LoginPage loginPage;
    HomePage homePage;
    ContactsPage contactsPage;
    TestUtil testUtil;
    public HomePageTest(){
        super();
    }
    @BeforeMethod
    public void setUp(){
        initializer();
        loginPage = new LoginPage();
        homePage = loginPage.login(prop.getProperty("username"), prop.getProperty("password"));
    }
    //Test cases should be independent of each other.
    @Test(priority = 1)
    public void verifyHomePageTitleTest(){
        String homePageTitle = homePage.verifyHomePageTitle();
        Assert.assertEquals(homePageTitle, "Cogmento CRM", "Home page title not matched.");
    }
    @Test(enabled = false)
    public void verifyUserNameTest(){
        testUtil.switchToFrame();
       Assert.assertEquals(homePage.verifyHomePageTitle(), " ");
    }
    @Test(enabled = false)
    public void verifyContactsLinkTest(){
        testUtil.switchToFrame();
        contactsPage = homePage.clickOnContactsLink();
    }
    @AfterMethod
    public void tearDown(){
        driver.quit();
    }
}
