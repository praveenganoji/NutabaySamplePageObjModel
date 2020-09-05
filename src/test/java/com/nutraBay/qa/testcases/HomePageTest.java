package com.nutraBay.qa.testcases;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.nutraBay.qa.base.BaseTest;
import com.nutraBay.qa.pages.HomePage;

public class HomePageTest extends BaseTest {
	HomePage homepage;

	public HomePageTest() throws IOException {
		super();
	}

	@BeforeMethod
	public void setUp() throws IOException {
		driverInvocation();
		homepage = new HomePage();
	}

	@Test(priority = 1)
	public void validateTitle() {
		String title = homepage.getHomePageTitle();
		Assert.assertEquals(title, "NUTRABAY™ - India’s #1 Authentic Supplement Store Online");
	}

	@Test(priority = 2)
	public void validateLogo() {
		boolean flag = homepage.validateHomePageLogo();
		Assert.assertTrue(flag);
	}

	@Test(priority = 3)
	public void clickOnRegister() throws IOException {
		homepage.register();
		String title = driver.getTitle();
		Assert.assertEquals(title, "My Account : NUTRABAY™");
	}

	@Test
	public void clickOnLoginLink() {
		homepage.loginLink().click();
	}

	@AfterMethod
	public void tearDown() {
		driver.quit();
	}

}
