package com.qa.orangehr.elements;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import java.util.List;

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

    protected List<Locator> getElements(){
       return page.locator(xPath).all();
    }

    protected Page getPage() {
        return page;
    }

    public void click() {
        getElement().click();;
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
}
