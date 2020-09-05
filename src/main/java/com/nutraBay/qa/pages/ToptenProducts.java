package com.nutraBay.qa.pages;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.nutraBay.qa.base.BaseTest;

public class ToptenProducts extends BaseTest {

	public ToptenProducts() throws IOException {
		super();
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//div[@id='wide-nav']//div//div//a[contains(text(),'Top 10')]")
	WebElement topTenLink;

	@FindBy(xpath = "//span[@class = 'section-title-main']")
	WebElement mainTitle;

	public int countTheProducts() {
		topTenLink.click();
		WebElement prodList = driver.findElement(By.xpath("//div[@class = 'col-inner']"));
		int countOfProd = prodList.findElements(By.xpath("//section[@class = 'section']")).size();
		return countOfProd;
	}
	
	public String getMainTitle() {
		topTenLink.click();
		String title = mainTitle.getText();
		return title;
	}

}
