package com.netaporter.cucumber.steps;


import com.netaporter.pages.sc.HomePage;
import com.netaporter.pages.sc.MembersDetailsPage;
import com.netaporter.pages.sc.MembersListingPage;
import com.netaporter.pages.sc.PlacesListingPage;
import com.netaporter.test.utils.cucumber.steps.BaseStepWithWebDriver;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * Created by a.makarenko on 7/11/14.
 */
public abstract class BaseSteps extends BaseStepWithWebDriver {
    @Autowired
    protected HomePage homePage;
    @Autowired
    protected MembersListingPage memberListingPage;
    @Autowired
    protected MembersDetailsPage memberDetailsPage;
    @Autowired
    protected PlacesListingPage placesListingPage;



}
