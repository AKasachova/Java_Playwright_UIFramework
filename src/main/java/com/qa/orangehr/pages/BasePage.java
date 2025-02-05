package com.qa.orangehr.pages;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import java.util.List;

public class BasePage {
    protected Page page;

    public BasePage(Page page) {
        this.page = page;
    }

    protected Locator getLocator(String xPath) {
        return page.locator(xPath);
    }

}
