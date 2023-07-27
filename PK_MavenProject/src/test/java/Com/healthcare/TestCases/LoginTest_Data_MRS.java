package Com.healthcare.TestCases;

import java.io.IOException;

import org.testng.Assert;
import org.testng.AssertJUnit;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import Com.healthcare.Baseclass.BaseClass_OpenMRS;
import Com.healthcare.Pageclass.Login_MRS;
import Com.healthcare.utilities.ExcelUtils_MRS;

public class LoginTest_Data_MRS extends BaseClass_OpenMRS {

	@Test(dataProvider = "Logindata")
	public void Login(String User, String Pass, String Expected) throws InterruptedException {

		Login_MRS LG = new Login_MRS(); // Created the object of the

		LG.Setusername(User);
		loggers.info("Enter the Username");
		Thread.sleep(2000);
		LG.SetPassword(Pass);
		loggers.info("Enter the Password");
		Thread.sleep(2000);
		LG.Wardclick();
		loggers.info("Click on the Ward button");
		Thread.sleep(2000);
		LG.Login_Click();
		loggers.info("Click the Login button");

		String Act_Title = driver.getTitle();
		String Exp_Title = "Home";

		if (Expected.equals("Valid")) {
			if (Act_Title.equals(Exp_Title)) {

				Assert.assertTrue(true);
				loggers.info("Login test case pass");
			} else {
				Assert.assertTrue(false);
				loggers.info("login test case failed");
			}
		} else if (Expected.equals("Invaild")) {
			if (Act_Title.equals(Exp_Title)) {
				AssertJUnit.assertTrue(false);
				loggers.info("Login test case pass");
			} else {
				Assert.assertTrue(true);
				loggers.info("Login test case failed");
			}
		}

	}

	@DataProvider(name = "Logindata")
	public Object[][] Getdata() throws IOException {

		String Path ="C:\\Users\\Prashant\\eclipse-workspace\\PK_MavenProject\\src\\main\\java\\Com\\healthcare\\Testdata\\DataPrivider.xlsx";

		int R1 = ExcelUtils_MRS.GetRowcount(Path, "Sheet1");
		int C1 = ExcelUtils_MRS.GetCellcount(Path, "Sheet1", 1);

		Object logindata[][] = new Object[R1][C1];

		for (int i=1; i<R1; i++) {

			for (int j=0; j<C1; j++) {

				logindata[i-1][j] = ExcelUtils_MRS.GetCelldata(Path, "Sheet1", i, j);
			}
		}
		return logindata;
	}

}
