package pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


public class Sign_in_Page {
	@FindBy (xpath="//span[@id='nav-link-accountList-nav-line-1']")
	private WebElement sign_in;
	
	@FindBy (xpath="//input[@name='email']")
	private WebElement emailid;
	
	@FindBy (xpath="//input[@id='continue']")
	private WebElement continue_Btn;
	
	@FindBy (xpath="//input[@name='password']")
	private WebElement password;
	
	@FindBy (xpath="//input[@id='signInSubmit']")
	private WebElement signinSubmit;
	
	private WebDriver driver;
	private WebDriverWait wait;
	
	public Sign_in_Page(WebDriver driver)
	{
		PageFactory.initElements(driver,this);
		this.driver=driver;
	}
	public void clickSignIn()
	{
		wait= new WebDriverWait(driver,30);
		wait.until(ExpectedConditions.visibilityOf(sign_in));
		sign_in.click();
	}
	public void sendEmail() 
	{
		emailid.sendKeys("sonalikshinde10@gmail.com");
	}
	public void clickContinue()
	{
		continue_Btn.click();
	}
	public void sendPassword()
	{
		password.sendKeys("Sonali90");
	}
	public void clickSubmit()
	{
		signinSubmit.click();
	}
	
}
