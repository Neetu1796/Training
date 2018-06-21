package newpackage;

import java.util.ArrayList;

import org.openqa.selenium.By;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class tatoc2 {
WebElement driver1;
	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
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
	driver.findElement(By.cssSelector("body > div > div.page > a")).click();
	driver.findElement(By.cssSelector("body > div > div.page > a:nth-child(4)")).click();
	ArrayList<String> tabs2 = new ArrayList<String> (driver.getWindowHandles());
	driver.switchTo().window(tabs2.get(1));
	driver.findElement(By.cssSelector("#name")).sendKeys("hello world");
	driver.findElement(By.cssSelector("#submit")).click();
    driver.switchTo().window(tabs2.get(0));
    //fifth task
    driver.findElement(By.cssSelector("body > div > div.page > a:nth-child(6)")).click();
    driver.findElement(By.cssSelector("body > div > div.page > a:nth-child(8)")).click();
    String token = driver.findElement(By.cssSelector("#token")).getText();
    String[] splited = token.split("\\s+");
    
    Cookie token1 = new Cookie("Token", splited[1]);
    driver.manage().addCookie(token1);
    driver.findElement(By.cssSelector("body > div > div.page > a:nth-child(10)")).click();
    Thread.sleep(2000);
	driver.close();

	}

}
