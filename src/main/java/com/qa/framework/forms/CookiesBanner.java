package com.qa.framework.forms;

import com.microsoft.playwright.Page;
import com.qa.framework.elements.Button;

public class CookiesBanner {
    private Page page;
    private String cookiesBannerSelector;
    private Button acceptCookiesButton;

    public CookiesBanner(Page page, String cookiesBannerSelector, Button acceptCookiesButton) {
        this.page = page;
        this.cookiesBannerSelector = cookiesBannerSelector;
        this.acceptCookiesButton = acceptCookiesButton;
    }

    public void waitForCookiesBannerToBeAvailable() {
        page.waitForSelector(cookiesBannerSelector).isVisible();
    }

    public void clickAcceptButton() {
        acceptCookiesButton.clickButton();
    }
}
