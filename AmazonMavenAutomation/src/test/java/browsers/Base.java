package browsers;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Base {
	
	public static WebDriver OpenChromeBrowser()
	{
		System.setProperty("webdriver.chrome.driver","D:\\selenium\\chromedriver_win32 (2)\\chromedriver.exe");
		WebDriver driver=new ChromeDriver();
		return driver;
	}
	public static WebDriver OpenFirefoxBrowser()
	{
		System.setProperty("webdriver.gecko.driver","D:\\selenium\\geckodriver-v0.31.0-win32\\geckodriver.exe");
		WebDriver driver=new FirefoxDriver();
		return driver;
	}
	public static WebDriver OpenEdgeBrowser()
	{
		System.setProperty("webdriver.edge.driver","D:\\selenium\\edgedriver_win32 (2)\\msedgedriver.exe");
		WebDriver driver=new EdgeDriver();
		return driver;
	}
}
