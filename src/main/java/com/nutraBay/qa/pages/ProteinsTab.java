package com.nutraBay.qa.pages;

import java.io.IOException;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import com.nutraBay.qa.base.BaseTest;

public class ProteinsTab extends BaseTest {

	public ProteinsTab() throws IOException {
		super();
		PageFactory.initElements(driver, this);
	}
	public Select select;

	@FindBy(xpath = "//body/div[@id='wrapper']/header[@id='header']"
			+ "/div/div[@id='wide-nav']/div/div/ul/li[@id='menu-item-15803']/a[1]")
	WebElement proteinTab;

	@FindBy(xpath = "//form[@class='woocommerce-ordering']")
	WebElement dropDown;
	
	@FindBy(xpath = "//select[@class = 'orderby']")
	WebElement selectOption;


	public WebElement getProteinTab() {
		return proteinTab;
	}

	public WebElement dropDown() {
		return dropDown;
	}
	
	public WebElement selectOption() {
		return selectOption;
	}
	
	
	
	public String selectDropDown(String desired) {
		select = new Select(selectOption);
		select.selectByValue(desired);
		String value = select.getFirstSelectedOption().getText();
		return value;
	}

}
