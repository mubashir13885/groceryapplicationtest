package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utilities.WaitUtility;

public class ContactPage {
	public WebDriver driver;
	WaitUtility waitutil = new WaitUtility();
	public ContactPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	

	@FindBy(xpath = "//a[@class='btn btn-sm btn btn-primary btncss']")
	WebElement clickediticon;

	@FindBy(id = "phone")
	WebElement updatephnnumber;

	@FindBy(xpath = "//button[@class='btn btn-block-sm btn-info']")
	WebElement clickUpdate;

	@FindBy(xpath = "//div[@class='alert alert-success alert-dismissible']")
	WebElement successAlert;



	public ContactPage clickEditIcon() {
		waitutil.waitUntilClickable(driver, clickediticon);
		clickediticon.click();
		return this;
	}

	public ContactPage enterPhoneNumber(String phoneNumber) {
		updatephnnumber.clear();
		updatephnnumber.sendKeys(phoneNumber);
		return this;
	}

	public ContactPage clickUpdateButton() {
		clickUpdate.click();
		return this;
	}

	public boolean isSuccessAlertDisplayed() {
		return successAlert.isDisplayed();
	}
}