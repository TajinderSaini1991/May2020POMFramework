package com.qa.hubspot.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.qa.hubspot.base.BasePage;
import com.qa.hubspot.utils.Constants;
import com.qa.hubspot.utils.ElementUtil;

import io.qameta.allure.Step;

public class HomePage extends BasePage{
	
	private WebDriver driver;
	ElementUtil elementUtil;
	
	
	By header = By.xpath("//h1[text()='Sales Dashboard']");
	By accountMenu = By.cssSelector("#account-menu");
	By accountName = By.cssSelector("div.user-info-name");
	By contactsPrimaryLink = By.id("nav-primary-contacts-branch");
	By contactsSecondaryLink = By.xpath("(//a[@id='nav-secondary-contacts'])[1]");
	
	
	
	
	public HomePage(WebDriver driver){
		this.driver = driver;
		elementUtil = new ElementUtil(this.driver);
	}
	
	
	@Step("getting home page title.....")
	public String getHomePageTitle(){
	return	elementUtil.doGetPageTitleWithTitleIs(10, Constants.HOME_PAGE_TITLE);
	}
	

	@Step("getting home page header.....")
	public String getHomePageHeader(){
		if(elementUtil.doIsDisplayed(header))
			return elementUtil.doGetText(header);
	
		return null;
	}
	
	@Step("getting logged in account name.....")
	public String getLoggedInAccountName(){
		elementUtil.doClick(accountMenu);
		
		if(elementUtil.doIsDisplayed(accountName))
			return elementUtil.doGetText(accountName);
		return null;
		
		
	}
		/*if (driver.findElement(accountName).isDisplayed())
			return driver.findElement(accountName).getText();
		return null;*/
	
		@Step("going to contacts page...")
		public ContactsPage  goToContactsPage(){
			clickOnContacts();
			return new ContactsPage(driver);
		}
		
		
		
		private void clickOnContacts(){
			elementUtil.waitForElementPresent(contactsPrimaryLink, 5);
			elementUtil.doClick(contactsPrimaryLink);
			elementUtil.doClick(contactsSecondaryLink); //
			
		}
	
	
	
}

