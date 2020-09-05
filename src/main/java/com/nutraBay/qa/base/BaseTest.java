package com.nutraBay.qa.base;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;

import com.nutraBay.qa.util.TestUtil;

public class BaseTest {

	public static WebDriver driver;
	public static Properties prop;

	public BaseTest() throws IOException {
		prop = new Properties();
		FileInputStream ip = new FileInputStream(
				"Z:\\end2EndTest\\src\\main\\java\\com\\nutraBay\\qa\\config\\config.properties");
		prop.load(ip);
	}

	public void driverInvocation() {
		String browserName = prop.getProperty("browser");

		if (browserName.equals("chrome")) {
			System.setProperty("webdriver.chrome.driver", "Z:\\selenium\\chromedriver\\chromedriver.exe");
			driver = new ChromeDriver();
		} else if (browserName.equals("edge")) {
			System.setProperty("webdriver.edge.driver", "Z:\\selenium\\edgedriver_win64 (1)\\msedgedriver.exe");
			driver = new EdgeDriver();
		}

		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(TestUtil.page_Load_Timeout, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(TestUtil.implicitly_Wait, TimeUnit.SECONDS);

		driver.get(prop.getProperty("url"));
	}

}
