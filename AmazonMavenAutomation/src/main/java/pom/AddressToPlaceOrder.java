package pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class AddressToPlaceOrder {
	
	@FindBy (xpath="//input[@id='address-ui-widgets-enterAddressFullName']")
	private WebElement fullName;
	
	@FindBy (xpath="//input[@id='address-ui-widgets-enterAddressPhoneNumber']")
	private WebElement mobile;
	
	@FindBy (xpath="//input[@id='address-ui-widgets-enterAddressPostalCode']")
	private WebElement pinCode;
	
	@FindBy (xpath="//input[@id='address-ui-widgets-enterAddressLine1']")
	private WebElement flatNo;
	
	@FindBy (xpath="//input[@id='address-ui-widgets-enterAddressLine2']")
	private WebElement area;
	
	@FindBy (xpath="//input[@id='address-ui-widgets-landmark']")
	private WebElement landMark;
	
	@FindBy (xpath="//input[@id='address-ui-widgets-enterAddressCity']")
	private WebElement city;
	
	@FindBy (xpath="//div[@class='a-column a-span6 a-span-last']//span//select")
	private WebElement state;
	
	@FindBy (xpath="//input[@type='submit']")
	private WebElement useButton;
	
	public AddressToPlaceOrder(WebDriver driver)
	{
		PageFactory.initElements(driver,this);
	}
	
	public void addressToOrder()
	{
		fullName.sendKeys("Sonali Shinde");
		mobile.sendKeys("7720092264");
		pinCode.sendKeys("422007");
		flatNo.sendKeys("1");
		area.sendKeys("Mahatma nagar");
		landMark.sendKeys("Satpur");
		city.sendKeys("NASHIK");
	
		Select s=new Select(state);
		s.selectByValue("MAHARASHTRA");
		
		useButton.click();
	}

}
