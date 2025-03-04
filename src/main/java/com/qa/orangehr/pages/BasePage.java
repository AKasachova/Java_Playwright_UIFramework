package com.qa.orangehr.pages;

import com.microsoft.playwright.Page;

public class BasePage {
    protected Page page;

    public BasePage(Page page) {
        this.page = page;
    }

/*    protected Locator getLocator(String xPath) {
        return page.locator(xPath);
    }*/
}
