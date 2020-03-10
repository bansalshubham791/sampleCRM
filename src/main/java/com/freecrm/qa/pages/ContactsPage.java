package com.freecrm.qa.pages;

import com.freecrm.qa.base.TestBase;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class ContactsPage extends TestBase {
    @FindBy(how = How.XPATH, using = "//div[contains(text(), 'Contacts')]")
    WebElement contactsLabel;
public ContactsPage(){
    PageFactory.initElements(driver, this );
}


}
