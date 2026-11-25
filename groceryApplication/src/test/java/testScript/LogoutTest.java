package testScript;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import base.ProjectBase;
import constants.Constant;
import constants.Messages;
import pages.LoginPage;
import utilities.ExcelUtility;
import pages.HomePage;

public class LogoutTest extends ProjectBase {

	@Test (description = "Clicking on profile icon and loging out")
	public void verifyLogout() throws IOException {
		String usernameValue = ExcelUtility.getStringData(1, 0, Constant.SHEETNAME);
		String PasswordValue = ExcelUtility.getStringData(1, 1, Constant.SHEETNAME);
		LoginPage loginpg = new LoginPage(driver);
		//loginpg.enterUsername("admin");
		//loginpg.enterPassword("admin");
		//loginpg.performLogin();

		//HomePage logoutpg = new HomePage(driver);
		//logoutpg.clickUserIcon();
		//logoutpg.clickLogoutButton();

		loginpg.enterUsername(usernameValue).enterPassword(PasswordValue).performLogin().clickUserIcon().clickLogoutButton();
		String expectedUrl = "https://groceryapp.uniqassosiates.com/admin/login";
		String actualUrl = driver.getCurrentUrl();
		Assert.assertEquals(actualUrl, expectedUrl, Messages.INVALIDLOGOUT_MESSAGE);
	}
}