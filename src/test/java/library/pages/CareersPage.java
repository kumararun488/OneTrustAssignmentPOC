package library.pages;

import static junit.framework.TestCase.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang3.text.WordUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CareersPage {

	WebDriver driver;
	WebDriverWait wait;

	public CareersPage(WebDriver driver, WebDriverWait wait) {
		this.driver = driver;
		this.wait = wait;
	}

	public CareersPage verifyTitle(String title) {
		assertEquals(title, driver.getTitle());
		return this;
	}

	public List<String> getCompanyLocations() {
		List<String> locations = new ArrayList<String>();
		for (WebElement places : driver
				.findElements(By.xpath("//div[@class='container']/ul/li[@role='presentation']/a"))) {
			locations.add(WordUtils.capitalize(places.getText().toLowerCase()));
		}
		System.out.println("One Trust is Growing FAST.... And have branches in following places!\n");

		for (String s : locations) {
			System.out.println("- " + s.toUpperCase());
		}

		return locations;
	}

	public CareersPage getLocationBasedOpenings(String location) {

		List<WebElement> positions = null;
		if (location.equals("San Francisco")) {
			location = "San";
		}

		driver.findElement(By.xpath("//ul[@class='nav nav-tabs']/li/a[contains(text(),'"+location+"')]")).click();

		List<WebElement> departments = driver.findElements(
				By.xpath("//div[contains(@id,'" + location.toLowerCase() + "')]/div//div[@class='col-sm-4']//h3"));

		for (int i = 1; i < 2; i++) {

			for (int j = 1; j <= departments.size(); j++) {
				System.out.println(
						"-------------------------------------------------------------------------------------------------\n");
				System.out.println("In " + location.toUpperCase() + " Under "
						+ departments.get(j - 1).getText().toUpperCase() + " Department we have Following Openings: ");
				System.out.println(
						"------------------------------------------------------------------------------------------------\n");

				if (j == 4) {
					positions = driver.findElements(By.xpath(
							"//div[contains(@id,'" + location.toLowerCase() + "')]/div/div[@class='row'][2]//div[" + i
									+ "][@class='col-sm-4']//h3/parent::div/ul/li/a"));
				}
				if (j == 5) {
					positions = driver.findElements(By.xpath(
							"//div[contains(@id,'" + location.toLowerCase() + "')]/div/div[@class='row'][2]//div["
									+ (i + 1) + "][@class='col-sm-4']//h3/parent::div/ul/li/a"));
				}

				if (j != 4 && j != 5) {
					positions = driver.findElements(By.xpath(
							"//div[contains(@id,'" + location.toLowerCase() + "')]/div/div[@class='row'][1]//div[" + (j)
									+ "][@class='col-sm-4']//h3/parent::div/ul/li/a"));
				}
				for (WebElement element : positions) {
					System.out.println(element.getText());
				}
				System.out.println("\n");

			}

		}

		return this;
	}
}
