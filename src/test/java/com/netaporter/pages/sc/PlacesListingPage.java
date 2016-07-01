package com.netaporter.pages.sc;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

/**
 * Created by al.makarenko on 11/05/2016.
 */
@Component
@Scope("cucumber-glue")
public class PlacesListingPage extends BaseScPage {
    private static final String PAGE_NAME = "Recommended Places Listing";
    private static final String PATH = "places";
    private static final By PLACE_BLOCK = By.className("block__item");
    private static final By LOAD_MORE = By.className("loadMore");
    private static final By LOAD_MORE_TEXT = By.className("loadMore__text");
    private static final By LOAD_MORE_SPINNER = By.xpath("//span[contains(@class, 'loadMore__loading') and contains(@class, 'loading')]");
    static Logger logger = LoggerFactory.getLogger(PlacesListingPage.class);

    public PlacesListingPage() {
        super(PAGE_NAME, PATH);
    }

    public String getHeaderText() {
        return webBot.getElementText(HEADER);
    }

    public Integer getNumberOfPlacesDisplayed() {
        return webBot.findElements(PLACE_BLOCK).size();
    }

    public String getLoadMoreText() {
        return webBot.getElementText(LOAD_MORE_TEXT);
    }

    public void loadMorePlaces() {
        webBot.click(LOAD_MORE);
        waitForElementToNotBeVisible(LOAD_MORE_SPINNER);

    }
    public WebElement getFirstPlaceBlock() {
        return webBot.findElement(PLACE_BLOCK);
    }
    public boolean isPlaceDetailsImageDisplayed(WebElement placeBlock) {
        return placeBlock.findElement(By.xpath(".//img[contains(@class, 'details__img')]")).isDisplayed();
    }
    public boolean isPlaceDetailsCategoryDisplayed(WebElement placeBlock) {
        return placeBlock.findElement(By.xpath(".//div[contains(@class, 'details')]/h3[contains(@class, 'details__job')]")).isDisplayed();
    }
    public boolean isPlaceDetailsNameDisplayed(WebElement placeBlock) {
        return placeBlock.findElement(By.xpath(".//div[contains(@class, 'details')]//h2[contains(@class, 'details__name')]")).isDisplayed();
    }
    public boolean isPlaceDetailsLocationDisplayed(WebElement placeBlock) {
        return placeBlock.findElement(By.xpath(".//div[contains(@class, 'details')]/h3[contains(@class, 'details__location')]")).isDisplayed();
    }
    public boolean isPlaceDetailsRecNoDisplayed(WebElement placeBlock) {
        return placeBlock.findElement(By.xpath("./h3[contains(@class, 'details__rec_no')]")).isDisplayed();
    }
}
