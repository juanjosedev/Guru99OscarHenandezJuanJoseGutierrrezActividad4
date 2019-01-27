package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class PasswordInputPage {

	private WebDriver driver;
	private By oldPasswordField;
	private By newPasswordField;
	private By confirmPasswordField;
	private By submitButton;
	
	public PasswordInputPage(WebDriver driver) {
		this.driver = driver;
		oldPasswordField = By.name("oldpassword");
		newPasswordField = By.name("newpassword");
		confirmPasswordField = By.name("confirmpassword");
		submitButton = By.name("sub");
	}
	
	public void enterOldPassword(String oldPassword) {
		driver.findElement(oldPasswordField).sendKeys(oldPassword);
	}
	
	public void enterNewPassword(String newPassword) {
		driver.findElement(newPasswordField).sendKeys(newPassword);
	}
	
	public void enterConfirmPassword(String confirmPassword) {
		driver.findElement(confirmPasswordField).sendKeys(confirmPassword);
	}
	
	public void pressSubmit() {
		driver.findElement(submitButton).click();
	}
	
	public void sendForm(String oldPassword, String newPassword, String confirmPassword) {
		
		enterOldPassword(oldPassword);
		enterNewPassword(newPassword);
		enterConfirmPassword(confirmPassword);
		pressSubmit();
		
	}
	
}
