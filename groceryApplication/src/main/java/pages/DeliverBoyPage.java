package pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utilities.Pageutility;
import utilities.WaitUtility;

public class DeliverBoyPage {
	public WebDriver driver;
    WaitUtility waitutil = new WaitUtility();
    Pageutility pageutil = new Pageutility();
	public DeliverBoyPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	

	@FindBy(xpath = "//a[@class='btn btn-rounded btn-danger']")
	WebElement clicknew;

	@FindBy(id = "name")
	WebElement entername;

	@FindBy(id = "email")
	WebElement enterEmail;

	@FindBy(id = "phone")
	WebElement enterPhn;

	@FindBy(id = "address")
	WebElement enteradress;

	@FindBy(id = "username")
	WebElement enterUsername;

	@FindBy(id = "password")
	WebElement enterPsswrd;

	@FindBy(xpath = "//button[@name='create']")
	WebElement clickSave;
	
	@FindBy(xpath = "//div[contains(@class, 'alert-success')]")
	 WebElement successAlert;

	

	public DeliverBoyPage clickNewButton() {
		waitutil.waitUntilClickable(driver, clicknew);
		clicknew.click();
		return this;
	}

	public DeliverBoyPage enterName(String name) {
		entername.sendKeys(name);
		return this;
	}

	public DeliverBoyPage enterEmail(String email) {
		enterEmail.sendKeys(email);
		return this;
	}

	public DeliverBoyPage enterPhone(String phone) {
		enterPhn.sendKeys(phone);
		return this;
	}

	public DeliverBoyPage enterAddress(String address) {
		enteradress.sendKeys(address);
		return this;
	}

	public DeliverBoyPage enterUsername(String username) {
		enterUsername.sendKeys(username);
		return this;
	}

	public DeliverBoyPage enterPassword(String password) {
		enterPsswrd.sendKeys(password);
		return this;
	}

	public DeliverBoyPage clickSaveButton() {
		//JavascriptExecutor js = (JavascriptExecutor) driver;
		//js.executeScript("window.scrollTo(0, document.body.scrollHeight)", "");
		pageutil.scrollUntilPageEnd(this.driver);
		waitutil.waitUntilClickable(driver, clickSave);
		clickSave.click();
		return this;
	}
	public boolean isSuccessAlertDisplayed() {
		return successAlert.isDisplayed();

	}


}