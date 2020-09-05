package com.nutraBay.qa.pages;

import java.io.IOException;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.nutraBay.qa.base.BaseTest;

public class ProfilePage extends BaseTest {

	public ProfilePage() throws IOException {
		super();
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath = "//span[contains(text(),'sathyanaik9794')]")
	WebElement accHoldername;
	
	@FindBy(xpath = "//ul[@class='dashboard-links']//a[contains(text(),'Orders')]")
	WebElement orders;
	
	@FindBy(xpath = "//a[contains(text(),'Log out')]")
	WebElement logOut;
	
	@FindBy(xpath = "//ul[@class = 'dashboard-links']//a[text() = 'Addresses']")
	WebElement addressLink;
	
	@FindBy(xpath = "//div[@class='u-column1 col-1 woocommerce-Address']//header//a[text()= 'Edit']")
	WebElement editLink;
	
	public WebElement getAccName() {
		return accHoldername;
	}
	
	public WebElement getOrders() {
		return orders;
	}
	
	public WebElement logOut() {
		return logOut;
	}
	
	public WebElement addressLink() {
		return addressLink;
	}
	
	public WebElement editLink() {
		return editLink;
	}
}
