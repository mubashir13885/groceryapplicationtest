package testScript;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import base.ProjectBase;
import constants.Constant;
import constants.Messages;
import pages.DeliverBoyPage;
import pages.LoginPage;
import utilities.ExcelUtility;
import utilities.RandomDataGenarator;

public class DeliveryBoyTest extends ProjectBase {

	@Test (description = "Going to delivery boy and adding new delivery boy")
	public void verifyAddDeliveryboy() throws IOException {
		String usernameValue = ExcelUtility.getStringData(1, 0, Constant.SHEETNAME);
		String PasswordValue = ExcelUtility.getStringData(1, 1, Constant.SHEETNAME);
		RandomDataGenarator randomdata = new RandomDataGenarator();
		String deliveryboyname = randomdata.createRandomFullName();
		String deliveryemail = randomdata.createRandomEmailAddress();
		String deliverusername = randomdata.createRandomUserName();
		String deliverypassword = randomdata.createRandomPassword();
		LoginPage loginpg = new LoginPage(driver);
		//loginpg.enterUsername(usernameValue);
		//loginpg.enterPassword(PasswordValue);
		//loginpg.performLogin();

		loginpg.enterUsername(usernameValue).enterPassword(PasswordValue).performLogin()
		.clickMoreInfos().clickNewButton().enterName(deliveryboyname).
		enterEmail(deliveryemail).enterPhone("2325423523532").enterAddress("sgfggrgrgvrvxv").enterUsername(deliverusername)
		.enterPassword(deliverypassword).clickSaveButton();
		DeliverBoyPage deliveryBoyPg = new DeliverBoyPage(driver);
		//deliveryBoyPg.clickMoreInfo();
		//deliveryBoyPg.clickNewButton();
		//deliveryBoyPg.enterName("Mubashir");
		//deliveryBoyPg.enterEmail("mbshr123@gmainl.com");
		//deliveryBoyPg.enterPhone("4245145242");
		//deliveryBoyPg.enterAddress("calicut,kerala,india");
		//deliveryBoyPg.enterUsername("mbshr");
		//deliveryBoyPg.enterPassword("1234567");
		//deliveryBoyPg.clickSaveButton();
		
		
		boolean visible = deliveryBoyPg.isSuccessAlertDisplayed();
		Assert.assertTrue(visible, Messages.DELIVERBOY_MESSAGE);
	}
}