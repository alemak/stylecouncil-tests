package com.netaporter.cucumber.steps.sc;

import com.netaporter.cucumber.steps.BaseSteps;
import com.netaporter.test.utils.pages.AbstractPage;
import cucumber.api.PendingException;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.openqa.selenium.WebElement;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Scope;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

/**
 * Created by al.makarenko on 13/05/2016.
 */
@Scope("cucumber-glue")
public class MembersListingSteps extends BaseSteps {
    static Logger logger = LoggerFactory.getLogger(MembersListingSteps.class);

    @Given("^Member Listing page displays (\\d+) members$")
    public void memberListingPageDisplaysMembers(Integer numOfMembers) throws Throwable {
        assertEquals(numOfMembers, memberListingPage.getNumberOfMembersDisplayed());
    }

    @And("^the 'Load More' element contains text 'Load (\\d+) more members'$")
    public void theLoadMoreElementContainsTextLoadNumberOfMembersMoreMembers(Integer numOfMembers) throws Throwable {
        assertEquals(String.format("LOAD %s MORE MEMBERS", numOfMembers), memberListingPage.getLoadMoreText());
    }

    @When("^I click on Load (\\d+) More Members and see spinner appearing  and disappearing$")
    public void iClickOnLoadNumberOfMembersMoreMembers(Integer numOfMembers) throws Throwable {
        memberListingPage.loadMoreMembers();
    }

    @Then("^the member block contains member image, profession, full name, city and (shows|does not show) number of recommendations$")
    public void theMemberBlockContainsMemberImageProfessionFullNameCityAndNumberOfRecommendations(String recNum) throws Throwable {
        assertTrue("Member image not displayed in member block", memberListingPage.isMemberDetailsImageDisplayed(memberListingPage.getFirstMemberBlock()));
        assertTrue("Member job not displayed in member block", memberListingPage.isMemberDetailsJobDisplayed(memberListingPage.getFirstMemberBlock()));
        assertTrue("Member name not displayed in member block", memberListingPage.isMemberDetailsNameDisplayed(memberListingPage.getFirstMemberBlock()));
        assertTrue("Member location not displayed in member block", memberListingPage.isMemberDetailsLocationDisplayed(memberListingPage.getFirstMemberBlock()));
        if ("shows".equals(recNum)) {
            assertTrue("Member number of recommendations not displayed in member block", memberListingPage.isMemberDetailsRecNoDisplayed(memberListingPage.getFirstMemberBlock()));
        } else {
            assertFalse("Member number of recommendations should not be displayed in member block", memberListingPage.isMemberDetailsRecNoDisplayed(memberListingPage.getFirstMemberBlock()));
        }
    }


    @When("^I click on the member item$")
    public void iClickOnTheMemberItem() throws Throwable {
        WebElement memberItem = memberListingPage.getFirstMemberBlock();
        String memberName = memberItem.getAttribute("title");
        memberName = memberName.replace(" - Men's Style Council member", "");
        logger.info("Selecting member - {} ", memberName);
        scenarioSession.putData("Member Name", memberName);
        memberListingPage.getMemberImage(memberItem).click();
    }

    @Then("^I am taken to this member's details page$")
    public void iAmTakenToThisMemberSDetailsPage() throws Throwable {
        assertEquals("Expected member's page has not been displayed",scenarioSession.getData("Member Name").toString().toUpperCase(), memberDetailsPage.getMemberNameHeading().getText());
    }
}
