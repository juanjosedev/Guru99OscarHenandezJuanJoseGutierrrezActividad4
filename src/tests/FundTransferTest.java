package tests;

import static org.junit.Assert.*;

import java.util.concurrent.TimeUnit;

import org.junit.*;
import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import pages.FundTransferPage;
import pages.HomePage;
import pages.LoginPage;

public class FundTransferTest {

	private WebDriver driver;
	private LoginPage lp;
	private FundTransferPage ftp;
	private HomePage hp;
	
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
		ftp.sendForm();
		Alert alert = driver.switchTo().alert();
		
		String expected = "Please fill all fields";
		String actual = alert.getText();
		
		assertEquals(expected, actual);
		
	}
	
	@After
	public void tearDown() {
		driver.close();
	}
	
}
