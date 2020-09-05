package com.nutraBay.qa.pages;

import java.io.IOException;

import org.openqa.selenium.JavascriptExecutor;
//import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.nutraBay.qa.base.BaseTest;

public class AddressPage extends BaseTest {

	public AddressPage() throws IOException {
		super();
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//input[@id='billing_first_name']")
	WebElement firstName;

	@FindBy(xpath = "//input[@id='billing_last_name']")
	WebElement lastName;

	@FindBy(xpath = "//input[@id='billing_postcode']")
	WebElement pinCode;

	@FindBy(xpath = "//input[@id='billing_address_1']")
	WebElement address;

	@FindBy(xpath = "//input[@class='select2-search__field']")
	WebElement state;

	@FindBy(xpath = "//input[@type='tel']")
	WebElement mobile;

	@FindBy(id = "billing_city")
	WebElement city;

	@FindBy(xpath = "//button[@name = 'save_address']")
	WebElement saveBtn;
	
	public void clrTxtBox(WebElement ele) {
		ele.clear();
	}
	
	public void addAddress(String fn, String ln, String pin, String add, String st, String mob, String ct) {
		WebElement[] elements = {firstName, lastName, pinCode, address, mobile, city};
		for (int i = 0; i < elements.length; i++) {
			clrTxtBox(elements[i]);
		}
		firstName.sendKeys(fn);
		lastName.sendKeys(ln);
		pinCode.sendKeys(pin);
		address.sendKeys(add);
//		state.sendKeys(st);
//		state.sendKeys(Keys.ENTER);
		mobile.sendKeys(mob);
		city.sendKeys(ct);
		JavascriptExecutor js = (JavascriptExecutor)driver;
		js.executeScript("arguments[0].scrollIntoView();", saveBtn);
		saveBtn.click();
	}

}
