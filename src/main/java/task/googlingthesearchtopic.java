package task;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class googlingthesearchtopic extends PageBase {
	
	int numberofgumtreetitles=0;
    String gumtreetitle;

	public googlingthesearchtopic(WebDriver driver) {
		super(driver);
	}
	
	@FindBy(name="q")
	WebElement googlesearchtxtbox;
		
	public void typingsearchtopic() throws InterruptedException
	{
		sendtxtbox(googlesearchtxtbox,"Cars in London");
		Thread.sleep(2000);
	}
}
