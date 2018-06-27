package tatoctesting;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Hris {
	WebElement username;
	WebElement pass;
	WebDriver driver;

	private WebElement get_user_name() {
		return (this.driver.findElement(By.id("txtUserName")));
	}

	private WebElement get_password() {
		return (this.driver.findElement(By.id("txtPassword")));
	}

	public WebElement getErrorMessage() {
		return (this.driver.findElement(By.cssSelector("alert error")));
	}

	public Hris(WebDriver driver) {
		this.driver = driver;
	}

	public void Login(String username, String passwrd) {
		
		get_user_name().clear();
		get_user_name().sendKeys(username);
		get_password().clear();
		get_password().sendKeys(passwrd);
		get_password().submit();
		
	}
	
	public Boolean isErrorMessage(String expectedMessage) {
		return getErrorMessage().getText().contains(expectedMessage);
		
	}
	 public String LoginByInvalidCredentials(String username, String password) {
			Login(username, password);
			return driver.findElement(By.className("loginTxt")).getText();
		}
	    
	    public String LoginByBlankPassword(String username,String password)
	    {
	       Login(username, password);
	        return driver.findElement(By.id("txtPassword")).getAttribute("style");
	    }
	  public Timesheet LoginByCorrectCredentials(String username,String password)
	    {
	      Login(username, password);
	         return new Timesheet(driver);
	    }
	
	public Boolean isPasswordAnnotated() {
		return get_password().getAttribute("style").contains("red");
	}
	public Boolean isErrorAnotated1() {
		return get_user_name().getAttribute("style").contains("red");
	}

}
