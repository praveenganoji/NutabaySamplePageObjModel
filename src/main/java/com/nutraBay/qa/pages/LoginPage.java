package com.nutraBay.qa.pages;

import java.io.IOException;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.nutraBay.qa.base.BaseTest;

public class LoginPage  extends BaseTest{

	public LoginPage() throws IOException {
		super();
		//for initializing driver
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(id = "username")
	WebElement username;
	
	@FindBy(id = "password")
	WebElement password;
	
	@FindBy(xpath = "//button[contains(text(),'Log in')]")
	WebElement loginBtn;
	
	public String getPageTitle() {
		return driver.getTitle();
	}
	
	
	public ProfilePage accLogin (String un, String pwd) throws IOException {
		username.sendKeys(un);
		password.sendKeys(pwd);
		loginBtn.click();
		
		return new ProfilePage();
	}
	

}
