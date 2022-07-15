package test;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import pom.AddressToPlaceOrder;
import pom.Header;
import pom.SearchForMobile;
import pom.SearchForWatches;
import pom.SearchResult;
import pom.Sign_in_Page;

public class Verification {
		public static void main(String[] args) {
			System.setProperty("webdriver.chrome.driver","D:\\selenium\\chromedriver_win32\\chromedriver.exe");
			WebDriver driver=new ChromeDriver();
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
			
			//driver.getWindowHandle();
			driver.navigate().to("https://www.amazon.in/");
			
			Header header=new Header(driver);
			header.mobiles();
			
			SearchForMobile searchForMobile=new SearchForMobile(driver);
			searchForMobile.mobScrollDown();
			
			header.signOut();
			header.fashion();
		
		}

}
