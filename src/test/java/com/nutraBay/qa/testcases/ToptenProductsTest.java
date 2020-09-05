package com.nutraBay.qa.testcases;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.nutraBay.qa.base.BaseTest;
import com.nutraBay.qa.pages.ToptenProducts;

public class ToptenProductsTest extends BaseTest {
	ToptenProducts topTenProd;

	public ToptenProductsTest() throws IOException {
		super();
	}
	
	@BeforeMethod
	public void setUp() throws IOException {
		driverInvocation();
		topTenProd = new ToptenProducts();
	}
	
	@Test
	public void validateNumofProd() {
		int count = topTenProd.countTheProducts();
		Assert.assertEquals(count, 10);
	}
	
	@Test 
	public void validatePageTitle() {
		String mainTitle = topTenProd.getMainTitle();
		Assert.assertEquals(mainTitle, "TOP 10 BEST SELLING SUPPLEMENTS");
	}
	
	@AfterMethod
	public void tearDown() {
		driver.quit();
	}

}
