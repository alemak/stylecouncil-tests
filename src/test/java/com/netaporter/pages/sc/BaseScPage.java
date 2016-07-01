package com.netaporter.pages.sc;

import com.netaporter.test.utils.pages.AbstractPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import static org.junit.Assert.fail;

/**
 * Created by al.makarenko on 03/05/2016.
 */
public class BaseScPage extends AbstractPage {
    static final By HEADER = By.className("header-text");

    BaseScPage(String pageName, String path) {
        super(pageName, path);
    }

    static Logger logger = LoggerFactory.getLogger(AbstractPage.class);

    /*Waits for a specific element to be visible for up to 10 seconds
    */
    public void waitForElementToBeVisible(By locator) {
        // Fail fast if the element doesn't exist
        if (!webBot.exists(null, locator)) {
            fail("Could not determine if element is visible as it does not exist: " + locator);
        }

        logger.info("Waiting for element to appear " + locator);
        for (int i = 0; i <= 40; i++) {
            // find it each time to prevent selenium reference going stale
            WebElement e = webBot.findElement(locator);
            logger.info(webBot.findElement(By.xpath("//span[contains(@class, 'loadMore__loading') and contains(@class, 'is-loading')]")).toString());
            if (e.isDisplayed()) {
                logger.info("Element is visible");
                return;
            } else {
                try {
                    Thread.sleep(250);
                } catch (InterruptedException e1) {
                    e1.printStackTrace();
                }
            }
            System.out.print(".");
        }
        fail("Element did not become visible: " + locator);
    }

    /*
    Waits for a specific element to not be visible for up to 10 seconds
    */
    public void waitForElementToNotBeVisible(By locator) {
        // Return fast if the element doesn't exist
        if (!webBot.exists(null, locator)) {
            return;
        }

        logger.info("Waiting for element to disappear " + locator);
        for (int i = 0; i <= 40; i++) {
            // find it each time to prevent selenium reference going stale
            WebElement e = webBot.findElement(locator);
            if (!e.isDisplayed()) {
                logger.info("Element is not visible");
                return;
            } else {
                try {
                    Thread.sleep(250);
                } catch (InterruptedException e1) {
                    e1.printStackTrace();
                }
            }
            System.out.print(".");
        }
        fail("Element did not become invisible: " + locator);
    }

    public String getHeaderText() {
        return webBot.getElementText(HEADER);
    }

    public WebElement findBreadcrumb(String breadcrumbName) {
        return webBot.findElement(By.xpath(String.format("//div [@class=\"breadcrumbs\"]//a[contains(text(),\"%s\")]", breadcrumbName)));
    }
}
