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
	
	public void sendForm() {
		driver.findElement(submitButton).click();
	}
	
	
}
