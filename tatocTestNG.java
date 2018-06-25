package tatoctesting;

import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class tatoc {
	WebDriver driver;
	public tatoc() {
		System.setProperty("webdriver.chrome.driver","D:\\chromedriver_win32\\chromedriver.exe");
		this.driver=new ChromeDriver();
		driver.get("http://10.0.1.86/tatoc/basic/grid/gate");
	}
	@BeforeTest
public void set_connection() {
	System.setProperty("webdriver.chrome.driver","D:\\chromedriver_win32\\chromedriver.exe"); 
	
}

@Test
public void task_1() {
	Assert.assertEquals(this.driver.findElement(By.linkText("Basic Course")).isDisplayed(), true);
	driver.findElement(By.linkText("Basic Course")).click();
	String expectedurl="http://10.0.1.86/tatoc/basic/grid/gate";
	Assert.assertEquals(expectedurl, driver.getCurrentUrl(),"didn't navigate to correct location");
}
@Test
public void task_2() {
	Assert.assertEquals(this.driver.findElement(By.className("greenbox")).isDisplayed(), true);
	driver.findElement(By.className("greenbox")).click();
	String expectedurl="http://10.0.1.86/tatoc/basic/frame/dungeon";
	Assert.assertEquals(expectedurl, driver.getCurrentUrl(),"didn't navigate to correct webpage");
}
@Test
public void task_3() {
	Assert.assertEquals(this.driver.findElement(By.className("redbox")).isDisplayed(), true);
	driver.findElement(By.className("redbox")).click();
	String expectedurl="http://10.0.1.86/tatoc/error";
	Assert.assertEquals(expectedurl, driver.getCurrentUrl(),"didn't navigate to correct webpage");
}
@Test(dependsOnMethods= {"task_2"})
public void task_4() {
	 driver.switchTo().frame(0);
	 Assert.assertEquals(this.driver.findElement(By.id("answer")).isDisplayed(), true);
	 WebElement box1=driver.findElement(By.id("answer"));
	 String box1_color=box1.getAttribute("class");
	 while(true) {
	 	driver.findElement(By.cssSelector("a")).click();
	 	driver.switchTo().frame("child");
	 	WebElement box2=driver.findElement(By.id("answer"));
	 	String box2_color=box2.getAttribute("class");
	 	driver.switchTo().parentFrame();
	 	if(box1_color.equals(box2_color)) {
	 		driver.findElements(By.cssSelector("a")).get(1).click();
	 	break;
	 	}
	 }
	 String expectedUrl = "http://10.0.1.86/tatoc/basic/drag"; //url of next page
     Assert.assertEquals(expectedUrl, driver.getCurrentUrl(), "Didn't navigate to correct webpage");
}
@Test(dependsOnMethods= {"task_4"})
public void task_5() {
	Assert.assertEquals(this.driver.findElement(By.className("ui-draggable")).isDisplayed(), true);
	WebElement dragbox=driver.findElement(By.className("ui-draggable"));
	Actions action=new Actions(driver);
	action.dragAndDropBy(dragbox, 20,-73).build().perform();
	driver.findElement(By.linkText("Proceed")).click();
	String expectedUrl = "http://10.0.1.86/tatoc/basic/windows"; //url of next page
    Assert.assertEquals(expectedUrl, driver.getCurrentUrl(), "Didn't navigate to correct webpage");
}
@Test(dependsOnMethods= {"task_4"})
public void task_8() {
	WebElement dragbox=driver.findElement(By.className("ui-draggable"));
	Actions action=new Actions(driver);
	action.dragAndDropBy(dragbox, 5,73).build().perform();
	driver.findElement(By.linkText("Proceed")).click();
	
}
@Test(dependsOnMethods= {"task_5"})
public void task_6() {
	Assert.assertEquals(this.driver.findElement(By.linkText("Launch Popup Window")).isDisplayed(), true);
	driver.findElement(By.linkText("Launch Popup Window")).click();
	String mainwindow=driver.getWindowHandle();
	Set<String> openedWindow = driver.getWindowHandles();
	Iterator<String> itr = openedWindow.iterator();
	while (itr.hasNext()) {
		String childWindow = itr.next();
		if (!mainwindow.equalsIgnoreCase(childWindow)) {
			driver.switchTo().window(childWindow);
			driver.findElement(By.id("name")).sendKeys("Hiiii");
			driver.findElement(By.id("submit")).click();

		}
		
	}
	driver.switchTo().window(mainwindow);
	driver.findElement(By.linkText("Proceed")).click();
	String expectedUrl = "http://10.0.1.86/tatoc/basic/cookie"; //url of next page
    Assert.assertEquals(expectedUrl, driver.getCurrentUrl(), "Didn't navigate to correct webpage");
}
@Test(dependsOnMethods= {"task_6"})
public void task_7() {
	Assert.assertEquals(this.driver.findElement(By.linkText("Generate Token")).isDisplayed(), true);
	driver.findElement(By.linkText("Generate Token")).click();
	 String cook=driver.findElement(By.id("token")).getText();
	 String[] splited = cook.split("\\s+");
	Cookie cookie=new Cookie("Token",splited[1] );
	driver.manage().addCookie(cookie);

	driver.findElement(By.linkText("Proceed")).click();
	String expectedurl="http://10.0.1.86/tatoc/end";
	Assert.assertEquals(expectedurl, driver.getCurrentUrl(),"Didn't navigate to correct webpage");
	}
}

