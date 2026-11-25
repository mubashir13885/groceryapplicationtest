package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
	public WebDriver driver;
	public LoginPage(WebDriver driver) {
		this.driver =driver;
		PageFactory.initElements(driver, this);
	}
	@FindBy(xpath="//input[@class ='form-control' and @type = 'text']")WebElement usernamefield;
	@FindBy(xpath = "//input[@class ='form-control' and @type = 'password']")WebElement passwordfield;
	@FindBy(xpath = "//button[text()='Sign In']")WebElement loginBtn;
	
	
	public LoginPage enterUsername(String usernameValue) { 
		//WebElement username = this.driver.findElement(By.xpath("//input[@class ='form-control' and @type = 'text']"));
		usernamefield.sendKeys(usernameValue);
		return this;
	}
	
	public LoginPage enterPassword(String PasswordValue) {
		//WebElement password = this.driver.findElement(By.xpath("//input[@class ='form-control' and @type = 'password']"));
		passwordfield.sendKeys(PasswordValue);
		return this;

	}
	
	public HomePage performLogin() {
		//WebElement btn = this.driver.findElement(By.xpath("//button[text()='Sign In']"));
		loginBtn.click();
		return new HomePage(this.driver);
	}
}
