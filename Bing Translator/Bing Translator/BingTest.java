package test;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import tatoctesting.Bing;

public class BingTest {
	WebDriver driver = new ChromeDriver();
	Bing bing = new Bing(driver);
	JavascriptExecutor js = (JavascriptExecutor) driver;

	public BingTest() {
		System.setProperty("webdriver.chrome.driver", "D:\\chromedriver_win32\\chromedriver.exe");
		// this.driver=new ChromeDriver();
		driver.manage().window().maximize();
		// Bing bing=new Bing(driver);
		driver.get("https://www.bing.com/translator");
	}

	@Test(priority=1)
	public void set_connection() {
		System.setProperty("webdriver.chrome.driver", "D:\\chromedriver_win32\\chromedriver.exe");

		System.out.println("connected");

	}
	@Test(priority=2)
	public void search() throws NullPointerException {
		// Bing bing=new Bing(driver);
		bing.search_box();
		// js.executeScript("window.location = 'https://www.bing.com/search?q=google'");
		String expectedurl = "https://www.bing.com/translator";
		Assert.assertEquals(driver.getCurrentUrl(), expectedurl);
	}

	@Test(priority=3)
	public void drop_down1_test() throws InterruptedException {
		// Bing bing=new Bing(driver);
		bing.drop_down1();
	}

	@Test(priority=4)
	public void set_text_test() {
		bing.set_text();

	}

	@Test(priority=6)
	public void click_help_test() {
		bing.click_help();
		String expectedurl = "https://www.bing.com/translator";
		Assert.assertEquals(driver.getCurrentUrl(), expectedurl);
	}

	@Test(priority=5)
	public void drop_down2_test() throws InterruptedException {
		bing.drop_down2();
	}
@ Test(priority=8)
public void click_on_legal_test() {
	bing.click_on_Legal();
	driver.getCurrentUrl().contains("servicesagreement/");
	driver.get("https://www.bing.com/translator");
}
	@Test(priority=7)
	public void click_on_advertise_test() {
		bing.click_on_Advertise();
		driver.getCurrentUrl().contains("Foot-sub_serp");
		driver.get("https://www.bing.com/translator");
		}
	@Test(priority=9)
	public void click_on_privacy_test() {
		bing.click_on_privacy();
		driver.getCurrentUrl().contains("privacystatement");
		driver.get("https://www.bing.com/translator");
	}
	@Test(priority=10)
	public void click_on_conversation_test() {
		bing.click_on_conversation();
		driver.getCurrentUrl().contains("https://translator.microsoft.com/");
	}
}