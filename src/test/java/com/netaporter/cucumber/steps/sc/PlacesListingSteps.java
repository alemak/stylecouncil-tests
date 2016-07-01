package com.netaporter.cucumber.steps.sc;

import com.netaporter.cucumber.steps.BaseSteps;
import cucumber.api.PendingException;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Scope;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

/**
 * Created by al.makarenko on 17/06/2016.
 */
@Scope("cucumber-glue")
public class PlacesListingSteps extends BaseSteps {
    static Logger logger = LoggerFactory.getLogger(PlacesListingSteps.class);

    @Given("^I go to the Style Council Recommended Places Listing Page$")
    public void iGoToTheStyleCouncilRecommendedPlacesListingPage() throws Throwable {
        webBot.goToPage(placesListingPage);
    }

    @Given("^Recommended Places Listing page displays (\\d+) places$")
    public void placesListingPageDisplaysPlaces(Integer numOfPlaces) throws Throwable {
        assertEquals(numOfPlaces, placesListingPage.getNumberOfPlacesDisplayed());
    }

    @And("^the 'Load More' element contains text 'Load (\\d+) more places'$")
    public void theLoadMoreElementContainsTextLoadNumberOfMembersMoreMembers(Integer numOfPlaces) throws Throwable {
        assertEquals(String.format("LOAD %s MORE PLACES", numOfPlaces), placesListingPage.getLoadMoreText());
    }

    @When("^I click on Load (\\d+) More Places and see spinner appearing  and disappearing$")
    public void iClickOnLoadNumberOfMembersMorePlaces(Integer numOfPlaces) throws Throwable {
        placesListingPage.loadMorePlaces();
    }

    @Then("^the places block contains place image, category, name, location and (shows|does not show) who has recommended it$")
    public void checkPlacesBlockElements(String recNum) throws Throwable {
        assertTrue("Place image not displayed in place block", placesListingPage.isPlaceDetailsImageDisplayed(placesListingPage.getFirstPlaceBlock()));
        assertTrue("Place category not displayed in place block", placesListingPage.isPlaceDetailsCategoryDisplayed(placesListingPage.getFirstPlaceBlock()));
        assertTrue("Place name not displayed in place block", placesListingPage.isPlaceDetailsNameDisplayed(placesListingPage.getFirstPlaceBlock()));
        assertTrue("Place location not displayed in place block", placesListingPage.isPlaceDetailsLocationDisplayed(placesListingPage.getFirstPlaceBlock()));
        if ("shows".equals(recNum)) {
            assertTrue("Place number of recommendations not displayed in place block", placesListingPage.isPlaceDetailsRecNoDisplayed(memberListingPage.getFirstMemberBlock()));
        } else {
            assertFalse("Place number of recommendations should not be displayed in place block", placesListingPage.isPlaceDetailsRecNoDisplayed(memberListingPage.getFirstMemberBlock()));
        }
    }

}
