package com.nutraBay.qa.testcases;

import java.io.IOException;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
//import org.openqa.selenium.WebElement;
import org.testng.Assert;

import com.nutraBay.qa.base.BaseTest;
import com.nutraBay.qa.pages.ProteinsTab;


public class ProteinTabTest extends BaseTest{
	
	ProteinsTab pt;

	public ProteinTabTest() throws IOException {
		super();
	}
	
	@BeforeMethod
	public void setUp() throws IOException {
		driverInvocation();
		// this step is done to avoid null pointer exception..
		pt = new ProteinsTab();
	}
	
	
//	@Test
//	public void validateProteintab() {
//		pt.getProteinTab().click();
//		pt.dropDown().click();
//	}
	
	@Test
	public void validateDropdown() {
		pt.getProteinTab().click();
		pt.dropDown().click();
		String value = pt.selectDropDown(prop.getProperty("desiredValue"));
		Assert.assertEquals(value, "Sort by latest");
	}
	
	@AfterMethod
	public void tearDown() {
		driver.quit();
	}


}
