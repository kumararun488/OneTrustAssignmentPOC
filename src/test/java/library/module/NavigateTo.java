package library.module;

import static org.testng.AssertJUnit.assertEquals;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import library.literals.Constants.Onetrust;
import library.locators.Paths;

public class NavigateTo {
	WebDriver driver;
	WebDriverWait wait;

	public NavigateTo(WebDriver driver, WebDriverWait wait) {
		this.driver = driver;
		this.wait = wait;
	}

	public NavigateTo VerifyyTitle(String title) {

		assertEquals(title, driver.getTitle());

		return this;

	}

	public NavigateTo CompanyPage() {

		driver.findElement(By.xpath(Paths.COMPANY_MENU)).click();

		return this;
	}

	public NavigateTo careersPage() {		
		
		driver.get(Onetrust.CAREERS_PAGE_URL);
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);		
		wait.until(ExpectedConditions.titleContains(Onetrust.CAREERS_PAGE_TITLE));
		return this;
	}

}
