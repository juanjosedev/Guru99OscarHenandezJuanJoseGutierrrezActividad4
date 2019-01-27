package tests;

import static org.junit.Assert.*;

import java.util.concurrent.TimeUnit;

import org.junit.*;
import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import model.Account;
import pages.BalanceEnquiryPage;
import pages.FundTransferPage;
import pages.HomePage;
import pages.LoginPage;

public class FundTransferTest {

	private WebDriver driver;
	private LoginPage lp;
	private HomePage hp;
	private FundTransferPage ftp;
	private BalanceEnquiryPage bep;
	
	@Before
	public void setUp() {
		
		System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.get("http://demo.guru99.com/V4/index.php");
		
	}
	
	@Test
	public void cp_1() {
		
		lp = new LoginPage(driver);
		lp.sendLogin("mngr175509", "jose20#");
		hp = new HomePage(driver);
		ftp = hp.getBarraNavegacion().goToFundTransferPage();
		ftp.pressSubmit();
		Alert alert = driver.switchTo().alert();
		
		String expected = "please fill all fields";
		String actual = alert.getText().toLowerCase();
		
		assertEquals(expected, actual);
		
	}
	
	@Test
	public void cp_2() {
		
		int amount = 200;
		
		int payersAccountBalance = 0;
		int payeesAccountBalance = 0;
		
		int payersAccountBalanceExpected = 0;
		int payeesAccountBalanceExpected = 0;
	
		Account payersAccount = new Account(55507, "Current");
		Account payeesAccount = new Account(55508, "Current");
		
		lp = new LoginPage(driver);
		lp.sendLogin("mngr175509", "jose20#");
		hp = new HomePage(driver);
		
		bep = hp.getBarraNavegacion().goToBalanceEnquiryPage();
		
		bep.sendForm(payersAccount.getNo());
		payersAccount.setBalance(bep.getBalance());
		
		driver.navigate().back();
		
		bep.sendForm(payeesAccount.getNo());
		payeesAccount.setBalance(bep.getBalance());
		
		payersAccountBalance = payersAccount.getBalance();
		payeesAccountBalance = payeesAccount.getBalance();
		
		payersAccountBalanceExpected = payersAccountBalance - amount;
		payeesAccountBalanceExpected = payeesAccountBalance + amount;
		
		ftp = hp.getBarraNavegacion().goToFundTransferPage();
		ftp.sendForm(payersAccount.getNo(), payeesAccount.getNo(), amount, "Fund");
		
		bep = hp.getBarraNavegacion().goToBalanceEnquiryPage();
		
		bep.sendForm(payersAccount.getNo());
		payersAccount.setBalance(bep.getBalance());

		assertEquals(payersAccountBalanceExpected, payersAccount.getBalance());
		
		driver.navigate().back();
		
		bep.sendForm(payeesAccount.getNo());
		payeesAccount.setBalance(bep.getBalance());
		
//		assertEquals(payeesAccountBalanceExpected, payeesAccount.getBalance());
		
	}
	
	@After
	public void tearDown() {
		driver.close();
	}
	
}
