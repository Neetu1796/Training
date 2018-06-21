package newpackage;

import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class tatoc {
public static void main(String aa[]) {
	System.setProperty("webdriver.chrome.driver","D:\\chromedriver_win32\\chromedriver.exe"); 
WebDriver driver =new ChromeDriver();
driver.get("http://10.0.1.86/tatoc");
//first page
driver.findElement(By.linkText("Basic Course")).click();
//first task
driver.findElement(By.className("greenbox")).click();
//second task
  driver.switchTo().frame(0);
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
//third task
	WebElement dragbox=driver.findElement(By.className("ui-draggable"));
	Actions action=new Actions(driver);
	action.dragAndDropBy(dragbox, 20,-73).build().perform();
	driver.findElement(By.linkText("Proceed")).click();
	
	//fourth task
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
driver.findElement(By.linkText("Generate Token")).click();
 String cook=driver.findElement(By.id("token")).getText();
 String[] splited = cook.split("\\s+");
Cookie cookie=new Cookie("Token",splited[1] );
driver.manage().addCookie(cookie);

driver.findElement(By.linkText("Proceed")).click();
}
}

