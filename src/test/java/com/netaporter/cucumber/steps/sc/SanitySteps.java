package com.netaporter.cucumber.steps.sc;

import com.netaporter.cucumber.steps.BaseSteps;
import com.netaporter.pages.sc.BaseScPage;
import com.netaporter.pages.sc.HomePage;
import cucumber.api.PendingException;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.openqa.selenium.By;
import org.springframework.context.annotation.Scope;

import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;


/**
 * Created by al.makarenko on 03/05/2016.
 */
@Scope("cucumber-glue")
public class SanitySteps extends BaseSteps {

    @Then("^The (.*) page contains header \"([^\"]*)\"$")
    public void thePageContainsHeader(String pageName, String header) throws Throwable {
        assertEquals(header, ((BaseScPage) pageRegistry.lookupPage(pageName)).getHeaderText());
    }

    @Given("^I go to the Style Council Home page$")
    public void iGoToTheStyleCouncilHomePage() throws Throwable {
        webBot.goToPage(homePage);
    }

    @Given("^I go to the Style Council Member Listing Page$")
    public void iGoToTheStyleCouncilMemberListingPage() throws Throwable {
        webBot.goToPage(memberListingPage);
    }

    @Given("^I go to (.*) Member Details Page$")
    public void iGoToTheStyleCouncilMemberDetailsPage(String memberName) throws Throwable {
        memberDetailsPage.setPath(memberName);
        webBot.goToPage(memberDetailsPage);
    }

    @Then("^The style council Member Listing Page is displayed$")
    public void theStyleCouncilMemberListingPageIsDisplayed() throws Throwable {

    }

    @And("^the (.*) page (contains|does not contain) breadcrumbs (.*)$")
    public void thePageContainsBreadcrumbs(String pageName, String isVisible, List<String> breadcrumbs) throws Throwable {
        if("contains".equals(isVisible)){
            breadcrumbs.forEach(breadcrumb ->
                    assertTrue(String.format("Breadcrumb \"%s\" is not visible on page \"%s\"", breadcrumb, pageName),
                            ((BaseScPage) pageRegistry.lookupPage(pageName)).findBreadcrumb(breadcrumb).isDisplayed()));
        }else{
            breadcrumbs.forEach(breadcrumb ->
                    assertFalse(String.format("Breadcrumb \"%s\" should not be  visible on page \"%s\"", breadcrumb, pageName),
                            ((BaseScPage) pageRegistry.lookupPage(pageName)).findBreadcrumb(breadcrumb).isDisplayed()));
        }


    }

    @When("^I click on (.*) link$")
    public void iClickOnLinkLink(String link) throws Throwable {
        homePage.clickOnLink(link);
    }

    @Then("^I am taken to the (.*) page$")
    public void iAmTakenToThePagePage(String pageName) throws Throwable {
       assertEquals (((BaseScPage) pageRegistry.lookupPage(pageName)).getHeaderText(), webBot.findElement(By.className("header-text")).getText());
    }
}

