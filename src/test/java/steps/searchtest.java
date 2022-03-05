package steps;

import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import testdoc.TestBase;
import org.testng.Assert;


import task.googlingthesearchtopic;

public class searchtest extends TestBase{
		
	googlingthesearchtopic googling;
	int numberofGumtreetitles=0;
     String gumtreetitle;
	 String listinglocater = "h3.LC20lb.MBeuO.DKV0Md";
	
	@Given("Google searchpage opened & user typing his search topic 'cars in london' & pressing Enter Key.")
	public void openingGoogletypingsearchtopic() throws InterruptedException 
	{
		googling = new googlingthesearchtopic(driver);
		System.out.println("\n Page title :  "+ driver.getTitle());
		System.out.println("\n Current Page URL :  "+ driver.getCurrentUrl());
		Thread.sleep(2000);
		googling.typingsearchtopic();			    
	}
	
	@When("Search results appear and counting the number of Gumtree links starts.")
	public void countingGumtreeLinks() throws InterruptedException 
	{	
		List<WebElement> listedelements = driver.findElements(By.cssSelector(listinglocater));
		System.out.println("\n Number of all search results appeared = "+ listedelements.size());
		for(WebElement e:listedelements)
		{
			Thread.sleep(2000);
			gumtreetitle= e.getText();

			if(gumtreetitle.contains("Gumtree"))
			{
				++numberofGumtreetitles;
				System.out.println("\n Title of the found Gumtree links:  " +gumtreetitle);
			}
		}
		System.out.println (" \n Total number of Gumtree links appeared =  "+numberofGumtreetitles);
	}
	
	@Then("Navigating through Gumtree links.")
	public void navigatingGumtreeLinks() throws InterruptedException 
	{	
		List<WebElement> listedelements = driver.findElements(By.cssSelector(listinglocater));
		for(WebElement e:listedelements)
		{
			Thread.sleep(2000);
			gumtreetitle= e.getText();

			if(gumtreetitle.contains("Gumtree"))
			{
				e.click();
				Thread.sleep(2000);
				System.out.println(" \n The navigated page title :  "+driver.getTitle());
				System.out.println(" \n The navigated page URL :  "+driver.getCurrentUrl()+ " \n ");
				Thread.sleep(2000);
				driver.navigate().back();
			}
		}
	}
	
}
