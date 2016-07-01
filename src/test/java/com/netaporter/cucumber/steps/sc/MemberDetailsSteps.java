package com.netaporter.cucumber.steps.sc;

import com.netaporter.cucumber.steps.BaseSteps;
import cucumber.api.PendingException;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import org.springframework.context.annotation.Scope;

import static junit.framework.TestCase.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

/**
 * Created by al.makarenko on 23/05/2016.
 */
@Scope("cucumber-glue")
public class MemberDetailsSteps extends BaseSteps {
    @Then("^I can see the image of the SC member$")
    public void iCanSeeTheImageOfTheSCMember() throws Throwable {
        assertTrue("Member image is not displayed", memberDetailsPage.getMemberImage().isDisplayed());
    }

    @And("^I can see the member biography$")
    public void iCanSeeTheMemberBiography() throws Throwable {
        assertTrue("Member biography is not displayed", memberDetailsPage.getMemberDetailsTextBlock().isDisplayed());
    }

    @And("^I can see interview component$")
    public void iCanSeeInterviewComponent() throws Throwable {
        assertTrue("Member interview image is not visible", memberDetailsPage.getInterviewProfileImage().isDisplayed());
        assertEquals("Member name in interview  is not displayed correctly", "underline", memberDetailsPage.getInterviewProfileName().getCssValue("text-decoration"));
        assertTrue("Member interview date is not visible", memberDetailsPage.getInterviewProfileDate().isDisplayed());
        assertTrue("Member interview image is not visible", memberDetailsPage.getInterviewProfileTitle().isDisplayed());
    }

    @And("^I can see headline with member name in uppercase$")
    public void iCanSeeHeadlineWithMemberNameInUppercase() throws Throwable {
       assertEquals( "Heading should contain member name in uppercase", memberDetailsPage.getMemberName().toUpperCase(),  memberDetailsPage.getMemberNameHeading().getText());
    }

    @And("^I can see the recommended products component$")
    public void iCanSeeTheRecommendedProductsComponent() throws Throwable {
        assertTrue("Recommended products component is not visible", memberDetailsPage.getRecommendedProducts().isDisplayed());

    }
    @And("^I can see the recommended places component$")
    public void iCanSeeTheRecommendedPlacesComponent() throws Throwable {
        assertTrue("Recommended places component is not visible", memberDetailsPage.getRecommendedPlaces().isDisplayed());

    }

    @Then("^the Recommended Places block contains place image, category, name, location and (shows|does not show) the quote and who the place is recommended by$")
    public void theRecommendedPlacesBlockContainsPlaceImageNameLocationQuoteAndShowsWhoThePlaceIsRecommendedBy(String recNo) throws Throwable {
        assertTrue("Recommended places block image is not visible", memberDetailsPage.isRecommendedPlacesBlockImageDisplayed(memberDetailsPage.getFirstRecommendePlacesBlock()));
        assertTrue("Recommended places block category is not visible", memberDetailsPage.isRecommendedPlacesBlockCategoryDisplayed(memberDetailsPage.getFirstRecommendePlacesBlock()));
        assertTrue("Recommended places block name is not visible", memberDetailsPage.isRecommendedPlacesBlockNameDisplayed(memberDetailsPage.getFirstRecommendePlacesBlock()));
        assertTrue("Recommended places block location is not visible", memberDetailsPage.isRecommendedPlacesBlockLocationDisplayed(memberDetailsPage.getFirstRecommendePlacesBlock()));

        if("shows".equals(recNo)){
            assertTrue("Recommended places block quote is not visible", memberDetailsPage.isRecommendedPlacesBlockQuoteDisplayed(memberDetailsPage.getFirstRecommendePlacesBlock()));
            assertTrue("Recommended places block recommendation is not visible", memberDetailsPage.isRecommendedPlacesBlockRecommendedByDisplayed(memberDetailsPage.getFirstRecommendePlacesBlock()));
        }
        else {
            assertFalse("Recommended places block quote is visible", memberDetailsPage.isRecommendedPlacesBlockQuoteDisplayed(memberDetailsPage.getFirstRecommendePlacesBlock()));
            assertFalse("Recommended places block recommendation is visible", memberDetailsPage.isRecommendedPlacesBlockRecommendedByDisplayed(memberDetailsPage.getFirstRecommendePlacesBlock()));
        }
    }
}

