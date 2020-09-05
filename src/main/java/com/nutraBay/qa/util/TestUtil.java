package com.nutraBay.qa.util;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

import com.nutraBay.qa.base.BaseTest;

public class TestUtil {

	public static int page_Load_Timeout = 20;
	public static int implicitly_Wait = 20;

	public static String TESTDATA_SHEET_PATH = BaseTest.prop.getProperty("sheetPath");

	// "Z:\\end2EndTest\\src\\main\\java\\com\\nutraBay\\qa\\testdata\\address_1.xlsx"; // TESTDATA_SHEET_PATH
	static Sheet sheet;
	static Workbook book;

	public static Object[][] getTestData(String sheetName)  {
		FileInputStream file = null;
		try {
			file = new FileInputStream(TESTDATA_SHEET_PATH);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			book = WorkbookFactory.create(file);
		} catch (EncryptedDocumentException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		sheet = book.getSheet(sheetName);
		Object[][] data = new Object[sheet.getLastRowNum()][sheet.getRow(0).getLastCellNum()];
		for (int i = 0; i < sheet.getLastRowNum(); i++) {
			for (int k = 0; k < sheet.getRow(0).getLastCellNum(); k++) {
				data[i][k] = sheet.getRow(i + 1).getCell(k).toString();
			}
		}
		return data;
	}

//	public static void takeScreenshotAtEndOfTest() throws IOException {
//		File scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
//		String currentDir = System.getProperty("user.dir");
//		FileUtils.copyFile(scrFile, new File(currentDir + "/screenshots/" + System.currentTimeMillis() + ".png"));
//	}

}