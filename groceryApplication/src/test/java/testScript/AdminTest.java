package testScript;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import base.ProjectBase;
import constants.Constant;
import constants.Messages;
import pages.AdminPage;
import pages.LoginPage;
import utilities.ExcelUtility;
import utilities.RandomDataGenarator;

public class AdminTest extends ProjectBase {

	@Test (priority = 1,description = " Going to admin clicking more info Adding new user",groups= {"smoke"})
	public void verifyNewAdminUser() throws IOException {
		RandomDataGenarator rd = new RandomDataGenarator();
		String randomusername = rd.createRandomUserName();
		String randomPasswrd = rd.createRandomPassword();

		String usernameValue = ExcelUtility.getStringData(1, 0,Constant.SHEETNAME);
		String PasswordValue = ExcelUtility.getStringData(1, 1, Constant.SHEETNAME);
		LoginPage loginpg = new LoginPage(driver);
		//loginpg.enterUsername(usernameValue);
		//loginpg.enterPassword(PasswordValue);
		//loginpg.performLogin();
		
		loginpg.enterUsername(usernameValue).enterPassword(PasswordValue).performLogin().
		clickMoreInfo().clickNewButton().enterUsername(randomusername).enterPassword(randomPasswrd).
		selectUserType(1).clickSaveButton();

		AdminPage adminpg = new AdminPage(driver);
		//adminpg.clickMoreInfo();
		//adminpg.clickNewButton();
		//adminpg.enterUsername(randomusername);
		//adminpg.enterPassword(randomPasswrd);
		//adminpg.selectUserType(1);
		//adminpg.clickSaveButton();
		
		

		boolean visible = adminpg.isSuccessAlertDisplayed();
		Assert.assertTrue(visible,Messages.ADMINADDED_MESSAGE );
	}

	@Test (priority = 2,description = " Going to admin and Seaching a user within the list")
	public void verifySearch() throws IOException {
		String usernameValue = ExcelUtility.getStringData(1, 0, Constant.SHEETNAME);
		String PasswordValue = ExcelUtility.getStringData(1, 1, Constant.SHEETNAME);
		LoginPage loginpg = new LoginPage(driver);
		//loginpg.enterUsername(usernameValue);
		//loginpg.enterPassword(PasswordValue);
		//loginpg.performLogin();
		loginpg.enterUsername(usernameValue).enterPassword(PasswordValue).performLogin().
		clickMoreInfo().clickSearchButton().enterSearchUsername("brice.witting").clickSearchButton();

		AdminPage adminpg = new AdminPage(driver);
		//adminpg.clickMoreInfo();
		//adminpg.clickSearchButton();
		//adminpg.enterSearchUsername("adelle.leuschke");
		//adminpg.selectSearchUserType(1);
		//adminpg.clickSearchSubmitButton();
		
		String expectedUsername = "brice.witting";
		String actualUsername = adminpg.getFirstSearchedUsername();
		Assert.assertEquals(actualUsername, expectedUsername, Messages.USERNOTFOUND_MESSAGE);
		
	}

	@Test (priority = 3, description = "Clicking on Home button to return to home")
	public void returnToHome() throws IOException {
		String usernameValue = ExcelUtility.getStringData(1, 0, Constant.SHEETNAME);
		String PasswordValue = ExcelUtility.getStringData(1, 1, Constant.SHEETNAME);
		LoginPage loginpg = new LoginPage(driver);
		//loginpg.enterUsername(usernameValue);
		//loginpg.enterPassword(PasswordValue);
		//loginpg.performLogin();
		
		loginpg.enterUsername(usernameValue).enterPassword(PasswordValue).performLogin().clickMoreInfo().clickHomeLink();

		AdminPage adminpg = new AdminPage(driver);
		//adminpg.clickMoreInfo();
		//adminpg.clickHomeLink();
		
		String expectedUrl = "https://groceryapp.uniqassosiates.com/admin/home";
		String actualUrl = driver.getCurrentUrl();
		Assert.assertEquals(actualUrl, expectedUrl, Messages.HOMEPAGEBUTTONFAIL_MESSAGE);
	}
}