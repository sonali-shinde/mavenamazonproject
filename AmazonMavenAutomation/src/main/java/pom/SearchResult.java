package pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SearchResult {
		
	@FindBy (xpath="//input[@id='twotabsearchtextbox']")
	private WebElement searchBox;
	
	public SearchResult(WebDriver driver)
	{
		PageFactory.initElements(driver,this);
	}
	public void sendSearchbox()
	{
		searchBox.sendKeys("Watches");
	}
	
}
