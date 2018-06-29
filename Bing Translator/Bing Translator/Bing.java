package tatoctesting;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

public class Bing {
	WebDriver driver;
	JavascriptExecutor js;
String text1="class";
	public Bing(WebDriver driver) {
		this.driver = driver;
		JavascriptExecutor js = (JavascriptExecutor) driver;
	}

	private WebElement get_text() {

		return (this.driver.findElement(By.xpath(
				"//div[@id='rich_tltr']/div[@class='t_input']/div[@id='t_inblk']/div[@class='t_txtblkin']/textarea[@id='t_sv']")));
	}

	// public void click_translator() throws NullPointerException {
	//// Assert.assertEquals(this.driver.findElement(By.xpath("[@class='t_navlink
	// t_navlinkactive']")).isDisplayed(),
	//// true);
	// WebElement text =
	// driver.findElement(By.xpath("//div[@id='theader']/ul/li/a[@class='t_navlink']"));
	// JavascriptExecutor js = (JavascriptExecutor) driver;
	// js.executeScript("arguments[0].click();", text);
	// }

	// public void click_conversion() throws NullPointerException {
	//// Assert.assertEquals(
	//// // this.driver.findElement(By.xpath("[@class ='c-uhf-nav-link f-current
	//// // x-hidden-focus']")).isDisplayed(),
	//// true);// Verification for visiblity of conversion tab WebElement
	// //WebElement conversion =
	// driver.findElement(By.xpath("//div/ul/li[@class=['t_navlink
	// t_navlinkactive']"));
	// WebElement conversion =driver.findElement(By.className("t_navlink
	// t_navlinkactive"));
	// JavascriptExecutor js = (JavascriptExecutor) driver;
	// js.executeScript("arguments[0].click();", conversion);// clicking conversion
	// js.executeScript("alert('you have clicked coversion tab');");
	// }

	public void search_box() throws NullPointerException {
		Assert.assertEquals(this.driver.findElement(By.id("sb_form_q")).isDisplayed(), true);
		// WebElement wb = driver.findElement(By.id("sb_form_q"));
		// wb.sendKeys("google");
		// js.executeScript(driver.get, arg1);
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("document.getElementById('sb_form_q').value = 'google';");
		js.executeScript("document.getElementById('sb_form_q').click();");
		Assert.assertEquals(this.driver.findElement(By.id("search-button")).isDisplayed(), true);
		WebElement icon = driver.findElement(By.id("search-button"));
		js.executeScript("arguments[0].click();", icon);
		// 2
		// JavascriptExecutor js =(JavascriptExecutor)driver;

		// wb.click();

	}

	public void drop_down1() throws InterruptedException {
		// TODO Auto-generated method stub
		Select drpDwn=new Select(driver.findElement(By.id("t_sl")));
		drpDwn.selectByVisibleText("Bangla");
		Thread.sleep(5000);
		driver.findElement(By.id("t_sl")).click(); 
	}

	public void set_text() throws NullPointerException {
		// Assert.assertEquals(this.driver.findElement(By.className("t_txtblkin)")).isDisplayed(),
		// true);
		// driver.findElement(By.className("t_txtblkin)")).sendKeys("class");
		driver.findElement(By.id("t_sv")).sendKeys("class");

	}
	public void click_help() {
		Assert.assertEquals(this.driver.findElement(By.id("sb_help")).isDisplayed(), true);
		driver.findElement(By.id("sb_help")).click();
		
	}
	public void drop_down2() throws InterruptedException {
		// TODO Auto-generated method stub
		Select drpDwn1=new Select(driver.findElement(By.id("t_tl")));
		drpDwn1.selectByVisibleText("Danish");
		Thread.sleep(5000);
		driver.findElement(By.id("t_tl")).click(); 
	
	}
	public void click_on_Advertise() {
		Assert.assertEquals(this.driver.findElement(By.cssSelector("a[id='sb_advertise']")).isDisplayed(),true);
		driver.findElement(By.cssSelector("a[id='sb_advertise']")).click();
	}
	public void click_on_Legal() {
		Assert.assertEquals(this.driver.findElement(By.cssSelector("a[id='sb_legal']")).isDisplayed(),true);
		driver.findElement(By.cssSelector("a[id='sb_legal']")).click();
	}

	public void click_on_privacy() {
		// TODO Auto-generated method stub
		Assert.assertEquals(this.driver.findElement(By.cssSelector("a[id='sb_privacy']")).isDisplayed(),true);
		driver.findElement(By.cssSelector("a[id='sb_privacy']")).click();
	}
	public void click_on_conversation() {
		Assert.assertEquals(this.driver.findElement(By.cssSelector("a[class='t_navlink']")).isDisplayed(),true);
		driver.findElement(By.cssSelector("a[class='t_navlink']")).click();
	}
}
