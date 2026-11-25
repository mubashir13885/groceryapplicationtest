package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utilities.WaitUtility;

public class HomePage {
	public WebDriver driver;
	WaitUtility waitutil = new WaitUtility();
	public HomePage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	

	@FindBy(xpath = "//img[@class='img-circle']")
	WebElement clickicon;

	@FindBy(xpath = "//a[@href='https://groceryapp.uniqassosiates.com/admin/logout'and @class='dropdown-item']")
	WebElement clickLogout;
	
	@FindBy(xpath = "//a[@href='https://groceryapp.uniqassosiates.com/admin/list-admin' and @class='small-box-footer']")
	WebElement moreinfo;
	
	@FindBy(xpath = "//p[contains(text(),\"Manage Content\")]")
	WebElement clickmngcontent;

	@FindBy(xpath = "//a[@href ='https://groceryapp.uniqassosiates.com/admin/list-contact' ]")
	WebElement clickmngcontact;
	
	@FindBy(xpath = "//a[@href='https://groceryapp.uniqassosiates.com/admin/list-deliveryboy' and @class='small-box-footer']")
	WebElement deliverymoreinfo;

	public HomePage clickUserIcon() {
		clickicon.click();
		return this;
	}

	public LoginPage clickLogoutButton() {
		clickLogout.click();
		return new LoginPage(this.driver);
	}
	
	public AdminPage clickMoreInfo() {
		waitutil.waitUntilClickable(driver, moreinfo);
		moreinfo.click();
		
		return new AdminPage(this.driver);
		
		
	}
	public HomePage clickManageContent() {
		waitutil.waitUntilClickable(driver, clickmngcontent);
		clickmngcontent.click();
		
		return this;
		
	}

	public ContactPage clickManageContact() {
		clickmngcontact.click();
		return new ContactPage(this.driver);
	}
	
	public DeliverBoyPage clickMoreInfos() {
		deliverymoreinfo.click();
		return new DeliverBoyPage(this.driver);
	}
}