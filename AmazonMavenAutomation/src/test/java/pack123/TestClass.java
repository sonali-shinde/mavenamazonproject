package pack123;

import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class TestClass  {
		
		@BeforeTest
		public void beforeTest() 
		{
			System.out.println("Before test2");
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
		@Test (priority =1)
		public void testA()
		{
			System.out.println("testA");
		}
		@Test (priority =-1)
		public void testB()
		{
			System.out.println("testB");
		}
		@Test (priority=0,timeOut=3000)
		public void testC() throws InterruptedException
		{
			System.out.println("testC");
			Thread.sleep(5000);
			System.out.println("Hello");
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
			System.out.println("after test2");
		}
		
}

