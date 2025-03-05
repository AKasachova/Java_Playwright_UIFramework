package com.qa.orangehr.framework.elements;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;

public class Element {
    protected Page page;
    protected String elementSelector;
    protected String comment;

    public Element(Page page, String elementSelector) {
        this.page = page;
        this.elementSelector = elementSelector;
    }

    public Element(Page page, String elementSelector, String comment) {
        this.page = page;
        this.elementSelector = elementSelector;
        this.comment = comment;
    }

    protected Locator getElement() {
        return page.locator(elementSelector);
    }

    protected Page getPage() {
        return page;
    }

    public void click() {
        getElement().click();
    }

    public void fillField(String text) {
        getElement().fill(text);
    }

    public String getTextContent() {
        return getElement().textContent();
    }

    public void waitForElementToBeAvailable() {
        page.waitForSelector(elementSelector);
    }

    public boolean isVisible() {
        return getElement().isVisible();
    }
}
