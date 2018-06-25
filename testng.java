package tatoctesting;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class testng {
WebDriver driver;
public testng() {
	System.setProperty("webdriver.chrome.driver","D:\\chromedriver_win32\\chromedriver.exe");
	this.driver=new ChromeDriver();
	driver.get("https://hris.qainfotech.com/login.php");
}
@BeforeTest
public void set_connection() {
	System.setProperty("webdriver.chrome.driver","D:\\chromedriver_win32\\chromedriver.exe"); 
	driver.findElement(By.xpath("//span[contains(text(),'Login Panel')]")).click();
}
@Test
public void Login_with_incorrect_password() {
	Assert.assertEquals(this.driver.findElement(By.id("txtUserName")).isDisplayed(),true);
	Assert.assertEquals(this.driver.findElement(By.id("txtPassword")).isDisplayed(),true);
	 
	//Assert.assertEquals(this.driver.findElement(By.id("txtUserName")).isDisplayed(),true);
	driver.findElement(By.id("txtUserName")).sendKeys("neetu1");
	
	driver.findElement(By.id("txtPassword")).sendKeys("neetu1");
	driver.findElement(By.id("txtPassword")).submit();
	String expectedurl="https://hris.qainfotech.com/login.php";
	Assert.assertEquals(expectedurl, driver.getCurrentUrl());
//	Assert.assertEquals(this.driver.findElement(By.className("btn pull-left")).isDisplayed(),true);
	//driver.findElement(By.className("btn pull-left")).click();
}
@Test
public void Login_with_incorrect_username() {
	Assert.assertEquals(this.driver.findElement(By.id("txtUserName")).isDisplayed(),true);
	Assert.assertEquals(this.driver.findElement(By.id("txtPassword")).isDisplayed(),true);
	 
	//Assert.assertEquals(this.driver.findElement(By.id("txtUserName")).isDisplayed(),true);
	driver.findElement(By.id("txtUserName")).sendKeys("neetu11");
	
	driver.findElement(By.id("txtPassword")).sendKeys("NeetuVip@30");
	driver.findElement(By.id("txtPassword")).submit();
	String expectedurl="https://hris.qainfotech.com/login.php";
	Assert.assertEquals(expectedurl, driver.getCurrentUrl());
//	Assert.assertEquals(this.driver.findElement(By.className("btn pull-left")).isDisplayed(),true);
	//driver.findElement(By.className("btn pull-left")).click();
}
}
