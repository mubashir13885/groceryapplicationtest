package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import utilities.Pageutility;
import utilities.WaitUtility;

public class AdminPage {
	public WebDriver driver;

	WaitUtility waitutil = new WaitUtility();
	Pageutility pageutil = new Pageutility();
	public AdminPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
		
		
	}

	@FindBy(xpath = "//a[@class='btn btn-rounded btn-danger']")
	WebElement newinfo;

	@FindBy(id = "username")
	WebElement usrnme;

	@FindBy(id = "password")
	WebElement psswrd;

	@FindBy(id = "user_type")
	WebElement selecttype;

	@FindBy(xpath = "//button[@name='Create']")
	WebElement save;

	@FindBy(xpath = "//div[@class='alert alert-success alert-dismissible']")
	WebElement success;

	@FindBy(xpath = "//a[@class='btn btn-rounded btn-primary']")
	WebElement search;

	@FindBy(id = "un")
	WebElement searchinput;

	@FindBy(id = "ut")
	WebElement searchType;

	@FindBy(xpath = "//button[@name='Search']")
	WebElement clicksearch;

	@FindBy(xpath = "//a[text()='Home']")
	WebElement clickHome;

	// Locator for the first username cell in the search results table
	@FindBy(xpath = "//table[@class='table table-bordered table-hover table-sm']/tbody/tr[1]/td[1]")
	WebElement firstTableUsername;

	

	public AdminPage clickNewButton() {
		waitutil.waitUntilClickable(this.driver, newinfo);
		newinfo.click();
		return this;
	}

	public AdminPage enterUsername(String randomusername) {
		usrnme.sendKeys(randomusername);
		return this;
	}
		
	public AdminPage enterPassword(String randomPasswrd) {
		psswrd.sendKeys(randomPasswrd);
		return this;
	}

	public AdminPage selectUserType(int index) {
		//Select sl = new Select(selecttype);
		//sl.selectByIndex(index);
		pageutil.selectDropdownWithindex(selecttype, index);
		
		return this;
	}

	public AdminPage clickSaveButton() {
		save.click();
		return this;
	}

	public boolean isSuccessAlertDisplayed() {
		return success.isDisplayed();

	}

	public AdminPage clickSearchButton() {
		search.click();
		return this;
	}

	public AdminPage enterSearchUsername(String searchName) {
		searchinput.sendKeys(searchName);
		return this;
	}

	public AdminPage selectSearchUserType(int index) {
		//Select sl = new Select(searchType);
		//sl.selectByIndex(index);
		pageutil.selectDropdownWithindex(searchType, index);
		return this;
	}

	public AdminPage clickSearchSubmitButton() {
		clicksearch.click();
		return this;
	}

	public String getFirstSearchedUsername() {
		return firstTableUsername.getText();
	}

	public HomePage clickHomeLink() {
		clickHome.click();
		return new HomePage(this.driver);
	}
}