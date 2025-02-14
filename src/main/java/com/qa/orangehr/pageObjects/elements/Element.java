package com.qa.orangehr.pageObjects.elements;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;

public class Element {
    protected Page page;
    protected String xPath;

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

    public void click() {
        getElement().click();
    }

    public void fillField(String text){
        getElement().fill(text);
    }

    public String getTextContent(){
        return getElement().textContent();
    }

    public void waitForXPathToBeAvailable(){
        page.waitForSelector(xPath);
    }

    public boolean isVisible() {
        return getElement().isVisible();
    }
}
