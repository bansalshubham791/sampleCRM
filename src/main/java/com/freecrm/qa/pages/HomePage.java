package com.freecrm.qa.pages;

import com.freecrm.qa.base.TestBase;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage extends TestBase {
    @FindBy(xpath="//td[contains(text(),'Shubham Bansal')]")
    WebElement userNameLabel;
    @FindBy(xpath="//a[contains(text(),'Contacts')]")
    WebElement contactLink;
    @FindBy(xpath="//a[contains(text(),'Contacts')]")
    WebElement dealsLink;
    @FindBy(xpath="//a[contains(text(),'Contacts')]")
    WebElement taskLink;
        //initializing the Page Objects:
    public HomePage(){
        PageFactory.initElements(driver,this);
    }
public String verifyHomePageTitle(){
        return driver.getTitle();
}
public ContactsPage clickOnContactsLink(){
         contactLink.click();
         return new ContactsPage();
}
public DealsPage clickOnDealsLink(){
        dealsLink.click();
        return new DealsPage();
}
public TasksPage clickOnTasksLink(){
    taskLink.click();
    return new TasksPage();
}
}
