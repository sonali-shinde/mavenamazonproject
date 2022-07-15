package pom;



import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SearchForMobile {
	@FindBy (xpath="(//span[text()='Mobiles & Accessories'])[2]")
	private WebElement mobScroll;
	
	private WebDriver driver;
	private WebDriverWait wait;
	public SearchForMobile(WebDriver driver)
	{
		PageFactory.initElements(driver,this);
		this.driver=driver;
	}
	public void mobScrollDown()
	{
		wait= new WebDriverWait(driver,30);
		wait.until(ExpectedConditions.visibilityOf(mobScroll));
		JavascriptExecutor js=(JavascriptExecutor)driver;
		js.executeScript("arguments[0].scrollIntoView(true);",mobScroll);
	}
	
	
}


