package com.nutraBay.qa.testcases;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.nutraBay.qa.base.BaseTest;
import com.nutraBay.qa.pages.HomePage;
import com.nutraBay.qa.pages.LoginPage;
import com.nutraBay.qa.pages.ProfilePage;

public class LoginPageTest extends BaseTest {
	LoginPage loginpage;
	ProfilePage profilepage;
	HomePage homepage;

	public LoginPageTest() throws IOException {
		super();
	}

	@BeforeMethod
	public void setUp() throws IOException {
		driverInvocation();
		// this step is done to avoid null pointer exception..
		loginpage = new LoginPage();
		profilepage = new ProfilePage();
		homepage = new HomePage();
	}

	@Test(priority = 1)
	public void validateLogin() throws IOException {
		homepage.loginLink().click();
//		driver.manage().timeouts().pageLoadTimeout(TestUtil.page_Load_Timeout, TimeUnit.SECONDS);
		profilepage = loginpage.accLogin(prop.getProperty("username"), prop.getProperty("password"));
	}

	@Test(priority = 2)
	public void validatePageTitle() {
		homepage.loginLink().click();
		String lgnTitle = loginpage.getPageTitle();
		Assert.assertEquals(lgnTitle, "My Account : NUTRABAY™");
	}

	@AfterMethod
	public void tearDown() {
		driver.quit();
	}

}
