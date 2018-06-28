package test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import tatoctesting.Bing;
public class BingTest {
	WebDriver driver;
	Bing bing;
public BingTest() {
	System.setProperty("webdriver.chrome.driver","D:\\chromedriver_win32\\chromedriver.exe");
	this.driver=new ChromeDriver();
	Bing bing=new Bing(driver);
	driver.get("https://www.bing.com/translator");
}
@Test
public void set_connection() {
	System.setProperty("webdriver.chrome.driver","D:\\chromedriver_win32\\chromedriver.exe"); 
	driver.manage().window().maximize();
	System.out.println("connected");
	
}
@Test
public void click_translator_test()throws NullPointerException {
	Bing bing=new Bing(driver);
	bing.click_translator();
	String expectedurl="https://www.bing.com/translator";
	Assert.assertEquals(driver.getCurrentUrl(),expectedurl);
}
@Test
public void click_conversion_test()throws NullPointerException{
Bing bing=new Bing(driver);
	bing.click_conversion();
	String expectedurl="https://translator.microsoft.com/";
	Assert.assertEquals(driver.getCurrentUrl(),expectedurl);
}
@Test
public void search()throws NullPointerException {
	Bing bing=new Bing(driver);
	bing.search_box();
	
}
}
