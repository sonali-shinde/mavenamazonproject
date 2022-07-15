package test;

import java.util.concurrent.TimeUnit;

	import org.openqa.selenium.WebDriver;
	import org.testng.Assert;
	import org.testng.annotations.AfterClass;
	import org.testng.annotations.AfterMethod;
	import org.testng.annotations.AfterTest;
	import org.testng.annotations.BeforeClass;
	import org.testng.annotations.BeforeMethod;
	import org.testng.annotations.BeforeTest;
	import org.testng.annotations.Parameters;
	import org.testng.annotations.Test;
	import org.testng.asserts.SoftAssert;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

import browsers.Base;
	import pom.AddressToPlaceOrder;
	import pom.Header;
	import pom.SearchForMobile;
	import pom.SearchForWatches;
	import pom.SearchResult;
	import pom.Sign_in_Page;

	public class ExtendReportclass  extends Base 
	{
		
		WebDriver driver;
		Header header;
		Sign_in_Page signinPage;
		SearchResult searchResult;
		SearchForWatches searchWatch;
		AddressToPlaceOrder addressToPlaceOrder;
		SearchForMobile searchForMobile;
		SoftAssert soft;
		static ExtentTest test;
		static ExtentHtmlReporter reporter;
		
		@Parameters("browserName")
		
		@BeforeTest
		public void launchBrowser(String browser)
		{
			reporter = new ExtentHtmlReporter("test-output/ExtendReport/Extent.html");
			ExtentReports extend = new ExtentReports();
			extend.attachReporter(reporter);
			System.out.println("Before test");
			if(browser.equals("Chrome")) //Chrome name match to regression.xml <test name="Chrome">
			{
				driver = OpenChromeBrowser();
			}
			if(browser.equals("Firefox"))
			{
				driver = OpenFirefoxBrowser();
			}
			if(browser.equals("Edge"))
			{
				driver= OpenEdgeBrowser();
			}
			driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
			driver.manage().window().maximize(); //before this line run if loop.
		}
		
		@BeforeClass
		public void createPOMOjects()
		{
		    signinPage=new Sign_in_Page(driver);
			header=new Header(driver);
			searchResult=new SearchResult(driver);
			searchWatch=new SearchForWatches(driver);
			addressToPlaceOrder=new AddressToPlaceOrder(driver);
			searchForMobile=new SearchForMobile(driver);
			soft=new SoftAssert();

		}
		@BeforeMethod
		public void signinToApplication()
		{
			System.out.println("Before Method");	
			driver.get("https://www.amazon.in/");
			driver.manage().window().maximize();
			
			signinPage.clickSignIn();
			signinPage.sendEmail();
			signinPage.clickContinue();
			signinPage.sendPassword();
			signinPage.clickSubmit();
			
		}
		@Test (priority=0)
		public void toVerifyWatch()
		{
			System.out.println("testA");
			searchResult.sendSearchbox();
			
			searchWatch.clickSearchMenWatches();
			searchWatch.clickTimexWatch();
			searchWatch.clickToBuy();
			
			addressToPlaceOrder.addressToOrder();
			
			String url =driver.getCurrentUrl();
			String title =driver.getTitle();
			System.out.println(url);
			System.out.println(title);
			
			soft.assertEquals(url,"https://www.amazon.in/gp/buy/addressselect/handlers/display.html?hasWorkingJavascript=1");
			soft.assertEquals(title,"Select a delivery address");
			//soft.assertEquals(title,"Select a delivery address");
			/*if(url.equals("https://www.amazon.in/gp/buy/addressselect/handlers/display.html?hasWorkingJavascript=1") && title.equals("Select a delivery address"))
			{
				System.out.println("Pass");
			}
			else
			{
				System.out.println("Fail");
			}*/
			
			driver.navigate().to("https://www.amazon.in/");
			soft.assertAll();

		}
		@Test (priority=1)
		public void toVerifyMobiles()
		{
			System.out.println("testB");
			header.mobiles();
			
			searchForMobile.mobScrollDown();
			
			String url =driver.getCurrentUrl();
			String title =driver.getTitle();
			System.out.println(url);
			System.out.println(title);
			
			Assert.assertEquals(url,"https://www.amazon.in/mobile-phones/b/?ie=UTF8&node=1389401031&ref_=nav_cs_mobiles");
			Assert.assertEquals(title,"Mobile Phones: Buy New Mobiles Online at Best Prices in India | Buy Cell Phones Online - Amazon.in");
			
			//SoftAssert soft=new SoftAssert();
			//soft.assertEquals(url,"https://www.amazon.in/mobile-phones/b/?ie=UTF8&node=1389401031&ref_=nav_cs_mobiles");
			//soft.assertEquals(title,"Mobile Phones: Buy New Mobiles Online at Best Prices in India | Buy Cell Phones Online - Amazon.in");
			/*if(url.equals("https://www.amazon.in/mobile-phones/b/?ie=UTF8&node=1389401031&ref_=nav_cs_mobiles") && title.equals("Mobile Phones: Buy New Mobiles Online at Best Prices in India | Buy Cell Phones Online - Amazon.in"))
			{
				System.out.println("Pass");
			}
			else
			{
				System.out.println("Fail");
			}*/
			//soft.assertAll();
		}
		@Test(priority=2)
		public void toVerifyFashionButton()
		{
			System.out.println("testC");
			header.fashion();
			
			String url =driver.getCurrentUrl();
			String title =driver.getTitle();
			System.out.println(url);
			System.out.println(title);
			
			//SoftAssert soft=new SoftAssert();
			soft.assertEquals(url,"https://www.amazon.in/gp/browse.html?node=6648217031&ref_=nav_cs_fashion");
			soft.assertEquals(title,"Amazon Fashion: Clothing, Footwear and Accessories online for Men, Women and Kids");
			/*if(url.equals("https://www.amazon.in/gp/browse.html?node=6648217031&ref_=nav_cs_fashion") && title.equals("Amazon Fashion: Clothing, Footwear and Accessories online for Men, Women and Kids"))
			{
				System.out.println("Pass");
			}
			else
			{
				System.out.println("Fail");
			}*/
			soft.assertAll();
		}
		@AfterMethod
		public void signOutApplication()
		{
			System.out.println("afterMethod");
			header.signOut();
		}
		
		@AfterClass
		public void clearObject()  
		{
			signinPage=null;
			header=null;
			searchResult=null;
			searchWatch=null;
			addressToPlaceOrder=null;
			searchForMobile=null;
		}
		@AfterTest
		public void closedBrowser()
		{
			System.out.println("after test");
			driver.quit();
			driver=null;
			System.gc();
		}
		
		
	}

