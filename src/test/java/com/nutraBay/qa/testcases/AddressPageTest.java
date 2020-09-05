package com.nutraBay.qa.testcases;

import java.io.IOException;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.nutraBay.qa.base.BaseTest;
import com.nutraBay.qa.pages.AddressPage;
import com.nutraBay.qa.pages.HomePage;
import com.nutraBay.qa.pages.LoginPage;
import com.nutraBay.qa.pages.ProfilePage;
import com.nutraBay.qa.util.TestUtil;

public class AddressPageTest extends BaseTest {
	ProfilePage profilepage;
	AddressPage addresspage;
	LoginPage loginpage;
	HomePage homepage;

	String sheetName = "address_1";

	public AddressPageTest() throws IOException {
		super();
	}

	@BeforeMethod
	public void setUp() throws IOException {
		driverInvocation();
		// this step is done to avoid null pointer exception..
		loginpage = new LoginPage();
		homepage = new HomePage();
		addresspage = new AddressPage();
		homepage = new HomePage();
		homepage.loginLink().click();
		profilepage = loginpage.accLogin(prop.getProperty("username"), prop.getProperty("password"));
		addresspage = new AddressPage();
		profilepage = new ProfilePage();
	}

	@Test(dataProvider = "getAddressData")
	public void validateAddressData(String fn, String ln, String pin, String add, String st, String mob, String ct){
		profilepage.addressLink().click();
		profilepage.editLink().click();
		addresspage.addAddress(fn, ln, pin, add, st, mob, ct);
	}

	@DataProvider
	public Object[][] getAddressData() {
		Object[][] data = TestUtil.getTestData(sheetName);
		return data;
	}
	
	@AfterMethod
	public void tearDown() {
		driver.quit();
	}


}
