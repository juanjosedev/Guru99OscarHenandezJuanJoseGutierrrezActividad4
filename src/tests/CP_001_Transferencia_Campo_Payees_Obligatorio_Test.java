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

public class CP_001_Transferencia_Campo_Payees_Obligatorio_Test {

	private WebDriver driver;
	private LoginPage lp;
	private HomePage hp;
	private FundTransferPage ftp;
	
	@Before
	public void setUp() {
		
		System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.get("http://demo.guru99.com/V4/index.php");
		
	}
	
	@Test
	public void CP_001_Transferencia_Campo_Payees_Obligatorio() {
		
		lp = new LoginPage(driver);
		lp.sendLogin("mngr175509", "jose20#1");
		hp = new HomePage(driver);
		ftp = hp.getBarraNavegacion().goToFundTransferPage();
		ftp.pressSubmit();
		Alert alert = driver.switchTo().alert();
		
		String expected = "please fill all fields";
		String actual = alert.getText().toLowerCase();
		
		assertEquals(expected, actual);
		
	}
	
	@After
	public void tearDown() {
		driver.close();
	}
	
}
