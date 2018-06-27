package tatoctesting;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class Timesheet {
	  WebDriver driver;
	    public Timesheet(WebDriver driver) 
	    {
	        this.driver=driver;
	    }
	   
		public boolean isloginpage() {
			//driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			return this.driver.getCurrentUrl().equals("https://hris.qainfotech.com/login.php");
		}
		public String data()
		{
		 return driver.findElement(By.xpath("span[class='date ng-binding']")).getText();
		}
		
		public boolean isTimesheetPage()
		{
			return this.driver.getCurrentUrl().equals("https://hris.qainfotech.com:8086/time/timesheet");
		}
		
		public String logout()
		{ driver.findElement(By.xpath("//*[@id=\"page\"]/div/div[1]/div[2]/ul/li/a/img")).click(); 
			driver.findElement(By.xpath("//*[@id=\"page\"]/div/div[1]/div[2]/ul/li/ul/li[4]/a")).click();
			return this.driver.getCurrentUrl();
			
		}
		
}
