package task;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class PageBase {
	
	public static  WebDriver driver;
	public static Select dropdown;
	public static  Actions actions;
	public static JavascriptExecutor scrolldown;
	public PageBase(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
		actions = new Actions(driver);
		scrolldown = (JavascriptExecutor) driver;
	}
	
	protected static void clickbtn(WebElement btn)
	{
		btn.click();
	}
	
	protected static void sendtxtbox(WebElement enter , String value)
	{
		enter.click();
		enter.clear();
		enter.sendKeys(value+Keys.ENTER);
	}
	
	protected static void selectdrop(WebElement selecttype, String value)
	{
		dropdown = new Select(selecttype);
		dropdown.selectByValue(value);
	}
	
	protected static void hoveroption(WebElement hoverelement)
	{		
		actions.moveToElement(hoverelement).perform();
	}
	
	protected static void scrolloption(String scrollvalue)
	{
		scrolldown.executeScript(scrollvalue, "");
	}
	

}
