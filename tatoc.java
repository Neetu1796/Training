package newpackage;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

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


        }
}

