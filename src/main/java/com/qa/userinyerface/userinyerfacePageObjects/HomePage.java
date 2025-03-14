package com.qa.userinyerface.userinyerfacePageObjects;

import com.microsoft.playwright.Page;
import com.qa.framework.elements.Element;
import com.qa.framework.elements.Link;
import com.qa.framework.elements.Message;
import com.qa.framework.pages.BasePage;

public class HomePage extends BasePage {
    private String appLogoSelector = "//div[@class='logo__icon']";
    private String introductionTitleSelector = "(//p[@class='start__paragraph'])[1]";
    private String startLinkSelector = "//a[@class='start__link']";

    public HomePage(Page page) {
        super(page);
    }

    private Element getAppLogoSelector() {
        return new Element(page, appLogoSelector);
    }

    private Message getIntroductionTitle() {
        return new Message(page, introductionTitleSelector);
    }

    private Link getStartLink() {
        return new Link(page, startLinkSelector);
    }

    public boolean isLogoVisible() {
        return getAppLogoSelector().isVisible();
    }

    public String getIntroductionText() {
        return getIntroductionTitle().getMessageText();
    }

    public void clickStartLink(){
        getStartLink().clickLink();
    }


}
