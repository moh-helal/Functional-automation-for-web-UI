package testdoc;

import java.time.Duration;
//import java.time.Duration;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.github.bonigarcia.wdm.WebDriverManager;
//import org.testng.annotations.Optional;
//import org.testng.annotations.Parameters;



public class TestBase extends AbstractTestNGCucumberTests{

	public static WebDriver driver;

	@BeforeSuite
	public void startdriver() 
	{	
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		
		driver.navigate().to("https://www.google.com/");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(60));
	}
	@AfterSuite
	public void stopdriver() throws InterruptedException
	{
		Thread.sleep(4000);
		driver.quit();
	}
}