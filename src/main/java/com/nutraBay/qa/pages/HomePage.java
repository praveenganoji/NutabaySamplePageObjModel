package com.nutraBay.qa.pages;

import java.io.IOException;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.nutraBay.qa.base.BaseTest;

public class HomePage extends BaseTest {

	public HomePage() throws IOException {
		super();
		// to initialise page factory..
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//span[contains(text(),'Login')]")
	WebElement loginLink;

	@FindBy(xpath = "//img[contains(@class,'header-logo-dark')]")
	WebElement logo;

	@FindBy(xpath = "//input[contains(@type, 'search')]")
	WebElement searchbar;

	@FindBy(xpath = "//i[contains(@class, 'icon-search')]")
	WebElement searchbtn;

	@FindBy(xpath = "//a[contains(text(),'Crazy Deals')]")
	WebElement crazyLink;

	@FindBy(xpath = "//a[contains(text(),'Top 10')]")
	WebElement toptenLink;

	public String getHomePageTitle() {
		return driver.getTitle();
	}

	public boolean validateHomePageLogo() {
		return logo.isDisplayed();
	}

	public LoginPage register() throws IOException {
		loginLink.click();
		return new LoginPage();
	}

	public ProteinsTab cDeals() throws IOException {
		crazyLink.click();
		return new ProteinsTab();
	}

	public ToptenProducts topTen() throws IOException {
		toptenLink.click();
		return new ToptenProducts();
	}
	
	public WebElement seachBar() {
		return searchbar;
	}

	public WebElement seachBtn() {
		return searchbtn;
	}
	
	public WebElement loginLink() {
		return loginLink;
	}

}
