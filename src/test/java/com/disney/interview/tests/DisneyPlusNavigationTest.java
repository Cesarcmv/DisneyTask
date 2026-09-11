package com.disney.interview.tests;

import org.testng.annotations.Test;

import com.disney.interview.pages.DisneyPlusHomePage;
import com.disney.interview.pages.PrivacyPolicyPage;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class DisneyPlusNavigationTest extends BaseTest {

    private static final String PRIVACY_HOST = "https://privacy.thewaltdisneycompany.com";
    private static final String EXPLORE_TITLE = "Explore Disney+ | Explore Latest News & Exclusive Content";

    @Test(description = "Navigate from Disney+ footer to Privacy Policy and Explore Disney+")
    public void shouldNavigateFromDisneyPlusToExploreDisneyPlus() {
        DisneyPlusHomePage homePage = new DisneyPlusHomePage(driver).open();
        homePage.acceptConsentIfPresent();
        homePage.scrollToFooter();

        PrivacyPolicyPage privacyPolicyPage = homePage.clickPrivacyPolicy();
        assertTrue(privacyPolicyPage.getPrivacyUrl().contains(PRIVACY_HOST),
            "Expected Privacy Policy URL to contain " + PRIVACY_HOST);

        privacyPolicyPage.goBackToDisneyPlus();
        String exploreTitle = homePage.clickExploreDisneyPlus();

        assertEquals(exploreTitle, EXPLORE_TITLE,
            "Unexpected Explore Disney+ page title");
    }
}
