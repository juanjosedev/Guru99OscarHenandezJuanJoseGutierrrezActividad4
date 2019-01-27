package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class BarraNavegacion {

	private WebDriver driver;
	private By fundTransferButtonNav;
	private By changePasswordButtonNav;
	private By balanceEnquiryButtonNav;
	
	public BarraNavegacion(WebDriver driver) {
		this.driver = driver;
		fundTransferButtonNav = By.cssSelector("a[href=\"FundTransInput.php\"]");
		changePasswordButtonNav = By.cssSelector("a[href=\"PasswordInput.php\"]");
		balanceEnquiryButtonNav = By.cssSelector("a[href=\"BalEnqInput.php\"]");
	}
	
	public FundTransferPage goToFundTransferPage() {
		driver.findElement(fundTransferButtonNav).click();
		return new FundTransferPage(driver);
	}

	public PasswordInputPage goToPasswordInputPage() {
		driver.findElement(changePasswordButtonNav).click();
		return new PasswordInputPage(driver);
	}
	
	public BalanceEnquiryPage goToBalanceEnquiryPage() {
		driver.findElement(balanceEnquiryButtonNav).click();
		return new BalanceEnquiryPage(driver);
	}
	
}
