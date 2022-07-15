package pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Header {
	@FindBy (xpath="(//a[text()='Best Sellers'])[1]")
	private WebElement bestSellers;
	
	@FindBy (xpath="(//a[text()='Mobiles'])[1]")
	private WebElement mobiles;
	
	@FindBy (xpath="(//a[text()='Customer Service'])[1]")
	private WebElement customerService;
	
	@FindBy (xpath="//a[@data-csa-c-slot-id='nav_cs_3']")
	private WebElement todaysDeal;
	
	@FindBy (xpath="//a[text()='Fashion']")
	private WebElement fashion;
	
	@FindBy (xpath="//a[text()=' Electronics ']")
	private WebElement electronic;
	
	@FindBy (xpath="//a[@id='nav-link-accountList']")
	private WebElement signOut1;
	
	@FindBy (xpath="//a[@id='nav-item-signout']")
	private WebElement signOut2;

	private WebDriver driver; 
	private Actions act;
	
	public Header(WebDriver driver)
	{
		PageFactory.initElements(driver,this);
		this.driver=driver;
		act=new Actions(driver);
	}
	public void bestSeller() 
	{
		bestSellers.click();
	}
	public void mobiles()
	{
		mobiles.click();
	}
	public void customerService()
	{
		customerService.click();
	}
	public void todaysDeal()
	{
		todaysDeal.click();
	}
	public void fashion()
	{
		fashion.click();
	}
	public void electronic()
	{
		electronic.click();
	}
	public void signOut() {
		//signOut1.click();
		//signOut2.click();
		//Actions act=new Actions(driver);
		act.moveToElement(signOut1).moveToElement(signOut2).click().build().perform();
	}
}
