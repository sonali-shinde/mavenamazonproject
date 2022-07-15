package pack123;

import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class TestClass123 {
		
	@BeforeSuite
	public void beforeSuite()
	{
		System.out.println("before suite1");
	}
	@BeforeTest
	public void beforeTest()
	{
		System.out.println("Before test1");
	}
	@BeforeClass
	public void beforeClass()
	{
		System.out.println("Before class");	
	}
	@BeforeMethod
	public void beforeMethod()
	{
		System.out.println("Before Method");	
	}
	@Test (priority =1,enabled=false)
	public void test1()
	{
		System.out.println("test1");
	}
	@Test (priority =2)
	public void test2()
	{
		//String url="https://www.amazon.in/";
		//Assert.assertEquals(url, "https://www.amazon.i/","Url Verification failed");
		//SoftAssert soft=new SoftAssert();
		//soft.assertEquals(url, "https://www.amazon.i/", "Url Verification failed");
		
		System.out.println("test2");
		//System.out.println("Hello");
		//Assert.fail();
		//soft.assertAll();
	}
	@Test (priority =-1)
	public void test3()
	{
		System.out.println("test3");
	}
	@Test (priority =-2,invocationCount=2)
	public void test4()
	{
		System.out.println("test4");
	}
	@AfterMethod
	public void afterMethod()
	{
		System.out.println("afterMethod");
	}
	@AfterClass
	public void afterClass()
	{
		System.out.println("afterClass");
	}
	@AfterTest
	public void afterTest()
	{
		System.out.println("after test1");
	}
	@AfterSuite
	public void afterSuite()
	{
		System.out.println("after suite1");
	}
}
