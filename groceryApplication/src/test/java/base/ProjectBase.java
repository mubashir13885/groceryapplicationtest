package base;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;

import constants.Constant;
import utilities.ScreenshotUtility;

public class ProjectBase {
	Properties prop;//Declaring Properties class as a global var
	FileInputStream f;
	public WebDriver driver;
	@BeforeMethod (alwaysRun = true)
	@Parameters ("browser")
	public void initializeBrowser(String browser) throws Exception {
		prop = new Properties();
		f= new FileInputStream(Constant.CONFIGFILE);
		prop.load(f);//load any file with .properties
		//driver = new ChromeDriver();
		if(browser.equalsIgnoreCase("chrome")) {
			driver=new ChromeDriver();
			
		}
		else if (browser.equalsIgnoreCase("firefox")) {
			driver = new FirefoxDriver();
		}
		else {
			System.out.println("Invalid browser");
		}
		driver.get(prop.getProperty("url"));
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver.manage().window().maximize();
		
	}
	@AfterMethod(alwaysRun = true)//alwaysRun = true: @AfterMethod must run in every scenario
	public void driverQuit(ITestResult iTestResult) throws IOException
	{
		//ITestResult: predefined interface having all info regarding test data
		if(iTestResult.getStatus()==ITestResult.FAILURE)
		{
			ScreenshotUtility screenShot=new ScreenshotUtility();
			//iTestResult.getName: Returns name of test method
			screenShot.getScreenshot(driver, iTestResult.getName());
		}
		driver.quit();
	}

	/*@AfterMethod
	public void closeBrowser() {
		driver.close();
	}*/

}
