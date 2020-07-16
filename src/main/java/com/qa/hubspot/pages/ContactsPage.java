package com.qa.hubspot.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.qa.hubspot.base.BasePage;
import com.qa.hubspot.utils.Constants;
import com.qa.hubspot.utils.ElementUtil;

import io.qameta.allure.Step;

public class ContactsPage extends BasePage {
	private WebDriver driver;
	ElementUtil elementUtil;
	
	By header = By.xpath("(//*[text()='Contacts'])[2]");
	By createContactPrimary = By.xpath("//span[text()='Create contact']");
	By email = By.cssSelector("input[data-field='email']");
	By firstName = By.cssSelector("input[data-field='firstname']");
	By lastName = By.xpath("//input[@data-field='lastname']");
	By jobTitle = By.xpath("//input[@data-field='jobtitle']");
	By createContactSecondary = By.xpath("(//span[text()='Create contact'])[position()=2]");
	By newContactName = By.xpath("//span[@data-selenium-test='highlightTitle']");
	By contactsBackLink = By.xpath("(//*[text()='Contacts'])[1]");
	
	
	
	By totalContactsText  = By.xpath("//i18n-string[text()='4 contacts']");
	By selectAllContacts = By.xpath("(//span[@class='private-checkbox__inner'])[1]");
	By delete = By.xpath("//button[@data-selenium-test='bulk-action-delete']//span[text()='Delete']");
	By popUpBox = By.xpath("//textarea");
	By deleteDialogConfirmButton = By.xpath("//button[@data-selenium-test='delete-dialog-confirm-button']");
	By zeroContactText = By.xpath("//i18n-string[text()='0 contacts']");
	
	public ContactsPage(WebDriver driver){
		this.driver = driver;
		elementUtil =  new ElementUtil(this.driver);
	}
	
	
	@Step("getting contacts page title......")
	public String getContactsPageTitle(){
		return elementUtil.doGetPageTitleWithContains(10, Constants.CONTACTS_PAGE_TITLE);
	}
	
	@Step("getting contacts page header......")
	public String getContactsPageHeader(){
		elementUtil.waitForElementPresent(header, 10);
		return elementUtil.doGetText(header);
	}
	
	
@Step("creating new contacts ......")
	public String createContact(String emailID,String firstName,String lastName,String jobTitle){
		elementUtil.clickwhenReady(createContactPrimary, 10); 
		elementUtil.doSendKeys(email, emailID);
		elementUtil.doSendKeys(this.firstName, firstName);
		elementUtil.doSendKeys(this.lastName, lastName);
		elementUtil.waitForElementToBeVisible(this.jobTitle, 10);
		elementUtil.doActionsClick(this.jobTitle);
		elementUtil.doClick(createContactSecondary);
		String contactName =  elementUtil.waitForElementPresent(newContactName, 5).getText();
		elementUtil.clickwhenReady(contactsBackLink, 10);
		return contactName;
	}
	
@Step("deleting the contacts....")
	public String selectAndDeleteAllContacts(){
		
		elementUtil.clickwhenReady(selectAllContacts, 10); // selects all contacts to be deleted
		elementUtil.clickwhenReady(delete, 5); // clicks the delete button 
		elementUtil.waitForElementPresent(popUpBox, 10); // wait for pop up to be present on screen
		elementUtil.doClick(popUpBox); // clicks in the box inside the pop up
		elementUtil.doSendKeys(popUpBox,Constants.TOTAL_NO_OF_CONTACTS); // typing the no. of contacts to be
																		//deleted
		elementUtil.clickwhenReady(deleteDialogConfirmButton, 5); // clicking the delete button on pop up
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {            // waiting for 3 seconds
			
		}
		elementUtil.dorefresh();					// refresing the page so that "0 contact" text appears
		
		elementUtil.waitForElementPresent(zeroContactText,15); // waiting for "0 contact" text 
		return elementUtil.doGetText(zeroContactText); // getting the text for assertion
		
	}
}
