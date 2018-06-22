import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.html5.WebStorage;

public class tatoc_class {
WebElement username;
WebElement password;
WebDriver driver;
private WebElement get_user_name{
	return this.driver.findElement(By.id("txtUserName"));
}
private WebElement get_password{
	return this.driver.findElement(By.id("txtPassword"));
}
public login_form(WebDriver webdriver) {
	this.driver=driver;
}
public void login(String username,String password) {
	get_user_name().sendkeys(username);
	get_password().sendkeys(password);
	get_password().submit();
}
public Boolean isErrorMessage(String expectedMessage) {
	return getErrorMessageElement().getText().contains(expected message);
}
}
