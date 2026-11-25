package testScript;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import base.ProjectBase;
import constants.Constant;
import constants.Messages;
import pages.LoginPage;
import utilities.ExcelUtility;

public class LoginTest extends ProjectBase {

	@Test (priority = 1 , description = "Valid login with credentials",retryAnalyzer = retry.Retry.class)
	
	public void verifyValidLogin() throws IOException {
		String usernameValue = ExcelUtility.getStringData(1, 0, Constant.SHEETNAME);
		String PasswordValue = ExcelUtility.getStringData(1, 1, Constant.SHEETNAME);
		LoginPage loginpg = new LoginPage(driver);
		//WebElement username = driver.findElement(By.xpath("//input[@class ='form-control' and @type = 'text']"));
		//username.sendKeys(usernameValue);
		//loginpg.enterUsername(usernameValue);
		//WebElement password = driver.findElement(By.xpath("//input[@class ='form-control' and @type = 'password']"));
		//password.sendKeys(PasswordValue);
		//loginpg.enterPassword(PasswordValue);
		//WebElement btn = driver.findElement(By.xpath("//button[text()='Sign In']"));
		//btn.click();
		//loginpg.performLogin();
		loginpg.enterUsername(usernameValue).enterPassword(PasswordValue).performLogin();
		String expectedUrl ="https://groceryapp.uniqassosiates.com/admin";
		String actualUrl = driver.getCurrentUrl();
		Assert.assertEquals(actualUrl, expectedUrl, Messages.VALIDLOGIN_MESSAGE);
		
	}
	
	
	@Test (priority = 2 , description = "invalid login with valid username and invalid password")
	
	public void verifyInvalidLoginWithValidUsernameAndInvalidPssword() throws IOException {
		String usernameValue = ExcelUtility.getStringData(2, 0, Constant.SHEETNAME);
		String PasswordValue = ExcelUtility.getStringData(2, 1, Constant.SHEETNAME);
		//WebElement username = driver.findElement(By.xpath("//input[@class ='form-control' and @type = 'text']"));
		//username.sendKeys(usernameValue);
		//WebElement password = driver.findElement(By.xpath("//input[@class ='form-control' and @type = 'password']"));
		//password.sendKeys(PasswordValue);
		//WebElement btn = driver.findElement(By.xpath("//button[text()='Sign In']"));
		//btn.click();
		LoginPage loginpg = new LoginPage(driver);
		//loginpg.enterUsername(usernameValue);
		//loginpg.enterPassword(PasswordValue);
		//loginpg.performLogin();
		loginpg.enterUsername(usernameValue).enterPassword(PasswordValue).performLogin();
		String expectedUrl ="https://groceryapp.uniqassosiates.com/admin/login";
		String actualUrl = driver.getCurrentUrl();
		Assert.assertEquals(actualUrl, expectedUrl, Messages.INVALIDLOGIN_MESSAGE);
	}
	
	@Test (priority = 3 , description = "invalid login with inalid login and valid password")
	
	public void verifyInvalidLoginWithInValidUsernameAndvalidPssword() throws IOException {
		String usernameValue = ExcelUtility.getStringData(3, 0, Constant.SHEETNAME);
		String PasswordValue = ExcelUtility.getStringData(3, 1, Constant.SHEETNAME);
		//WebElement username = driver.findElement(By.xpath("//input[@class ='form-control' and @type = 'text']"));
		//username.sendKeys(usernameValue);
		//WebElement password = driver.findElement(By.xpath("//input[@class ='form-control' and @type = 'password']"));
		//password.sendKeys(PasswordValue);
		//WebElement btn = driver.findElement(By.xpath("//button[text()='Sign In']"));
		//btn.click();
		LoginPage loginpg = new LoginPage(driver);
		//loginpg.enterUsername(usernameValue);
		//loginpg.enterPassword(PasswordValue);
		//loginpg.performLogin();
		loginpg.enterUsername(usernameValue).enterPassword(PasswordValue).performLogin();
		String expectedUrl ="https://groceryapp.uniqassosiates.com/admin/login";
		String actualUrl = driver.getCurrentUrl();
		Assert.assertEquals(actualUrl, expectedUrl, Messages.INVALIDLOGIN_MESSAGE);
	}
	
	@Test (priority = 4,dataProvider = "loginProvider",description = "invalid login  with invalid username and invalid password")
	
	public void verifyInvalidLoginWithInValidUsernameAndInvalidPssword(String usernamevalue ,String passwordvalue) throws IOException {
		//String usernameValue = ExcelUtility.getStringData(4, 0, "login sheet");
		//String PasswordValue = ExcelUtility.getStringData(4, 1, "login sheet");
		//WebElement username = driver.findElement(By.xpath("//input[@class ='form-control' and @type = 'text']"));
		//username.sendKeys(usernameValue);
		//WebElement password = driver.findElement(By.xpath("//input[@class ='form-control' and @type = 'password']"));
		//password.sendKeys(PasswordValue);
		//WebElement btn = driver.findElement(By.xpath("//button[text()='Sign In']"));
		//btn.click();
		LoginPage loginpg = new LoginPage(driver);
		//loginpg.enterUsername(usernamevalue);
		//loginpg.enterPassword(passwordvalue);
		//loginpg.performLogin();
		loginpg.enterUsername(usernamevalue).enterPassword(passwordvalue).performLogin();
		String expectedUrl ="https://groceryapp.uniqassosiates.com/admin/login";
		String actualUrl = driver.getCurrentUrl();
		Assert.assertEquals(actualUrl, expectedUrl, Messages.INVALIDLOGIN_MESSAGE);
	}
	//Data provider:
	@DataProvider(name="loginProvider")
	//Syntax:
	public Object[][] getDataFromDataProvider() throws IOException
	{
		return new Object[][] { new Object[] {"user","password"},
			new Object[] {"username","pass"},
			new Object[] {"user","password"}
		};
	}
	
	
	
}


