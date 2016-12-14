package library.pages;

import static junit.framework.TestCase.assertEquals;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HomePage {

	WebDriver driver;
	WebDriverWait wait;

	public HomePage(WebDriver driver, WebDriverWait wait) {
		this.driver = driver;
		this.wait = wait;
	}
	
	public HomePage lauchUrl(String url){
		driver.get(url);
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		return this;
	}
	
	public HomePage verifyTitle(String title){
		assertEquals(title, driver.getTitle());
		return this;
	}
}
