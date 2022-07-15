package pom;


import java.util.ArrayList;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SearchForWatches {
	@FindBy (xpath="(//div[@aria-label='watches for men'])[1]")
	private WebElement searchWatches;
	
	//span[@id='DEAL_OF_THE_DAY_B07DN93B9R']
	
	@FindBy (xpath="(//div[@class='s-image-padding']//div//img)[8]")
	private WebElement timexWatch;
	
	@FindBy (xpath="//input[@id='buy-now-button']")
	private WebElement buyNow;
	
	private WebDriverWait wait;
	private WebDriver driver;
	
	public SearchForWatches(WebDriver driver)
	{
		PageFactory.initElements(driver,this);
		this.driver=driver;
	}
	public void clickSearchMenWatches()
	{
		wait= new WebDriverWait(driver,(30));
		wait.until(ExpectedConditions.visibilityOf(searchWatches));
		searchWatches.click();
	}
	public void clickTimexWatch()
	{
		wait= new WebDriverWait(driver,(30));
		wait.until(ExpectedConditions.visibilityOf(timexWatch));
		timexWatch.click();
	}
	public void clickToBuy()
	{
		ArrayList<String> addr=new ArrayList<String>(driver.getWindowHandles());
		for(int i=0;i<addr.size();i++)
		{
			System.out.println(addr.get(i));
		}
		//to switch focus on one browser to another browser
		driver.switchTo().window(addr.get(0));//first we get address of main page browser
		System.out.println(driver.getCurrentUrl());
		
		driver.switchTo().window(addr.get(1));//first we get address of main page browser
		System.out.println(driver.getCurrentUrl());
		
		wait =new WebDriverWait(driver,(30));
		wait.until(ExpectedConditions.visibilityOf(buyNow));
		buyNow.click();
	}
}
