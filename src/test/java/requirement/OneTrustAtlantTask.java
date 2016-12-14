package requirement;

import java.util.List;

import org.testng.annotations.Test;

import configuration.Configuration;
import library.literals.Constants.Onetrust;
import library.module.NavigateTo;
import library.pages.CareersPage;
import library.pages.HomePage;

public class OneTrustAtlantTask extends Configuration {

	@Test
	public void FetchCurrentOpenings() throws Exception {

		HomePage home = new HomePage(super.driver, super.wait);
		NavigateTo navigate = new NavigateTo(super.driver, super.wait);
		CareersPage careers = new CareersPage(super.driver, super.wait);

		home.lauchUrl(Onetrust.HOME_PAGE_URL);
		home.verifyTitle(Onetrust.HOME_PAGE_TITLE);
		navigate.careersPage();
		List<String> location = careers.getCompanyLocations();

		for (String s : location) {
			careers.getLocationBasedOpenings(s);
		}

	}

}
