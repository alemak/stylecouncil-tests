package com.netaporter.pages.sc;

import org.openqa.selenium.By;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

/**
 * Created by al.makarenko on 04/05/2016.
 */
@Component
@Scope("cucumber-glue")
public class HomePage extends BaseScPage {

    private static final String PAGE_NAME = "Home";
    private static final String PATH = "";
    private static final By TEXT = By.xpath("/html/body/h1");

    public HomePage() {
        super(PAGE_NAME, PATH);
    }

    public String getPageText(){
        return webBot.getElementText(TEXT);
    }

    public String getHeaderText(){
        return webBot.getElementText(HEADER);
    }

    public void clickOnLink(String linkText){
        By link = By.xpath("//h1[contains(text(), '" + linkText + "')]");
        webBot.click(link);

    }
}