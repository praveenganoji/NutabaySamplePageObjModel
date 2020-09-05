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

public class ProfilePageTest extends BaseTest {
	LoginPage loginpage;
	ProfilePage profilepage;
	HomePage homepage;

	public ProfilePageTest() throws IOException {
		super();
	}
	
	@BeforeMethod
	public void setUp() throws IOException {
		driverInvocation();
		// this step is done to avoid null pointer exception..
	    loginpage = new LoginPage();
	    homepage = new HomePage();
	    homepage.loginLink().click();
		profilepage = loginpage.accLogin(prop.getProperty("username"), prop.getProperty("password"));
	}
	
	@Test
	public void navigateToProfile() throws IOException {
		String accName = profilepage.getAccName().getText();
		Assert.assertEquals(accName, "sathyanaik9794 #368031");
		profilepage.getOrders().click();
		driver.navigate().back();
		profilepage.logOut().click();
	}
	
	@AfterMethod
	public void tearDown() {
		driver.quit();
	}
	
	

}
