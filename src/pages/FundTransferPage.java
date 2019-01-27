package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class FundTransferPage {

	private WebDriver driver;
	private By payersField;
	private By payeesField;
	private By amountField;
	private By descriptionField;
	private By submitButton;
	
	public FundTransferPage(WebDriver driver) {
		this.driver = driver;
		payersField = By.name("payersaccount");
		payeesField = By.name("payeeaccount");
		amountField = By.name("ammount");
		descriptionField = By.name("desc");
		submitButton = By.name("AccSubmit");
	}
	
	public void enterPayersAccount(int payersAccountNumber) {
		driver.findElement(payersField).sendKeys(Integer.toString(payersAccountNumber));
	}
	
	public void enterPayeesAccount(int payeesAccountNumber) {
		driver.findElement(payeesField).sendKeys(Integer.toString(payeesAccountNumber));
	}
	
	public void enterAmount(int amount) {
		driver.findElement(amountField).sendKeys(Integer.toString(amount));
	}
	
	public void enterDescription(String description) {
		driver.findElement(descriptionField).sendKeys(description);
	}
	
	public void pressSubmit() {
		driver.findElement(submitButton).click();
	}
	
	public void sendForm(int payersAccountNumber, int payeesAccountNumber, int amount, String description) {
		enterPayersAccount(payersAccountNumber);
		enterPayeesAccount(payeesAccountNumber);
		enterAmount(amount);
		enterDescription(description);
		pressSubmit();
	}
	
}
