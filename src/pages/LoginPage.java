package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage {

	private WebDriver driver;
	private By userIDField;
	private By passwordField;
	private By submitButton;
	
	public LoginPage(WebDriver driver) {
		this.driver = driver;
		userIDField = By.name("uid");
		passwordField = By.name("password");
		submitButton = By.name("btnLogin");
	}
	
	public void enterUserID(String userID) {
		driver.findElement(userIDField).sendKeys(userID);;
	}
	
	public void enterPassword(String password) {
		driver.findElement(passwordField).sendKeys(password);
	}
	
	public void pressLogin() {
		driver.findElement(submitButton).click();
	}
	
	public void sendLogin(String userID, String password) {
		enterUserID(userID);
		enterPassword(password);
		pressLogin();
	}
	
}