package utilities;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

public class Pageutility {

	public void selectDropdownWithindex(WebElement element,int value) {
		Select dropdown = new Select(element);
		dropdown.selectByIndex(value);
		
	}
	public void scrollUntilPageEnd(WebDriver driver) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollTo(0, document.body.scrollHeight)", "");
	}
	
	public void selectDropdownWithValue(WebElement element,String value) {
		Select dropdown = new Select(element);
		dropdown.selectByValue(value);
	}
	
	public void selectDropdownWithVisibleText(WebElement element,String value) {
		Select dropdown = new Select(element);
		dropdown.selectByVisibleText(value);
		
	}
	
	public void dragAnddrop(WebDriver driver,WebElement source,WebElement target) {
		Actions act = new Actions(driver);
		act.dragAndDrop(source, target);
	}
	
}
