package test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import tatoctesting.Hris;
import tatoctesting.Timesheet;


public class hrisTest {
WebDriver driver;

Timesheet timesheet;
//Hris hris=new Hris(driver);
public hrisTest() {

	System.setProperty("webdriver.chrome.driver","D:\\chromedriver_win32\\chromedriver.exe");
	this.driver=new ChromeDriver();
	driver.get("https://hris.qainfotech.com/login.php");
	
}
@BeforeTest
public void set_connection() {
	System.setProperty("webdriver.chrome.driver","D:\\chromedriver_win32\\chromedriver.exe"); 
	driver.findElement(By.xpath("//span[contains(text(),'Login Panel')]")).click();
	System.out.println("connection set");
	
}

@Test
public void login_with_incorrect_password()throws NullPointerException  {
	
	Hris hris=new Hris(driver);
	Assert.assertEquals(hris.LoginByInvalidCredentials("neetu", "password"),"Invalid Login");
	
}

@Test
public void login_with_correct_password() throws NullPointerException {
	Hris hris=new Hris(driver);
	timesheet=hris.LoginByCorrectCredentials("neetu1","NeetuVip@30");
    Assert.assertFalse(timesheet.isloginpage());
    
}
@Test
public void LoginWithBlankPassword()
{ String str="border: 1px solid red;";
Hris hris=new Hris(driver);
    Assert.assertEquals(hris.LoginByBlankPassword("neetu1",""),str);
}
}
