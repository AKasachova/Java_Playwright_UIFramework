package com.qa.orangehr.elements;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;

public class Element {
    private Page page;
    private String xPath;

    public Element(Page page, String xPath) {
        this.page = page;
        this.xPath = xPath;
    }

    protected Locator getElement() {
        return page.locator(xPath);
    }

    protected Page getPage() {
        return page;
    }

    protected

    public void click() {
        getElement().click();
    }
}
