package testScript;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import base.ProjectBase;
import constants.Constant;
import constants.Messages;
import pages.ContactPage;
import pages.LoginPage;
import utilities.ExcelUtility;

public class ContactTest extends ProjectBase {

	@Test (description = "Going to contact and updating the phone number")
	public void verifyContact() throws IOException {
		String usernameValue = ExcelUtility.getStringData(1, 0, Constant.SHEETNAME);
		String PasswordValue = ExcelUtility.getStringData(1, 1, Constant.SHEETNAME);
		LoginPage loginpg = new LoginPage(driver);
		//loginpg.enterUsername(usernameValue);
		//loginpg.enterPassword(PasswordValue);
		//loginpg.performLogin();
		
		loginpg.enterUsername(usernameValue).enterPassword(PasswordValue).performLogin()
		.clickManageContent().clickManageContact().clickEditIcon().enterPhoneNumber("3323442354545").clickUpdateButton();

		ContactPage contactpg = new ContactPage(driver);
		//contactpg.clickManageContent();
		//contactpg.clickManageContact();
		//contactpg.clickEditIcon();
		//contactpg.enterPhoneNumber("7902774632");
		//contactpg.clickUpdateButton();
		
		boolean visible = contactpg.isSuccessAlertDisplayed();
		Assert.assertTrue(visible,Messages.CONTACT_MESSAGE);
	}
}