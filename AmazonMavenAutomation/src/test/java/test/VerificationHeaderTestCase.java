package test;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import pom.AddressToPlaceOrder;
import pom.Header;
import pom.SearchForMobile;
import pom.SearchForWatches;
import pom.SearchResult;
import pom.Sign_in_Page;

public class VerificationHeaderTestCase {
	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver","D:\\selenium\\chromedriver_win32\\chromedriver.exe");
		WebDriver driver=new ChromeDriver();
		
		//Test case 1-Watch search tab
		driver.get("https://www.amazon.in/");
		driver.manage().window().maximize();
		
		Sign_in_Page signinPage=new Sign_in_Page(driver);
		signinPage.clickSignIn();
		signinPage.sendEmail();
		signinPage.clickContinue();
		signinPage.sendPassword();
		signinPage.clickSubmit();
		
		SearchResult searchResult=new SearchResult(driver);
		searchResult.sendSearchbox();
		
		SearchForWatches searchWatch=new SearchForWatches(driver);
		searchWatch.clickSearchMenWatches();
		searchWatch.clickTimexWatch();
		searchWatch.clickToBuy();
		
		AddressToPlaceOrder addressToPlaceOrder=new AddressToPlaceOrder(driver);
		addressToPlaceOrder.addressToOrder();
		
		String url =driver.getCurrentUrl();
		String title =driver.getTitle();
		System.out.println(url);
		System.out.println(title);
		//https://www.amazon.in/s?k=watches+for+men&crid=2XR0M3F9SNB5C&sprefix=watches%2Caps%2C229&ref=nb_sb_ss_ts-doa-p_1_7
		if(url.equals("https://www.amazon.in/gp/buy/addressselect/handlers/display.html?hasWorkingJavascript=1") && title.equals("Select a delivery address"))
		{
			System.out.println("Pass");
		}
		else
		{
			System.out.println("Fail");
		}
		
		driver.navigate().to("https://www.amazon.in/");
		Header header=new Header(driver);
		header.signOut();
		
		//Task2 -Mobile tab
		driver.get("https://www.amazon.in/");
		driver.manage().window().maximize();
		
		signinPage=new Sign_in_Page(driver);
		signinPage.clickSignIn();
		signinPage.sendEmail();
		signinPage.clickContinue();
		signinPage.sendPassword();
		signinPage.clickSubmit();
		
		header=new Header(driver);
		header.mobiles();
		
		SearchForMobile searchForMobile=new SearchForMobile(driver);
		searchForMobile.mobScrollDown();
		
		url =driver.getCurrentUrl();
		title =driver.getTitle();
		System.out.println(url);
		System.out.println(title);
		if(url.equals("https://www.amazon.in/mobile-phones/b/?ie=UTF8&node=1389401031&ref_=nav_cs_mobiles") && title.equals("Mobile Phones: Buy New Mobiles Online at Best Prices in India | Buy Cell Phones Online - Amazon.in"))
		{
			System.out.println("Pass");
		}
		else
		{
			System.out.println("Fail");
		}
		
		header.signOut();
		
		//Task 3-Fasion tab
		driver.get("https://www.amazon.in/");
		driver.manage().window().maximize();
		
		signinPage=new Sign_in_Page(driver);
		signinPage.clickSignIn();
		signinPage.sendEmail();
		signinPage.clickContinue();
		signinPage.sendPassword();
		signinPage.clickSubmit();
		
		header=new Header(driver);
		header.fashion();
		
		url =driver.getCurrentUrl();
		title =driver.getTitle();
		System.out.println(url);
		System.out.println(title);
		if(url.equals("https://www.amazon.in/gp/browse.html?node=6648217031&ref_=nav_cs_fashion") && title.equals("Amazon Fashion: Clothing, Footwear and Accessories online for Men, Women and Kids"))
		{
			System.out.println("Pass");
		}
		else
		{
			System.out.println("Fail");
		}
		header.signOut();
		
		driver.quit();
	}
}
