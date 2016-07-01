package com.netaporter.pages.sc;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

/**
 * Created by al.makarenko on 11/05/2016.
 */
@Component
@Scope("cucumber-glue")
public class MembersDetailsPage extends BaseScPage {
    private static final String PAGE_NAME = "Member Details";
    private static String memberName = "";
    private static String PATH = "members/abc/1";
    private static final By TEXTBLOCK = By.className("textBlock");
    private static final By MEMBER_IMAGE = By.xpath("//div[contains(@class, 'header-block')]/if/img");
    private static final By INTERVIEW_PROFILE_TITLE = By.className("interview__profile__title");
    private static final By INTERVIEW_PROFILE_IMAGE = By.className("interview__profile__image");
    private static final By INTERVIEW_PROFILE_NAME = By.className("interview__profile__memberName");
    private static final By INTERVIEW_PROFILE_DATE = By.className("interview__profile__date");
    private static final By MEMBER_NAME_HEADING = By.xpath("//div[contains(@class, 'heading')]/h1");
    private static final By RECOMMENDED_PRODUCTS  = By.className("recommended-products");
    private static final By RECOMMENDED_PLACES  = By.xpath("//div[contains (text(), 'Recommended Places')]");
    private static final By RECOMMENDED_PLACES_BLOCK  = By.xpath("//div[contains (text(), 'Recommended Places')]/../div/div[contains(@class, 'block__item')]");

    public MembersDetailsPage() {
        super(PAGE_NAME, PATH);
    }

    public WebElement getMemberDetailsTextBlock() {
        return webBot.findElement(TEXTBLOCK);
    }

    public WebElement getMemberImage() {
        return webBot.findElement(MEMBER_IMAGE);
    }

    public WebElement getInterviewProfileTitle() {
        return webBot.findElement(INTERVIEW_PROFILE_TITLE);
    }

    public WebElement getInterviewProfileImage() {
        return webBot.findElement(INTERVIEW_PROFILE_IMAGE);
    }

    public WebElement getInterviewProfileName() {
        return webBot.findElement(INTERVIEW_PROFILE_NAME);
    }

    public WebElement getInterviewProfileDate() {
        return webBot.findElement(INTERVIEW_PROFILE_DATE);
    }

    public WebElement getMemberNameHeading() {
        return webBot.findElement(MEMBER_NAME_HEADING);
    }

    public WebElement getRecommendedProducts() {
        return webBot.findElement(RECOMMENDED_PRODUCTS);
    }
    public WebElement getRecommendedPlaces() {
        return webBot.findElement(RECOMMENDED_PLACES);
    }
    public WebElement getFirstRecommendePlacesBlock() {
        return webBot.findElement(RECOMMENDED_PLACES_BLOCK);
    }


    public void setPath(String memberName) {
        String name = "";
        String[] names = memberName.split(" ");
        for (int i = 0; i < names.length; i++) {
            name += names[i];
            if (i < names.length - 1) name += "_";
        }
        this.path = String.format("members/%s/1", name);
        this.memberName = memberName;
    }

    public static String getMemberName() {
        return memberName;
    }

    public boolean isRecommendedPlacesBlockImageDisplayed(WebElement recommendedPlacesBlock) {
        return recommendedPlacesBlock.findElement(By.xpath(".//img[contains(@class, 'details__img')]")).isDisplayed();
    }
    public boolean isRecommendedPlacesBlockCategoryDisplayed(WebElement recommendedPlacesBlock) {
        return recommendedPlacesBlock.findElement(By.xpath(".//h3[contains(@class, 'details__job')]")).isDisplayed();
    }
    public boolean isRecommendedPlacesBlockNameDisplayed(WebElement recommendedPlacesBlock) {
        return recommendedPlacesBlock.findElement(By.xpath(".//h2[contains(@class, 'details__name')]")).isDisplayed();
    }
    public boolean isRecommendedPlacesBlockLocationDisplayed(WebElement recommendedPlacesBlock) {
        return recommendedPlacesBlock.findElement(By.xpath(".//h3[contains(@class, 'details__location')]")).isDisplayed();
    }
    public boolean isRecommendedPlacesBlockQuoteDisplayed(WebElement recommendedPlacesBlock) {
        return recommendedPlacesBlock.findElement(By.xpath(".//div[contains(@class, 'details__text')]")).isDisplayed();
    }
    public boolean isRecommendedPlacesBlockRecommendedByDisplayed(WebElement recommendedPlacesBlock) {
        return recommendedPlacesBlock.findElement(By.xpath("./h3[contains(@class, 'details__rec_no')]")).isDisplayed();
    }

}
