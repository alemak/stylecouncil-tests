package com.netaporter.pages.sc;

import com.netaporter.test.utils.pages.AbstractPage;
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
public class MembersListingPage extends BaseScPage {
    private static final String PAGE_NAME = "Member Listing";
    private static final String PATH = "members";
    private static final By MEMBER_BLOCK = By.className("block__item");
    private static final By LOAD_MORE = By.className("loadMore");
    private static final By LOAD_MORE_TEXT = By.className("loadMore__text");
    private static final By LOAD_MORE_SPINNER = By.xpath("//span[contains(@class, 'loadMore__loading') and contains(@class, 'loading')]");
    static Logger logger = LoggerFactory.getLogger(MembersListingPage.class);

    public MembersListingPage() {
        super(PAGE_NAME, PATH);
    }

    public String getHeaderText(){
        return webBot.getElementText(HEADER);
    }

    public Integer getNumberOfMembersDisplayed(){
        return webBot.findElements(MEMBER_BLOCK).size();
    }

    public String getLoadMoreText(){
        return webBot.getElementText(LOAD_MORE_TEXT);
    }
    public void loadMoreMembers(){
        webBot.click(LOAD_MORE);
        waitForElementToNotBeVisible(LOAD_MORE_SPINNER);

    }

    public boolean isMemberDetailsImageDisplayed(WebElement memberBlock) {
        return memberBlock.findElement(By.xpath(".//img[contains(@class, 'details__img')]")).isDisplayed();
    }
    public boolean isMemberDetailsJobDisplayed(WebElement memberBlock) {
        return memberBlock.findElement(By.xpath(".//div[contains(@class, 'details')]/h3[contains(@class, 'details__job')]")).isDisplayed();
    }
    public boolean isMemberDetailsNameDisplayed(WebElement memberBlock) {
        return memberBlock.findElement(By.xpath(".//div[contains(@class, 'details')]//h2[contains(@class, 'details__name')]")).isDisplayed();
    }
    public boolean isMemberDetailsLocationDisplayed(WebElement memberBlock) {
        return memberBlock.findElement(By.xpath(".//div[contains(@class, 'details')]/h3[contains(@class, 'details__location')]")).isDisplayed();
    }
    public boolean isMemberDetailsRecNoDisplayed(WebElement memberBlock) {
        return memberBlock.findElement(By.xpath("./h3[contains(@class, 'details__rec_no')]")).isDisplayed();
    }

    public WebElement getFirstMemberBlock() {
        return webBot.findElement(MEMBER_BLOCK);
    }
    public WebElement getMemberImage(WebElement memberBlock) {
        return memberBlock.findElement(By.xpath(".//img[contains(@class, 'details__img')]"));
    }
}
