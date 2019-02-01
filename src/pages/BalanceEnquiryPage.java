package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class BalanceEnquiryPage {
	
	private WebDriver driver;
	private By accountNumberField;
	private By submitButton;

	public BalanceEnquiryPage(WebDriver driver) {
		this.driver = driver;
		accountNumberField = By.name("accountno");
		submitButton = By.name("AccSubmit");
	}
	
	public void enterAccount(int accountNumber) {
		driver.findElement(accountNumberField).sendKeys(Integer.toString(accountNumber));
	}
	
	public void pressSubmit() {
		driver.findElement(submitButton).click();
	}
	
	public void sendForm(int accountNumber) {
		enterAccount(accountNumber);
		pressSubmit();
	}
	
	public int getBalance() {
		int balance = 0;
		String strBalance = driver.findElement(By.xpath("//*[@id=\"balenquiry\"]/tbody/tr[16]/td[2]")).getText();
		balance = Integer.parseInt(strBalance);
		return balance;
	}
	
}
