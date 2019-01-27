package pages;

import org.openqa.selenium.WebDriver;

public class HomePage {

	private BarraNavegacion nav;
	
	public HomePage(WebDriver driver) {
		nav = new BarraNavegacion(driver);
	}
	
	public BarraNavegacion getBarraNavegacion() {
		return this.nav;
	}
	
}
