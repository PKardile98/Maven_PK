package Com.healthcare.Baseclass;

import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import Com.healthcare.Configuration.Read_configuration_MRS;
import Com.healthcare.Pageclass.Login_MRS;

public class BaseClass_OpenMRS {

	public static WebDriver driver;
	public static Logger loggers;

	Read_configuration_MRS RC = new Read_configuration_MRS();
	public String BaseURL = RC.GetAppURL();
	public String Username = RC.U_Name();
	public String Password = RC.Pass();

	@SuppressWarnings({ "deprecation", "static-access" })
	@BeforeMethod
	public void LaunchBrowser() throws InterruptedException {
		
		loggers = loggers.getLogger("PK_MavenProject");

		PropertyConfigurator.configure("C:\\Users\\Prashant\\git\\Maven_PK\\PK_MavenProject\\src\\test\\resources\\Configuration\\Log4j.properties");


		System.setProperty("webdriver.Chrome.Driver",
				RC.GetChormePath());

		driver = new ChromeDriver();
		loggers.info("Open the browser");

		driver.manage().window().maximize();
		loggers.info("Max. the window");

		
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);

		driver.get(BaseURL);
		loggers.info("Hit the URL");

//		Login_MRS LG = new Login_MRS(); // Created the object of the

//		LG.Setusername(Username);
//		loggers.info("Enter the Username");
//		Thread.sleep(2000);
//		LG.SetPassword(Password);
//		loggers.info("Enter the Password");
//		Thread.sleep(2000);
//		LG.Wardclick();
//		loggers.info("Click on the Ward button");
//		Thread.sleep(2000);
//		LG.Login_Click();
//		loggers.info("Click the Login button");

		Thread.sleep(2000);

	}

	@AfterMethod
	public void TearDown() throws InterruptedException {

		Thread.sleep(3000);
		driver.close();
	}
}
