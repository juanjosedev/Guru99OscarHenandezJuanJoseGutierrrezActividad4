package tests;

import static org.junit.Assert.*;

import java.util.concurrent.TimeUnit;

import org.junit.*;
import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import pages.HomePage;
import pages.LoginPage;
import pages.PasswordInputPage;

public class CP_003_Cambio_Password_Test {

	private WebDriver driver;
	private LoginPage lp;
	private HomePage hp;
	private PasswordInputPage pip;
	
	@Before
	public void setUp() {
		
		System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.get("http://demo.guru99.com/V4/index.php");
	
	}
	
	@Test
	public void CP_003_Cambio_Password() {
		
		String oldpassword = "jose20#1";
		String newpassword = "jose20#99";
		
		lp = new LoginPage(driver);
		lp.sendLogin("mngr175509", "jose20#1");
		hp = new HomePage(driver);
		pip = hp.getBarraNavegacion().goToPasswordInputPage();
		pip.sendForm(oldpassword, newpassword, newpassword);
		Alert alert = driver.switchTo().alert();
		
		String expected = "password is changed";
		String actual = alert.getText().toLowerCase();
		
		assertEquals(expected, actual);
		
	}
	
	@After
	public void tearDown() {
		driver.close();
	}
	
}
